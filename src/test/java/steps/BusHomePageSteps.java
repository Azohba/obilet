package steps;

import com.thoughtworks.gauge.Step;
import pages.HomePageAll;
import utils.DriverFactory;

public class BusHomePageSteps extends DriverFactory {
    HomePageAll homePageAll = new HomePageAll();

    @Step("click login button")
    public void clickLogin() {
        homePageAll.clickLoginBtn();
    }

    @Step("click <> menu")
    public void clickMenus(String menu) {
        homePageAll.clickUyeHrefs(menu);
        //Cucumber kullanıldığında harcoded girilen text alanları aşagıdaki kullanımda verilen alanlar dışında kullanımı engellemektedir. Bu sayede hata payı azaltılmaktadır.
        //Given(/^click hesaplarim menu(profil|biletler|vs...)$/)
    }

    @Step("click plane tab")
    public void clickPlane() {
        homePageAll.clickPlaneTab();
    }


}
