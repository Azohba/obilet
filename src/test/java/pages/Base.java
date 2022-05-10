package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;


public class Base {
    private WebDriver webDriver;
    private WebDriverWait wait;
    public static Logger logger = LoggerFactory.getLogger(Base.class);

    public Base(WebDriver driver) {
        this.webDriver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }


    public void alertException(){
        ((JavascriptExecutor) webDriver).executeScript("window.onbeforeunload = function(e){};");
    }

    public String getText(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public String getTitle() {
        return webDriver.getTitle();

    }

    public void selectByText(WebElement webElement, String text) {
        Select select = new Select(webElement);
        try {
            select.selectByVisibleText(text);
        } catch (Exception e) {
            logger.error("Can't find select text:" + text + "...." + e);
        }
    }

    public void waitUntilElementVisibleAndClick(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public void waitUntilListIsLoad(List<WebElement> element){
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitUntilElementVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitFor(int... timeOut){
        int timeOutL = 2;
        if (timeOut.length!= 0){
            timeOutL = timeOut[0];
        }
        try {
            Thread.sleep(timeOutL * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getSaltString(Integer lenghtParam) {
        String SALTCHARS = "abcdefghijklmnoprstuvyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < lenghtParam) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public int getRandomNumber(){
        Random rnd = new Random();
        return (rnd.nextInt(5));
    }

    public WebElement swipeUntilElement(WebElement webElement){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).build().perform();
        return webElement;
    }


}
