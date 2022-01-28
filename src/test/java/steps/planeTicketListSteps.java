package steps;

import com.thoughtworks.gauge.Step;
import pages.planeTicketPage;
import utils.driverFactory;

public class planeTicketListSteps extends driverFactory {
    planeTicketPage planeTicketPage = new planeTicketPage(getWebDriver());

    @Step("select first flight")
    public void selectFly() {
        planeTicketPage.clickFirstPlaneTicket();
    }

    @Step("select flight class <>")
    public void selectFlyClass(String flyClass) {
    planeTicketPage.selectFlyClass(flyClass);
    }
}
