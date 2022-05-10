package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;

import static utils.DriverFactory.webdriver;

import java.util.Random;

public class RegisterPage extends Base{
    public RegisterPage() {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(name = "email")
    WebElement email;
    @FindBy(xpath = "//form[@id='register-form']//input[@type='password']" )
    WebElement password;
    @FindBy(css = ".register.register-button" )
    WebElement registerBtn;



    public void register(String e_mail)  {
        ContextMap.addContext(ContextKeys.EMAIL,e_mail+getSaltString(7)+"@gmail.com");
        ContextMap.addContext(ContextKeys.PASS,e_mail+getSaltString(7)+"@gmail.com");
        email.sendKeys(ContextMap.getContextValue(ContextKeys.EMAIL));
        password.sendKeys(ContextMap.getContextValue(ContextKeys.PASS));
        registerBtn.click();
    }

}
