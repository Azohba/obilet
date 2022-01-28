package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;

public class LoginPage extends Base {

    private static Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By username = By.xpath("(//*[@name='username'])[2]");
    private static final By password = By.xpath("(//*[@name='password'])[2]");
    private static final By loginPageLoginBtn = By.xpath("(//*[text()='Giriş Yap'])[2]");
    private static final By registerBtn = By.xpath("//*[text() ='Üye Ol']");
    private static final By loginPageTxt = By.xpath("//*[text()='Üye Girişi']");
    private static final By hesabim = By.cssSelector("[href=\"/uye/profil\"]");


    public void checkLoginPageisDisplayed() {
        if (isDisplayed(loginPageTxt)) {
            logger.info("You're in loginPage");
        } else {
            logger.error("LoginPage couldn't open");
        }
    }

    public void setLoginCredentialsAndClick() {
        sendKeys(username, ContextMap.getContextValue(ContextKeys.EMAIL));
        sendKeys(password, ContextMap.getContextValue(ContextKeys.PASS));
        click(loginPageLoginBtn);
        Assert.assertTrue(isDisplayed(hesabim));
    }
        public void clickRegister() {
            hoverElement(registerBtn);
            click(registerBtn);
        }


    }

