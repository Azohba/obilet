package steps;

import com.thoughtworks.gauge.Step;
import pages.PaymentPage;
import utils.DriverFactory;

public class PaymentPageSteps extends DriverFactory {
    PaymentPage paymentPage = new PaymentPage();
    @Step("check flight code")
    public void checkFlightCode() {
    paymentPage.checkFlightCode();
    }
}
