package steps;

import com.thoughtworks.gauge.Step;
import pages.SatinAlPageBus;

public class SatinAlPageSteps {
    SatinAlPageBus satinAlPageBus = new SatinAlPageBus();
    @Step("enter passengers informations")
    public void enterPasssengerInfos() {
    satinAlPageBus.checkTripTimeAndSeatNumber();
    satinAlPageBus.setPassengerInfo();
    }
}
