package pages;

import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;
import utils.models.SeatModel;

import static utils.DriverFactory.webdriver;
public class SatinAlPageBus extends Base{

    SeatModel seatModel = new SeatModel();
    TicketListPage ticketListPage = new TicketListPage();
    public SatinAlPageBus(){
        super(webdriver);
        PageFactory.initElements(webdriver,this);
    }
    @FindBy(id = "email")
    WebElement emailTxt;
    @FindBy(id = "phone")
    WebElement phoneTxt;
    @FindBy(xpath = "//legend[contains(text(),'Sefer')]")
    WebElement seferBilgileriTitle;
    public void checkTripTimeAndSeatNumber(){

        for (int i=0;i<ticketListPage.seatCount;i++){
            waitUntilElementVisible(seferBilgileriTitle);
            WebElement tripTime = webdriver.findElement(By.xpath("//td[contains(text(),'"+ ContextMap.getContextValue(ContextKeys.SELECTEDTRIPTIME) +"')]"));
            Assert.assertTrue("SEFER SAATI UYUSMAMAKTADIR...   Trip Time:  " + tripTime.getAttribute("alt"),tripTime.isDisplayed());
            ticketListPage.checkSelectedSeat(ticketListPage.seats.get(i).getSeatNumber());
        }
    }
    public void setPassengerInfo(){
        swipeUntilElement(emailTxt).sendKeys("onur"+getSaltString(3)+"@gs.com");
        swipeUntilElement(phoneTxt).sendKeys("0537879892" + getRandomNumber(10));
        for (int i = 1; i<=ticketListPage.seatCount;i++){
            WebElement nameSurnameTxt = webdriver.findElement(By.id("name-"+i+""));
            WebElement tcNoTxt = webdriver.findElement(By.id("gov-id-"+i+""));
            swipeUntilElement(nameSurnameTxt).sendKeys("OnurTest" + getSaltString(3));
            swipeUntilElement(tcNoTxt).sendKeys("544273568" + getSaltString(3));

        }

    }
}
