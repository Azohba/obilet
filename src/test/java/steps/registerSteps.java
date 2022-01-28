package steps;

import com.thoughtworks.gauge.Step;
import pages.registerPage;
import utils.driverFactory;

public class registerSteps extends driverFactory {
    registerPage registerPage = new registerPage(getWebDriver());

    @Step("fill register credentials <email>")
    public void fillRegisterCredentials(String email)  {
        registerPage.register(email);
    }
}
