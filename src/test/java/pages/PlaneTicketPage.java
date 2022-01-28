package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;

public class PlaneTicketPage extends Base{
    public PlaneTicketPage(WebDriver driver) {
        super(driver);
    }

    private static final By firstFlight = By.xpath("(//*[@class='amount notranslate'])[1]");
    private static final By flyClassTitles = By.cssSelector("[class='name']");
    private static final By firstFlightDetailBtn = By.xpath("(//*[@class='details'])[1]");
    private static final By flighNumber = By.xpath("//*[@class='code col']//strong");
    private static final By closeBtn = By.xpath("//*[@class='ob-modal normal pop details-modal active open']//button");
    private static final By firstFlightForReturn = By.xpath("//*[@id='return-journeys']//div[@class='amount notranslate'][1]");
    //private static final By firstFlightForDetailForReturn = By.xpath("(//*[@id='return-journeys']//*[@class='details'])[1]");
    private static final By firstFlightForDetailForReturn = By.xpath("(//*[@id='return-journeys']//*[text()='Detaylı Bilgi'])[1]");


    public void clickFirstFlightTicketforDeparture(){
        click(firstFlightDetailBtn);
        ContextMap.addContext(ContextKeys.FLIGHTNUMBER1,findElement(flighNumber).getText());
        click(closeBtn);
        click(firstFlight);
        selectFlyClass();

    }

    public void clickFirstFlightTicketforReturn()  {
        clickWithCordinate(firstFlightForDetailForReturn);
        ContextMap.addContext(ContextKeys.FLIGHTNUMBER2,findElement(flighNumber).getText());
        click(closeBtn);
        click(firstFlightForReturn);
        selectFlyClass();

    }

    public void selectFlyClass(){
        By selectFly = By.xpath("//span[text()='Ecofly (EF)']/../../..//div[@class='amount']");
        if (isDisplayed(selectFly)){
            System.out.println("This fly has " +findElement(flyClassTitles).getSize() +" class");
            click(selectFly);
        }
        }

    }


