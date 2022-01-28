package steps;

import com.thoughtworks.gauge.Step;
import pages.loginPage;
import utils.driverFactory;

public class loginsteps extends driverFactory {
    loginPage loginPage = new loginPage(getWebDriver());

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
