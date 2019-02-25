package rt.lewis.api.message;

import com.wangyin.front.message.HttpMessageAbstract;

import java.util.Map;

public class JsonHttpMessage extends HttpMessageAbstract {

    public JsonHttpMessage() {}

    public JsonHttpMessage(String requestUri){
        super(requestUri, HttpProp.DEFAULT_METHOD);
    }

    public JsonHttpMessage(String requestUri, byte[] body){
        super(requestUri, HttpProp.DEFAULT_METHOD);
        setContent(body);
        setContentType(HttpProp.CONTENT_TYPE_JSON);
    }

    public JsonHttpMessage(String requestUri, byte[] body, Map<String, String> headers){
        super(requestUri, HttpProp.DEFAULT_METHOD, HttpProp.CONTENT_TYPE_JSON, body, headers);
    }

    @Override
    public String getFuncode() {
        // TODO Auto-generated method stub
        return null;
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
}
