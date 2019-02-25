package rt.lewis.rainbow.api;

import rt.lewis.rainbow.request.BaseInputMsg;
import rt.lewis.rainbow.response.ReturnMessage;

public interface TestFacade {

    ReturnMessage test01(BaseInputMsg baseInputMsg);
}
