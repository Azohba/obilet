package steps;

import com.thoughtworks.gauge.Step;
import pages.busHomePage;
import utils.driverFactory;

public class profilePageSteps extends driverFactory {
    busHomePage busHomePage = new busHomePage(getWebDriver());
    @Step("click <cikis> button")
    public void clickHrefButton(String btn) {
        busHomePage.clickUyeHrefs(btn);
    }
}
