package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ContextKeys.userInfo;

import java.util.Random;

public class registerPage extends Base{
    public registerPage(WebDriver driver) {
        super(driver);
    }
    private static final By email = By.cssSelector("[name='email']");
    private static final By password = By.cssSelector("[name='password']");
    private static final By registerBtn = By.cssSelector(".register.register-button");

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString().toLowerCase();
        return saltStr;

    }

    public void register(String e_mail)  {
        userInfo userInfo = new userInfo();
        userInfo.setEMAIL(e_mail+getSaltString()+"@gmail.com");
        userInfo.setPASS("123B"+getSaltString());
        sendKeys(email,userInfo.getEMAIL());
        sendKeys(password,userInfo.getPASS());
        click(registerBtn);



    }

}
