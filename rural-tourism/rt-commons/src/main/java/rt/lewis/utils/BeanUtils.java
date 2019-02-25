package rt.lewis.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 对Bean进行操作的相关工具方�? * @author
 */
public class BeanUtils {
    /**
     * 将Bean对象转换成Map对象，将忽略掉�?为null或size=0的属�?	 * @param obj 对象
     *
     * @return 若给定对象为null则返回size=0的map对象
     */
	/*public static Map<String, Object> toMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj == null) {
			return map;
		}
		if(Map.class.isInstance(obj)){
		    return (Map<String,Object>)obj;
		}

		Class clazz=obj.getClass();

		BeanMap beanMap = new BeanMap(obj);
		Iterator<String> it = beanMap.keyIterator();
		while (it.hasNext()) {
			String name = it.next();
			Object value = beanMap.get(name);
			// 转换时会将类名也转换成属性，此处去掉
			if (value != null && !name.equals("class") && !name.equals("processContext") ) {
				map.put(name, value);
			}
		}
		return map;
	}*/
	public static Map<String, Object> object2Map(Object obj){

	    return object2Map(obj,false);
    }

    private static Map<String, Object> object2Map(Object obj,
                                                 boolean isContainNull) {

        Map<String, Object> map = new HashMap<String, Object>();
        // System.out.println(obj.getClass());  
// 获取f对象对应类中的所有属性域  
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
//            varName = varName.toLowerCase();//将key置为小写，默认为对象的属性  （为保证属性原样，注释掉本行）
            try {
                // 获取原来的访问控制权限  
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限  
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量  
                Object o = fields[i].get(obj);
                if(!isContainNull){
                    if (o != null)
                        map.put(varName, o.toString());
                }else{
                    map.put(varName, o.toString());
                }

                // 恢复访问控制权限  
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }

    public static Map<String, Object> toMapContainNull(Object obj) {
        return object2Map(obj,true);
    }

    /**
     * 该方法将给定的所有对象参数列表转换合并生成一个Map，对于同名属性，依次由后面替换前面的对象属�?
     *
     * @param objs 对象列表
     * @return 对于值为null的对象将忽略�?
     */
    public static Map<String, Object> toMap(Object... objs) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Object object : objs) {
            if (object != null) {
                map.putAll(toMap(object));
            }
        }
        return map;
    }

    /**
     * 获取接口的泛型类型，如果不存在则返回null
     *
     * @param clazz
     * @return
     */
    public static Class<?> getGenericClass(Class<?> clazz) {
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            return ((Class<?>) p[0]);
        }
        return null;
    }

    /**
     * 将Map转换成指定对象
     *
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static <T> T mapToObject(Map<String, Object> map, Class<T> beanClass) throws Exception {
        if (map == null)
            return null;

        T obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }

            field.setAccessible(true);
            if (null != map.get(field.getName())) {
                field.set(obj, map.get(field.getName()));
            }
        }

        return obj;
    }
}