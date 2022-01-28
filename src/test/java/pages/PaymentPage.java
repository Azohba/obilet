package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;

public class PaymentPage extends Base{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    private static final By firtFlightCode = By.xpath("(//*[@class=\"partner-info\"]//strong)[1]");
    private static final By secondFlightCode = By.xpath("(//*[@class=\"partner-info\"]//strong)[2]");

    public void checkFlightCode(){
        String firstFlight = getText(firtFlightCode).split("- ")[1];
        String secondFlight = getText(secondFlightCode).split("- ")[1];
        ContextMap.addContext(ContextKeys.FLIGTNUMBERPAYMENT1,firstFlight);
        ContextMap.addContext(ContextKeys.FLIGTNUMBERPAYMENT2,secondFlight);
        Assert.assertEquals("Flight code is not the same: ",ContextMap.getContextValue(ContextKeys.FLIGHTNUMBER1),ContextMap.getContextValue(ContextKeys.FLIGTNUMBERPAYMENT1));
        Assert.assertEquals("Flight code is not the same: ",ContextMap.getContextValue(ContextKeys.FLIGHTNUMBER2),ContextMap.getContextValue(ContextKeys.FLIGTNUMBERPAYMENT2));
        }

    }

