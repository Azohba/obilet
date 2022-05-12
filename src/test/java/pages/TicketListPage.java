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
import utils.models.SeatModel;

import java.util.ArrayList;
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
    @FindBy(id = "origin-input")
    WebElement whereFromListPage;
@FindBy(id="list")
        WebElement listSection;

    HomePageAll homePageAll = new HomePageAll();
    public static List<SeatModel> seats = new ArrayList<SeatModel>();
    public static int seatCount;

    public void checkDestinationsFromPageTitle() {
        String titleExpected = (ContextMap.getContextValue(ContextKeys.WHEREFROM) + " - " + ContextMap.getContextValue(ContextKeys.WHERETO));
       waitUntilElementVisible(filterBtn);
        String titleActual = getTitle();
        Assert.assertTrue("Listelenen seferler uyumsuz : ", titleActual.contains(titleExpected));


    }

    public void selectRandomTrip() {
        checkDestinationsFromPageTitle();
        waitFor(5);
        if (seferSonuclariList.size()==0){
            homePageAll.setSelectWhereFromListPage();
        }
        int rnd = getRandomNumber(seferSonuclariList.size());
        try {
            waitUntilElementVisibleAndClick(swipeUntilElement(seferSonuclariList.get(rnd)));
            waitUntilListIsLoad(availableSeatsList);
            ContextMap.addContext(ContextKeys.SELECTEDTRIPTIME,selectedTripTime.getText());
            ContextMap.addContext(ContextKeys.SELECTEDTRIPPRICE,selectedTripPrice.getText());

        }catch (Exception e){
          // homePageAll.selectWhereFrom();
          // waitUntilListIsLoad(seferSonuclariList);
          // waitUntilElementVisibleAndClick(swipeUntilElement(seferSonuclariList.get(rnd)));
          // waitUntilListIsLoad(availableSeatsList);
          // ContextMap.addContext(ContextKeys.SELECTEDTRIPTIME,selectedTripTime.getText());
          // ContextMap.addContext(ContextKeys.SELECTEDTRIPPRICE,selectedTripPrice.getText());

        }

    }

    public void selectAvailableSeats(int seat,String gender){
        seatCount = seat;
        SeatModel seatModel = new SeatModel();
        try{
            if(availableSeatsList.size()==0){
                selectRandomTrip();
            }
            for (int i=1;i<=seat;i++){
                int rnd = getRandomNumber(availableSeatsNumber.size());
                seatModel.setSeatNumber(availableSeatsNumber.get(rnd).getText());
                waitUntilElementVisibleAndClick(swipeUntilElement(availableSeatsList.get(rnd)));
                WebElement setGender = webdriver.findElement(By.cssSelector("[class='"+gender+" ']"));
                waitUntilElementClickable(setGender);
                seatModel.setSeatGender(setGender.getText());
                waitUntilElementVisibleAndClick(setGender);
                //seatModel.setSeatIndex(String.valueOf(i-1));
                seats.add(seatModel);
                checkSelectedSeat(seatModel.getSeatNumber());
            }
        }catch (Exception e){
                logger.info("SEFER DOLU : " + e);
          //  for (int i=1;i<=seat;i++){
          //      int rnd = getRandomNumber(availableSeatsNumber.size());
          //      seatModel.setSeatNumber(availableSeatsNumber.get(rnd).getText());
          //      waitUntilElementVisibleAndClick(swipeUntilElement(availableSeatsList.get(rnd)));
          //      WebElement setGender = webdriver.findElement(By.cssSelector("[class='"+gender+" ']"));
          //      seatModel.setSeatGender(setGender.getText());
          //      waitUntilElementVisibleAndClick(setGender);
          //      //seatModel.setSeatIndex(String.valueOf(i-1));
          //      seats.add(seatModel);
          //      checkSelectedSeat(seatModel.getSeatNumber());
          //  }
        }


    }

    public void checkSelectedSeat(String index){
        WebElement seat = webdriver.findElement(By.cssSelector("[class='seats'] [alt='"+index+"']"));
        swipeUntilElement(seat);
        Assert.assertTrue("Secilen koltuk no dogrulanmistir !!!!",seat.isDisplayed());
    }

    public void clickProceedAndPayment(){
        logger.info("LOG : CLICK PROCEED BUTTON");
        waitUntilElementVisibleAndClick(swipeUntilElement(proceedAndPaymentBtn));
    }

}
