package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;

import java.util.List;

import static utils.DriverFactory.webdriver;


public class TicketListPage extends Base {
    public static Logger logger = LoggerFactory.getLogger(TicketListPage.class);
    public TicketListPage() {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "(//*[@class='results']//ul//li)[1]")
    WebElement selectedWhereFrom;
    @FindBy(id = "destination-select")
    WebElement selectedWhereTo;
    @FindBy(css = ".container.item.journey")
    List<WebElement> seferSonuclariList;
    @FindBy(xpath = "//*[@class='container item journey open success']//*[@class='departure center col']//span")
    WebElement selectedTripTime;
    @FindBy(xpath = "//*[@class='container item journey open success']//*[@class='price right col price-top']//span")
    WebElement selectedTripPrice;
    @FindBy(css = "[class*='available']")
    List<WebElement> availableSeatsList;
    @FindBy(css = "[class*='available'] [class='s-seat-n']")
    List<WebElement> availableSeatsNumber;
    @FindBy(css = "[class*='proceed']")
    WebElement proceedAndPaymentBtn;
    @FindBy(css = "[class='action toggle']")
    WebElement filterBtn;

    public void checkDestinationsFromPageTitle() {
        String titleContains = (ContextMap.getContextValue(ContextKeys.WHEREFROM) + " - " + ContextMap.getContextValue(ContextKeys.WHERETO));
       waitUntilElementVisible(filterBtn);
        String titleOfThePage = getTitle();
        Assert.assertTrue("Listelenen seferler uyumsuz : ", titleOfThePage.contains(titleContains));


    }

    public void selectRandomTrip() {
        checkDestinationsFromPageTitle();
        int rnd = getRandomNumber();
        waitUntilListIsLoad(seferSonuclariList);
        waitUntilElementVisibleAndClick(swipeUntilElement(seferSonuclariList.get(rnd)));
        waitUntilListIsLoad(availableSeatsList);
        ContextMap.addContext(ContextKeys.SELECTEDTRIPTIME,selectedTripTime.getText());
        ContextMap.addContext(ContextKeys.SELECTEDTRIPPRICE,selectedTripPrice.getText());
    }

    public void selectAvailableSeats(int seat,String gender){
        for (int i=1;i<=seat;i++){
            int rnd = getRandomNumber();
            waitUntilElementVisibleAndClick(swipeUntilElement(availableSeatsList.get(rnd)));
            ContextMap.addContext(ContextKeys.SELECTEDSEAT,availableSeatsNumber.get(rnd).getText());
            WebElement setGender = webdriver.findElement(By.cssSelector("[class='"+gender+" ']"));
            waitUntilElementVisibleAndClick(setGender);
            checkSelectedSeat(Integer.parseInt(ContextMap.getContextValue(ContextKeys.SELECTEDSEAT)));
        }

    }

    public void checkSelectedSeat(int index){
        WebElement seat = webdriver.findElement(By.cssSelector("[class='seats'] [alt='"+index+"']"));
        Assert.assertTrue("Secilen koltuk no dogrulanmistir !!!!",seat.isDisplayed());
    }

    public void clickProceedAndPayment(){
        logger.info("LOG : CLICK PROCEED BUTTON");
        waitUntilElementVisibleAndClick(swipeUntilElement(proceedAndPaymentBtn));
    }

}
