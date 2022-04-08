package common.steps;

import com.thoughtworks.gauge.Step;
import common.PageFactory;
import common.interfaces.HomePageInterface;
import static utils.DriverFactory.webdriver;
import pages.Base;
import utils.PageLauncher;



public class CommonHomePageSteps extends Base {
    private final PageFactory factory = new PageFactory();
    public HomePageInterface homePage = factory.getHomePage(PageLauncher.appName);

    public CommonHomePageSteps() {
        super(webdriver);
    }

    @Step("check tab title")
    public void checkTabTitle() {
        homePage.checkTabTitle();
    }

}
