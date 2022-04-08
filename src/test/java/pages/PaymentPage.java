package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ContextKeys.ContextKeys;
import utils.ContextKeys.ContextMap;

import static utils.DriverFactory.webdriver;

public class PaymentPage extends Base{
    public PaymentPage() {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }
    @FindBy(xpath = "(//*[@class='partner-info']//strong)[1]" )
    WebElement firtFlightCode;
    @FindBy(xpath = "(//*[@class='partner-info']//strong)[2]")
    WebElement secondFlightCode;

    public void checkFlightCode(){
        String firstFlight = getText(firtFlightCode).split("- ")[1];
        String secondFlight = getText(secondFlightCode).split("- ")[1];
        ContextMap.addContext(ContextKeys.FLIGTNUMBERPAYMENT1,firstFlight);
        ContextMap.addContext(ContextKeys.FLIGTNUMBERPAYMENT2,secondFlight);
        Assert.assertEquals("Flight code is not the same: ",ContextMap.getContextValue(ContextKeys.FLIGHTNUMBER1),ContextMap.getContextValue(ContextKeys.FLIGTNUMBERPAYMENT1));
        Assert.assertEquals("Flight code is not the same: ",ContextMap.getContextValue(ContextKeys.FLIGHTNUMBER2),ContextMap.getContextValue(ContextKeys.FLIGTNUMBERPAYMENT2));
        }

    }

