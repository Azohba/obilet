package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;

import static utils.DriverFactory.webdriver;

import java.util.List;

public class PlaneHomePage extends Base{
    public PlaneHomePage() {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(id = "origin")
    WebElement selectWhereFrom;
    @FindBy(id = "origin-input")
    WebElement selectWhereFromTxt;
    @FindBy(id = "destination")
    WebElement selectWhereTo;
    @FindBy(id = "destination-input")
    WebElement selectWhereToText;
    @FindBy(id = "departure-input")
    WebElement departureDate;
    @FindBy(id = "return-input-placeholder")
    WebElement returnDate;
    @FindBy(id = "search-button")
    WebElement searchBtn;
    @FindBy(css = "[id='origin']>[class='results']>ul>[class='item']")
    List<WebElement> resultsWhereFrom;
    @FindBy(css = "[id='destination']>[class='results']>ul>[class='item']")
            List<WebElement> resultsWhereTo;


    RegisterPage registerPage = new RegisterPage();

    public void setSelectWhereFrom(){
        selectWhereFrom.click();
        waitFor(2);
        selectWhereFromTxt.sendKeys(registerPage.getSaltString(1));
        waitFor(3);
        resultsWhereFrom.get(0).click();

    }

    public void setSelectWhereTo(){
        selectWhereTo.click();
        waitFor(2);
        selectWhereToText.sendKeys(registerPage.getSaltString(1));
        waitFor(3);
        System.out.println("ONUR " + resultsWhereTo.get(0).getAttribute("data-value"));
        resultsWhereTo.get(0).click();
    }

    public void setDepartureDate(){
        departureDate.click();
        WebElement selectDate = webdriver.findElement(By.xpath("//*[@data-date='"+Helper.getDate()+"']"));
        selectDate.click();
    }

    public void setReturnDate(){
        returnDate.click();
        WebElement selectDate =webdriver.findElement(By.xpath("//*[@data-date='"+Helper.getDate()+"']"));
        selectDate.click();

    }

    public void clickSearchPlaneTicket(){
        searchBtn.click();
    }

}
