package steps;

import com.thoughtworks.gauge.Step;
import pages.BusHomePage;
import utils.DriverFactory;

public class BusHomePageSteps extends DriverFactory {
    BusHomePage busHomePage = new BusHomePage(getWebDriver());

    @Step("click login button")
    public void clickLogin() {
        busHomePage.clickLoginBtn();
    }

    @Step("click <> menu")
    public void clickMenus(String menu) {
        busHomePage.clickUyeHrefs(menu);
        //Cucumber kullanıldığında harcoded girilen text alanları aşagıdaki kullanımda verilen alanlar dışında kullanımı engellemektedir. Bu sayede hata payı azaltılmaktadır.
        //Given(/^click hesaplarim menu(profil|biletler|vs...)$/)
    }

    @Step("click plane tab")
    public void clickPlane() {
        busHomePage.clickPlaneTab();
    }


}