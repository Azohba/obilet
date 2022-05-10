package steps;

import com.thoughtworks.gauge.Step;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginPageSteps extends DriverFactory {
    LoginPage loginPage = new LoginPage();

    @Step("fill login credentials and click login")
    public void loginWithCredentials() throws InterruptedException {
        loginPage.setLoginCredentialsAndClick();
    }

    @Step("click register button")
    public void clickRegister() {
        loginPage.checkLoginPageisDisplayed();
        loginPage.clickRegister();
    }

    @Step("check tab title <> ")
    public void implementation1(Object page) {


    }

    @Step("fill login credentials <email> and <pass>")
    public void LoginNegatives(String email, String pass) {

    }
}
