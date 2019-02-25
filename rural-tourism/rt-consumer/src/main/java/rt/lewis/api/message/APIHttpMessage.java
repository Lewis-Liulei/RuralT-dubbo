package rt.lewis.api.message;

import com.wangyin.front.message.DefaultHttpMessage;
import com.wangyin.front.message.DefaultHttpRequest;
import com.wangyin.front.message.HttpMessageAbstract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rt.lewis.utils.string.StringUtils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import static rt.lewis.api.common.Constant.UNSUPPORTED_FUNCODE;

public class APIHttpMessage extends HttpMessageAbstract {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIHttpMessage.class);

    private static final Map<String, String> URI_CACHE = new ConcurrentHashMap<String, String>();

    private static final String FUNCODE_NAME = "/META-INF/funcodes.properties";

    static {
        Properties properties = new Properties();
        try {
            properties.load(APIHttpMessage.class.getResourceAsStream(FUNCODE_NAME));
            Enumeration enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String name = (String) enumeration.nextElement();
                String value = (String) properties.get(name);
                URI_CACHE.put(value, name);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public APIHttpMessage() {
    }

    public APIHttpMessage(int code, String contentType, byte[] body) {
        super(code, contentType, body);
    }

    private String funcode;   //not support for singleton
    private Map<String, String> paras; //not support for singleton
    private Throwable throwable;

    @Override
    public String getFuncode() {
        if (funcode != null) return funcode;
        try {
            String requestUri = getRequestUri();
            if (!StringUtils.isBlank(requestUri)) {
                requestUri = requestUri.substring(requestUri.indexOf("/") + 1);
                requestUri = getPath(requestUri);
                if (!URI_CACHE.containsKey(requestUri)) {
                    requestUri = UNSUPPORTED_FUNCODE;
                }
            } else {
                requestUri = UNSUPPORTED_FUNCODE;
            }
            return funcode = requestUri;
        } catch (Throwable e) {
            throwable = e;
            LOGGER.error("Get FunCode Error :", e.getLocalizedMessage());
            return funcode = UNSUPPORTED_FUNCODE;
        }
    }

    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * 获取请求中的path （eg: /test?sdfsf=sdfsf)
     *
     * @param uri
     * @return
     */
    public String getPath(String uri) {
        int pathEndPos = uri.indexOf('?');
        if (pathEndPos < 0) {
            return uri;
        } else {
            return uri.substring(0, pathEndPos);
        }
    }
    @Override
    public Object getBodyObject() {
        try{
            byte[] bodyBinary = getBodyBinary();
            String rspsText = new String(bodyBinary, "UTF-8");
            return rspsText;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*@Override
    public Object getBodyObject() {
        if (paras != null) return paras;
        Map<String, String> para = new HashMap<String, String>();
        //获取get参数
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(getRequestUri());
        for (Map.Entry<String, List<String>> entry : queryStringDecoder.getParameters().entrySet()) {
            List<String> list = entry.getValue();
            para.put(entry.getKey(), list != null && list.size() != 0 ? list.get(0) : null);
        }
        //获取form表单数据
        try {
            String postMsg = null;
            byte[] bodys = getBodyBinary();
            String uuid = UniqueIDUtils.createID();
            para.put(Constant.UUID, uuid);
            Charset charset = getHttpMessage().getEntityCharset();
            charset = charset != null ? charset : Charset.forName(CHARSET);
            para.put(Constant.CHARSET_KEY, charset.name());
            if (bodys != null && bodys.length != 0) {
                postMsg = new String(bodys, charset);
                String[] pairs = postMsg.split("&");
                for (String pair : pairs) {
                    if (isEmpty(pair))
                        continue;
                    String[] kv = pair.split("=");
                    if (kv.length != 2) {
                        continue;
                    }
                    String key = kv[0];
                    String value = null;
                    if (!isEmpty(kv[1]))
                        value = URLDecoder.decode(kv[1], charset.name());
                    para.put(key, value);
                }
            }
            if (LOGGER.isInfoEnabled())
                LOGGER.info(getRequestUri(), " recv msg [id:", uuid, "] :", postMsg);
            return paras = para;
        } catch (IOException e) {
            throw new RuntimeException("APIHttpMessage get parameter error ", e);
        }
    }*/

    public void addParameter(String key, String value) {
        DefaultHttpMessage message = getHttpMessage();
        if (message != null && message instanceof DefaultHttpRequest) {
            DefaultHttpRequest req = (DefaultHttpRequest) message;
            req.addParameter(key, value);
            LOGGER.debug("addParameter key:", key, ",value:", value);
        }
    }

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public boolean hasAttribute(String name) {
        return attributes.containsKey(name);
    }

    /**
     * store attribute
     */
    private Map<String, Object> attributes = new HashMap<String, Object>();
}
