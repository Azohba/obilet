package steps;

import com.thoughtworks.gauge.Step;
import pages.BusHomePage;
import utils.DriverFactory;
import static constants.constant.HOME_PAGE_TITLE;


public class AppLauncherSteps extends DriverFactory {
    BusHomePage busHomePage = new BusHomePage(getWebDriver());

    @Step("go to homepage")
    public void goToHomePage() {
        getWebDriver().navigate().to(System.getenv("URI"));
        busHomePage.checkTitle(HOME_PAGE_TITLE);
    }
}
