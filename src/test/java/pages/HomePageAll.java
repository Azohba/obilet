package pages;

import com.github.javaparser.utils.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;
import utils.Helper;

import java.util.List;

import static utils.DriverFactory.webdriver;


public class HomePageAll extends Base {


    public HomePageAll() {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(css = "[class=login]")
    WebElement loginBtn;
    @FindBy(xpath = "(//a[@href='/ucak-bileti'])[1]")
    WebElement planeTabBtn;
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
    @FindBy(css = "[id='search-button']")
    WebElement searchBtn;
    @FindBy(css = "[id='origin']>[class='results']>ul>[class='item']")
    List<WebElement> resultsWhereFrom;
    @FindBy(css = "[id='destination']>[class='results']>ul>[class='item']")
    List<WebElement> resultsWhereTo;


    public void selectWhereFrom() {

        logger.info("click selectWhereFrom : " + selectWhereFrom);
        waitUntilElementVisibleAndClick(selectWhereFrom);
        selectWhereFromTxt.sendKeys(getSaltString(1));
        waitFor(2);
        ContextMap.addContext(ContextKeys.WHEREFROM, resultsWhereFrom.get(0).getText());
        waitUntilElementVisibleAndClick(resultsWhereFrom.get(0));


    }

    public void selectWhereTo() {
        logger.info("click selectWhereTo   : " + selectWhereTo);
        waitUntilElementVisibleAndClick(selectWhereTo);
        selectWhereToText.sendKeys(getSaltString(1));
        waitFor(2);
        ContextMap.addContext(ContextKeys.WHERETO, resultsWhereTo.get(1).getText());
        waitUntilElementVisibleAndClick(resultsWhereTo.get(1));

    }

    public void setDepartureDate() {
        waitFor(2);
        waitUntilElementVisibleAndClick(departureDate);
        WebElement selectDate = webdriver.findElement(By.xpath("//*[@data-date='" + Helper.getDate() + "']"));
        waitUntilElementVisibleAndClick(selectDate);
    }


    public void clickLoginBtn() {
        loginBtn.click();
    }


    public void clickUyeHrefs(String menu) {
        WebElement menus = webdriver.findElement(By.xpath("(//*[@href='/uye/" + menu + "'])[1]"));
        waitUntilElementVisibleAndClick(menus);
    }

    public void clickPlaneTab() {
        waitUntilElementVisibleAndClick(planeTabBtn);

    }

    public void clickSearchTicket() {
        waitFor(2);
        waitUntilElementVisibleAndClick(searchBtn);
    }
}
