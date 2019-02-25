package rt.lewis.facade;


import org.springframework.stereotype.Component;

import rt.lewis.rainbow.api.TestFacade;
import rt.lewis.rainbow.request.BaseInputMsg;
import rt.lewis.rainbow.response.ReturnMessage;
import rt.lewis.rainbow.response.WSSuccessReturnMessage;

import java.util.HashMap;
import java.util.Map;

@Component("testFacade")
public class TestFacadeImp implements TestFacade {

    @Override
    public ReturnMessage test01(BaseInputMsg baseInputMsg) {
        Map<String,Object> map= new HashMap<>();
        map.put("hello","world");
        return new WSSuccessReturnMessage(map);
    }
}
