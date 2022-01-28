package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.contextMap;

import java.util.Random;

public class registerPage extends Base{
    public registerPage(WebDriver driver) {
        super(driver);
    }
    private static final By email = By.cssSelector("[name='email']");
    private static final By password = By.cssSelector("[name='password']");
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
        contextMap.addContext(ContextKeys.EMAIL,e_mail+getSaltString()+"@gmail.com");
        contextMap.addContext(ContextKeys.PASS,"123B"+getSaltString());
        sendKeys(email,contextMap.getContextValue(ContextKeys.EMAIL));
        sendKeys(password,contextMap.getContextValue(ContextKeys.PASS));
        click(registerBtn);



    }

}
