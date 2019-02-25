package rt.lewis.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import rt.lewis.utils.string.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

public class JsonUtil {

	private static  Gson timestampGson;
	//public  static  Gson gsonNulls=new GsonBuilder().serializeNulls().create();
	public  static  Gson gson = new Gson();

	static{
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter())
				.setDateFormat("yyyy-MM-dd");
		timestampGson = builder.create();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map convertToMap(String jsonStr) {

		return fromJSONToObject(jsonStr,Map.class);
		//return gson.fromJson(jsonStr,Map.class);
	}

	public static String convertArrayToString(Object jsArray, String split) {
		if ((jsArray == null) || (!(jsArray instanceof JsonArray))) {
			return null;
		}
		JsonArray localJSONArray = (JsonArray) jsArray;
		if (StringUtils.isBlank(split)) {
			split = ",";
		}
		StringBuffer localStringBuffer = new StringBuffer();
		for (int i = 0; i < localJSONArray.size(); i++) {
			if (i > 0) {
				localStringBuffer.append(split);
			}
			localStringBuffer.append(localJSONArray.get(i).toString());
		}
		return localStringBuffer.toString();
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static <T> List<T> paserJsonArray(Class clazz, String jsArrayStr) {
		if ((StringUtils.isBlank(jsArrayStr)) || (jsArrayStr.equals("[]"))||clazz==null) {
			return new ArrayList();
		}

		Type type = new ParameterizedTypeImpl(clazz);
		List<T> list =  new Gson().fromJson(jsArrayStr, type);
		return list;
	}

	private static class ParameterizedTypeImpl implements ParameterizedType {
		Class clazz;

		public ParameterizedTypeImpl(Class clz) {
			clazz = clz;
		}

		@Override
		public Type[] getActualTypeArguments() {
			return new Type[]{clazz};
		}

		@Override
		public Type getRawType() {
			return List.class;
		}

		@Override
		public Type getOwnerType() {
			return null;
		}
	}
	public static String paserJsonObject(Object obj) {
		String json=gson.toJson(obj);
		json = json.substring(1, json.length() - 1);
		return json;
	}


	/**
	 * 会格式化Timestamp日期类型为格式yyyy-MM-dd
	 * @param obj
	 * @return
	 */
	public static String toJSON(Object obj) {
		return timestampGson.toJson(obj);
	}
	
	/**
	 * 直接调用Gson原生的toJson方法。不做任何格式转换
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj){
		return gson.toJson(obj);
	}



/*	public static void registerJsonConfig(JsonConfig jsonConfig) {
		jsonConfig.registerJsonValueProcessor(Timestamp.class,
				new JsonDateValueProcessor());
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new JsonDateValueProcessor());
	}*/

	public static <T> T fromJSONToObject(String json, Class<T> clazz) {
		return timestampGson.fromJson(json, clazz);
	}

	public static <T> List<T> fromJSONToList(String json, Type type) {
		return timestampGson.fromJson(json, type);
	}

	public static List<Map<String, Object>> fromJSONToListKeyMaps(String json) {
		return timestampGson.fromJson(json, new TypeToken<List<Map<String, Object>>>() {
		}.getType());
	}
	
	public static Map<String,Map<String, Object>> fromJSONToMapKeyMaps(String json) {
		return timestampGson.fromJson(json, new TypeToken<Map<String,Map<String, Object>>>() {
		}.getType());
	}

	public static Map<String, Object> fromJSONToMaps(String json) {
		Map<String, Object> map = timestampGson.fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());
		if (null == map) {
			return new HashMap<String, Object>();
		}
		return map;
	}

	public static <T> Map<String, T> fromJSONToMaps(String json, Type type) {
		Map<String, T> map = timestampGson.fromJson(json, type);
		if (null == map) {
			return new HashMap<String, T>();
		}
		return map;
	}


}
