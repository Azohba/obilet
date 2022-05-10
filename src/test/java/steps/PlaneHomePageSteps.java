package steps;

import com.thoughtworks.gauge.Step;
import pages.HomePageAll;
import pages.PlaneHomePage;
import utils.DriverFactory;



public class PlaneHomePageSteps extends DriverFactory {
    HomePageAll homePageAll = new HomePageAll();
    PlaneHomePage planeHomePage = new PlaneHomePage();

    @Step("select where from")
    public void selectWhereFrom() {
        homePageAll.selectWhereFrom();
    }

    @Step("select where to")
    public void selectWhereTo()  {
        homePageAll.selectWhereTo();
    }

    @Step("select departure date")
    public void selectDepartureDate() {
        homePageAll.setDepartureDate();
    }

    @Step("select return date")
    public void selectReturnDate() {
        planeHomePage.setPlaneReturnDate();
    }

    @Step("click search ticket")
    public void clickSearch() {
        homePageAll.clickSearchTicket();
    }
}
