package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverFactory.webdriver;


public class BusHomePage extends Base {

    public BusHomePage() {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }


    @FindBy(css = "[class=login]")
    WebElement loginBtn;
    @FindBy(xpath = "(//a[@href='/ucak-bileti'])[1]")
     WebElement planeTabBtn;


    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void checkTitle(String expectedTitle) {
        String actualTitle = getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public void clickUyeHrefs(String menu) {
        WebElement menus =webdriver.findElement(By.xpath("(//*[@href='/uye/" + menu + "'])[1]")) ;
        waitUntilElementVisible(menus);
        menus.click();
    }

    public void clickPlaneTab() {
        waitUntilElementVisible(planeTabBtn);
        planeTabBtn.click();
    }
}
