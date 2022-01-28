package steps;

import com.thoughtworks.gauge.Step;
import pages.busHomePage;
import utils.driverFactory;
import static constants.constant.HOME_PAGE_TITLE;


public class appLauncherSteps extends driverFactory {
    busHomePage busHomePage = new busHomePage(getWebDriver());
    @Step("check homepage title")
    public void openHomePage() {
        busHomePage.checkTitle(HOME_PAGE_TITLE);
    }
}
