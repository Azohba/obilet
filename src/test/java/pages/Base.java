package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base {
    private static Logger logger = LoggerFactory.getLogger(Base.class);
    WebDriver driver = null;
    WebDriverWait wait = null;

    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 45);
    }


    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);

    }

    public void alertException(){

        ((JavascriptExecutor) driver).executeScript("window.onbeforeunload = function(e){};");
    }

    public void sendKeys(By by, String text) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        findElement(by).sendKeys(text);
    }


    public void click(By by) {
       // wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public String getText(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public String getTitle() {
        return driver.getTitle();

    }

    public void selectByText(By by, String text) {
        Select select = new Select(findElement(by));
        try {
            select.selectByVisibleText(text);
        } catch (Exception e) {
            logger.error("Can't find select text:" + text + "...." + e);
        }
    }

    public void waitUntilElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean isDisplayed(By by) {
        try {
            return findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

}
