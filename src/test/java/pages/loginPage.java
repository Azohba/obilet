package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ContextKeys.userInfo;

public class loginPage extends Base {

    private static Logger logger = LoggerFactory.getLogger(loginPage.class);

    public loginPage(WebDriver driver) {
        super(driver);
    }

    private static final By username = By.cssSelector("[name='username']");
    private static final By password = By.cssSelector("[name='password']");
    private static final By loginPageLoginBtn = By.xpath("//*[text()='Giriş Yap']");
    private static final By registerBtn = By.xpath("//*[text() ='Üye Ol']");
    private static final By loginPageTxt = By.xpath("//*[text()='Üye Girişi']");


    public void checkLoginPageisDisplayed() {
        if (isDisplayed(loginPageTxt)) {
            logger.info("You're in loginPage");
        } else {
            logger.error("LoginPage couldn't open");
        }
    }

    public void setLoginCredentialsAndClick() {
        userInfo userInfo = new userInfo();
        sendKeys(username, userInfo.getEMAIL());
        sendKeys(password, userInfo.getPASS());
        click(loginPageLoginBtn);
    }
        public void clickRegister() {
            hoverElement(registerBtn);
            click(registerBtn);
        }


    }

