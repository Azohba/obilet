package utils;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
   public static WebDriver webdriver;
    @BeforeSuite
    public void setup(){
        String browser = System.getenv("BROWSER");
        if (browser.equalsIgnoreCase("FIREFOX")){
            setWebdriver(new FirefoxDriver());
        }else
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        setWebdriver(new ChromeDriver(chromeOptions));
        DriverFactory.getWebDriver().manage().deleteAllCookies();
    }

    public static WebDriver getWebDriver(){
        return webdriver;
    }

public static void setWebdriver(WebDriver webDriver){
        DriverFactory.webdriver = webDriver;
}
@AfterSuite
    public void closeDriver(){
        DriverFactory.getWebDriver().quit();
    }

}

