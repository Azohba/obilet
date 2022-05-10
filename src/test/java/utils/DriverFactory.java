package utils;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;


public class DriverFactory {
   public static WebDriver webdriver;
   public static RemoteWebDriver remoteWebDriver;


    @BeforeSuite
    public void setup(){
        String browser = System.getenv("BROWSER");
        if (browser.equalsIgnoreCase("FIREFOX")){
            setWebdriver(new FirefoxDriver());
        }if (browser.equalsIgnoreCase("MOBILE")){
           System.setProperty("webdriver.chrome.driver", "C://driver//chromedriver.exe");
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "Nexus 5");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("enable-automation");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-notifications");
            setWebdriver(new ChromeDriver(chromeOptions));
        }
        else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("enable-automation");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-notifications");
            setWebdriver(new ChromeDriver(chromeOptions));
            DriverFactory.getWebDriver().manage().deleteAllCookies();
        }
    }

    public static WebDriver getWebDriver(){
        return webdriver;
    }

public static void setWebdriver(WebDriver webDriver){
        webdriver = webDriver;
}
@AfterSuite
    public void closeDriver(){
        DriverFactory.getWebDriver().quit();
    }

}

