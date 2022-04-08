package steps;

import com.thoughtworks.gauge.Step;
import pages.PlaneHomePage;
import utils.DriverFactory;



public class PlaneHomePageSteps extends DriverFactory {
    PlaneHomePage planeHomePage = new PlaneHomePage();

    @Step("select where from")
    public void selectWhereFrom() {
        planeHomePage.setSelectWhereFrom();
    }

    @Step("select where to")
    public void selectWhereTo()  {
        planeHomePage.setSelectWhereTo();
    }

    @Step("select departure date")
    public void selectDepartureDate() {
        planeHomePage.setDepartureDate();
    }

    @Step("select return date")
    public void selectReturnDate() {
        planeHomePage.setReturnDate();
    }

    @Step("click search plane ticket")
    public void clickSearch() {
        planeHomePage.clickSearchPlaneTicket();
    }
}
