package common.pages.plane;

import common.interfaces.HomePageInterface;
import org.junit.Assert;
import pages.Base;

import static constants.constant.PLANE_PAGE_TITLE;
import static utils.DriverFactory.webdriver;

public class PlaneHomePage extends Base implements HomePageInterface {

    public PlaneHomePage() {
        super(webdriver);
    }

    @Override
    public void checkTabTitle() {
        String actualTitle = getTitle();
        Assert.assertEquals(PLANE_PAGE_TITLE, actualTitle);

    }
}
