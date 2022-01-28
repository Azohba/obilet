package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ContextKeys.flightInfo;

public class planeTicketPage extends Base{
    public planeTicketPage(WebDriver driver) {
        super(driver);
    }

    private static final By firstPlaneTicket = By.xpath("(//*[@class='amount notranslate'])[1]");
    private static final By flyClassTitles = By.cssSelector("[class='name']");
    private static final By firstFlightDetailBtn = By.xpath("(//*[@class='details'])[1]");
    private static final By flighNumber = By.xpath("//*[@class='code col']//strong");
    private static final By closeBtn = By.xpath("//*[@class='ob-modal normal pop details-modal active open']//button");


    public void clickFirstPlaneTicket(){
        click(firstPlaneTicket);
        getFlightNumber();
    }

    public void selectFlyClass(String flyClass){
        System.out.println("This fly has " +findElement(flyClassTitles).getSize() +" class");
        By selectFly = By.xpath("//span[text()='"+flyClass+"']/../../..//div[@class='amount']");
        click(selectFly);
        }

       public void getFlightNumber(){
        click(firstFlightDetailBtn);
           flightInfo flightInfo = new flightInfo();
           flightInfo.setFlightNo(findElement(flighNumber).getText());
           click(closeBtn);
       }
    }


