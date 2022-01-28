package steps;

import com.thoughtworks.gauge.Step;
import pages.busHomePage;
import pages.planeHomePage;
import utils.driverFactory;

import static constants.constant.PLANE_PAGE_TITLE;

public class planeHomePageSteps extends driverFactory {
    busHomePage busHomePage = new busHomePage(getWebDriver());
    planeHomePage planeHomePage = new planeHomePage(getWebDriver());

    @Step("check plane tab title")
    public void checkPlaneTabTitle() {
        busHomePage.checkTitle(PLANE_PAGE_TITLE);
    }

    @Step("select where from <>")
    public void selectWhereFrom(String state) {
        planeHomePage.setSelectWhereFrom(state);
    }

    @Step("select where to <>")
    public void selectWhereTo(String state) {
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
