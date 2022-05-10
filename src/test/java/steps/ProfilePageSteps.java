package steps;

import com.thoughtworks.gauge.Step;
import pages.HomePageAll;
import utils.DriverFactory;

public class ProfilePageSteps extends DriverFactory {
    HomePageAll homePageAll = new HomePageAll();
    @Step("click <cikis> button")
    public void clickHrefButton(String btn) {
        homePageAll.clickUyeHrefs(btn);
    }
}
