package steps;

import com.thoughtworks.gauge.Step;
import pages.RegisterPage;
import utils.DriverFactory;

public class RegisterPageSteps extends DriverFactory {
    RegisterPage registerPage = new RegisterPage();

    @Step("fill register credentials <email>")
    public void fillRegisterCredentials(String email)  {
        registerPage.register(email);
    }
}
