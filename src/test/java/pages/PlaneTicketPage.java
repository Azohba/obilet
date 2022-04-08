package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;

import static utils.DriverFactory.webdriver;

public class PlaneTicketPage extends Base{
    public PlaneTicketPage() {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "(//*[@class='amount notranslate'])[1]")
    WebElement firstFlight;
    @FindBy(css = "[class='name']")
    WebElement flyClassTitles;
    @FindBy(xpath = "(//*[@class='details'])[1]")
    WebElement firstFlightDetailBtn;
    @FindBy(xpath = "//*[@class='code col']//strong")
    WebElement flightNumber;
    @FindBy(xpath = "//*[@class='ob-modal normal pop details-modal active open']//button" )
    WebElement closeBtn;
    @FindBy(xpath = "//*[@id='return-journeys']//div[@class='amount notranslate'][1]")
    WebElement firstFlightForReturn;
    @FindBy(xpath = "(//*[@id='return-journeys']//*[text()='Detaylı Bilgi'])[1]")
    WebElement firstFlightForDetailForReturn;


    public void clickFirstFlightTicketforDeparture(){
        firstFlightDetailBtn.click();
        ContextMap.addContext(ContextKeys.FLIGHTNUMBER1,flightNumber.getText());
        closeBtn.click();
        firstFlight.click();
        selectFlyClass();

    }

    public void clickFirstFlightTicketforReturn()  {
        firstFlightForDetailForReturn.click();
        ContextMap.addContext(ContextKeys.FLIGHTNUMBER2,flightNumber.getText());
        closeBtn.click();
        firstFlightForReturn.click();
        selectFlyClass();

    }

    public void selectFlyClass(){
        WebElement selectFly =webdriver.findElement(By.xpath("//span[text()='Ecofly (EF)']/../../..//div[@class='amount']"));
        if (selectFly.isDisplayed()){
            System.out.println("This fly has " +flyClassTitles.getSize() +" class");
            selectFly.click();
        }
        }

    }


