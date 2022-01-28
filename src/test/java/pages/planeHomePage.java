package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class planeHomePage extends Base{
    public planeHomePage(WebDriver driver) {
        super(driver);
    }
    private static By selectWhereFrom = By.id("origin");
    private static By selectWhereTo = By.id("destination-input");
    private static By departureDate = By.id("departure-input");
    private static By returnDate=By.id("return-input-placeholder");
    private static By searchBtn=By.id("search-button");

    public void setSelectWhereFrom(String state)  {
        By selectState = By.xpath("//*[text()='"+state+"']");
        click(selectWhereFrom);
        waitUntilElementVisible(selectState);
        alertException();
        click(selectState);
    }

    public void setSelectWhereTo(String state) {
        By selectState = By.xpath("//*[text()='"+state+"']");
        click(selectWhereTo);
        click(selectState);
    }

    public void setDepartureDate(String date){
        click(departureDate);
        By selectDate = By.xpath("//*[@data-date='"+date+"']");
        click(selectDate);
    }

    public void setReturnDate(String date){
        click(returnDate);
        By selectDate = By.xpath("//*[@data-date='"+date+"']");
        click(selectDate);

    }

    public void clickSearchPlaneTicket(){
        click(searchBtn);
    }

}
