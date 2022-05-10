package common.pages.ferry;

import static constants.constant.FERRY_PAGE_TITLE;
import static utils.DriverFactory.webdriver;

import common.interfaces.HomePageInterface;
import org.junit.Assert;
import pages.Base;

public class FerryHomePage extends Base  implements HomePageInterface {
    public FerryHomePage() {
        super(webdriver);
    }

    @Override
    public void checkTabTitle() {
        String actualTitle = getTitle();
        Assert.assertEquals(FERRY_PAGE_TITLE,actualTitle);
    }
}
