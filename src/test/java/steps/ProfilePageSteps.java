package steps;

import com.thoughtworks.gauge.Step;
import pages.BusHomePage;
import utils.DriverFactory;

public class ProfilePageSteps extends DriverFactory {
    BusHomePage busHomePage = new BusHomePage();
    @Step("click <cikis> button")
    public void clickHrefButton(String btn) {
        busHomePage.clickUyeHrefs(btn);
    }
}
