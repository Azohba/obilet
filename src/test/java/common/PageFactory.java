package common;

import common.interfaces.HomePageInterface;
import common.pages.bus.BusHomePage;
import common.pages.ferry.FerryHomePage;
import common.pages.plane.PlaneHomePage;
import org.junit.Assert;

public class PageFactory {
    public HomePageInterface getHomePage(String domainName) {
        switch (domainName.toLowerCase()) {
            case "ucak-bileti":
                return new PlaneHomePage();
            case "bus":
                return new BusHomePage();

           case "feribot-bileti":
               return new FerryHomePage();

            default:
                Assert.fail("No such domain was identified in HomePageFactory");
                return null;
        }

    }
}
