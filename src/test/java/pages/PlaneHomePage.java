package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;

import java.util.List;

import static utils.DriverFactory.webdriver;

public class PlaneHomePage extends Base{
    public PlaneHomePage() {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(id = "return-input-placeholder")
    WebElement returnDate;


    public void setPlaneReturnDate(){
        returnDate.click();
        WebElement selectDate =webdriver.findElement(By.xpath("//*[@data-date='"+Helper.getDate()+"']"));
        selectDate.click();

    }



}
