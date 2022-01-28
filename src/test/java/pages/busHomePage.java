package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class busHomePage extends Base {
    private static final By loginBtn = By.cssSelector("[class=login]");
    private static final By planeTabBtn= By.xpath("(//a[@href='/ucak-bileti'])[1]");


    public busHomePage(WebDriver driver) {
        super(driver);
    }



    public void clickLoginBtn(){
    click(loginBtn);
    }

    public void checkTitle(String expectedTitle) {
        String actualTitle = getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickUyeHrefs(String menu){
        By menus= By.xpath("(//*[@href='/uye/"+menu+"'])[1]");
        waitUntilElementVisible(menus);
        click(menus);
    }

    public void clickPlaneTab(){
        click(planeTabBtn);
    }
}
