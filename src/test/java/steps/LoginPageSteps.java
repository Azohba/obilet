package steps;

import com.thoughtworks.gauge.Step;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginPageSteps extends DriverFactory {
    LoginPage loginPage = new LoginPage(getWebDriver());

    @Step("fill login credentials and click login")
    public void loginWithCredentials() throws InterruptedException {
        loginPage.setLoginCredentialsAndClick();
    }

    @Step("click register button")
    public void clickRegister() {
        loginPage.checkLoginPageisDisplayed();
    loginPage.clickRegister();
    }
}
