package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;

import static utils.DriverFactory.webdriver;

public class LoginPage extends Base {

    private static Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage() {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "(//*[@name='username'])[2]")
    WebElement username;
    @FindBy(xpath = "(//*[@name='password'])[2]")
    WebElement password;
    @FindBy(xpath = "(//*[text()='Giriş Yap'])[2]")
    WebElement loginPageLoginBtn;
    @FindBy(xpath = "//*[text() ='Üye Ol']")
    WebElement registerBtn;
    @FindBy(xpath = "//*[text()='Üye Girişi']")
    WebElement loginPageTxt;
    @FindBy(css ="[href='/uye/profil']")
    WebElement hesabim;


    public void checkLoginPageisDisplayed() {
        if (loginPageTxt.isDisplayed()) {
            logger.info("You're in loginPage");
        } else {
            logger.error("LoginPage couldn't open");
        }
    }

    public void setLoginCredentialsAndClick() {
        username.sendKeys(ContextMap.getContextValue(ContextKeys.EMAIL));
        password.sendKeys(ContextMap.getContextValue(ContextKeys.PASS));
        loginPageLoginBtn.click();
        Assert.assertTrue(hesabim.isDisplayed());
    }
        public void clickRegister() {
            hoverElement(registerBtn);
            registerBtn.click();
        }


    }

