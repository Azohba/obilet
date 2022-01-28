package utils;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class driverFactory {
    static WebDriver webdriver = null;
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
        getWebDriver().navigate().to(System.getenv("URI"));
        driverFactory.getWebDriver().manage().deleteAllCookies();
    }

    public static WebDriver getWebDriver(){
        return webdriver;
    }

public static void setWebdriver(WebDriver webDriver){
        driverFactory.webdriver = webDriver;
}
@AfterSuite
    public void closeDriver(){
        driverFactory.getWebDriver().quit();
    }

}

