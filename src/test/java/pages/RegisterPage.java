package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;

import java.util.Random;

public class RegisterPage extends Base{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private static final By email = By.name("email");
    private static final By password = By.xpath("//form[@id='register-form']//input[@type='password']");
    private static final By registerBtn = By.cssSelector(".register.register-button");

    protected String getSaltString() {
        String SALTCHARS = "abcdefghijklmnoprstuvyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public void register(String e_mail)  {
        ContextMap.addContext(ContextKeys.EMAIL,e_mail+getSaltString()+"@gmail.com");
        ContextMap.addContext(ContextKeys.PASS,e_mail+getSaltString()+"@gmail.com");
        sendKeys(email, ContextMap.getContextValue(ContextKeys.EMAIL));
        sendKeys(password, ContextMap.getContextValue(ContextKeys.PASS));
        click(registerBtn);



    }

}
