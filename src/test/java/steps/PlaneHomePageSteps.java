package steps;

import com.thoughtworks.gauge.Step;
import pages.BusHomePage;
import pages.PlaneHomePage;
import utils.DriverFactory;

import static constants.constant.PLANE_PAGE_TITLE;

public class PlaneHomePageSteps extends DriverFactory {
    BusHomePage busHomePage = new BusHomePage(getWebDriver());
    PlaneHomePage planeHomePage = new PlaneHomePage(getWebDriver());

    @Step("check plane tab title")
    public void checkPlaneTabTitle() {
        busHomePage.checkTitle(PLANE_PAGE_TITLE);
    }

    @Step("select where from <>")
    public void selectWhereFrom(String state) {
        planeHomePage.setSelectWhereFrom(state);
    }

    @Step("select where to <>")
    public void selectWhereTo(String state) throws InterruptedException {
        planeHomePage.setSelectWhereTo(state);
    }

    @Step("select departure date <>")
    public void selectDepartureDate(String date) {
        planeHomePage.setDepartureDate(date);
    }

    @Step("select return date <>")
    public void selectReturnDate(String date) {
        planeHomePage.setReturnDate(date);
    }

    @Step("click search plane ticket")
    public void clickSearch() {
        planeHomePage.clickSearchPlaneTicket();
    }
}
