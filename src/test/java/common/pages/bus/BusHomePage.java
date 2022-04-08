package common.pages.bus;

import common.interfaces.HomePageInterface;
import org.junit.Assert;
import pages.Base;

import static constants.constant.HOME_PAGE_TITLE;
import static utils.DriverFactory.webdriver;

public class BusHomePage extends Base implements HomePageInterface {

    public BusHomePage() {
        super(webdriver);
    }

    @Override
    public void checkTabTitle() {
        String actual_title = getTitle();
        Assert.assertEquals(HOME_PAGE_TITLE,actual_title);
    }
}
