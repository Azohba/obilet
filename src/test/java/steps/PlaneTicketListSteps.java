package steps;

import com.thoughtworks.gauge.Step;
import pages.PlaneTicketPage;
import utils.DriverFactory;

public class PlaneTicketListSteps extends DriverFactory {
    PlaneTicketPage planeTicketPage = new PlaneTicketPage();

    @Step("select first flight to departure")
    public void selectFly() {
        planeTicketPage.clickFirstFlightTicketforDeparture();
    }

    @Step("select first flight to return")
    public void selectFlyReturn() {
        planeTicketPage.clickFirstFlightTicketforReturn();
    }
}
