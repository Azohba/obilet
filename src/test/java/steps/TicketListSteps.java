package steps;

import com.thoughtworks.gauge.Step;
import pages.TicketListPage;

public class TicketListSteps {
    TicketListPage ticketListPage = new TicketListPage();

    @Step("select random trip")
    public void selectRandomTrip() {
        ticketListPage.selectRandomTrip();
    }


    @Step({"select <> passenger, random seat and choose <> gender"})
    public void selectSeat(int passenger, String gender) {
        ticketListPage.selectAvailableSeats(passenger, gender);
    }

    @Step("click proceed and payment button")
    public void clickProceed() {
        ticketListPage.clickProceedAndPayment();
    }
}
