package utils;

import com.thoughtworks.gauge.Step;
import static utils.DriverFactory.getWebDriver;

public class PageLauncher {
    public static String APP_URL;
    public static String appName;

    @Step("go to <pageName> homepage")
    public void goToHomePage(String pageName) {
        appName = pageName;
        APP_URL = System.getenv("URL") + pageName;
        if(pageName.equals("bus")){APP_URL = System.getenv("URL");}
        getWebDriver().navigate().to(APP_URL);
    }


}
