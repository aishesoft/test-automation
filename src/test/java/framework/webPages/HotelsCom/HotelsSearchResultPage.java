package framework.webPages.HotelsCom;

import framework.webPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelsSearchResultPage extends BasePage {

        private By fiveStarCheckBox = By.xpath("//input[@id='f-star-rating-5']");
        private By fourStarCheckBox = By.xpath("//input[@id='f-star-rating-4']");
        private By threeStarCheckBox = By.xpath("//input[@id='f-star-rating-3']");
        private By todaysDealWrap = By.xpath("//li[@class='hotel deal-of-the-day vip family-friendly recently-viewed-badge-available']");
        private By todaysDealPrice = By.xpath("//ins[contains(text(),'$')]");

    public void dynamicScrollTillEndOfSearResult() throws InterruptedException {
        dynamicScrolling();
    }

    public boolean findPriceOfTodaysDeal() {
        boolean isPriceLessThan200 = false;
        int dealPrice = Integer.parseInt(getTextFromElement(todaysDealPrice).replaceAll("[^0-9]", ""));
        if (dealPrice <= 200)
            isPriceLessThan200 = true;
        return isPriceLessThan200;
    }

    public void findAllHotelsOnPage() {
        boolean isHiltonOnTheList = false;
        List<WebElement> hotelsList = SharedSD.getDriver().findElements(By.xpath("//li[contains(@class, 'hotel')]"));
        for (WebElement hotel : hotelsList) {
            if (hotel.getText().contains("Hilton")) {
                isHiltonOnTheList = true;
                break;
            }
        }
    }

    public void findStarsInResults() {
        List<WebElement> stars = SharedSD.getDriver().findElements(By.xpath("//li[contains(@class,'hotel')]//span[contains(@class,'star-rating-text')][contains(text(),'star')]"));
        //ArrayList<String> starArr = new ArrayList<>();
        for (WebElement star : stars) {
            if (star.getText().contains("star")) {
               star.getText().charAt(0);
            }
        }
        char[] character = new char[stars.size()];
        for (int i = 0; i < stars.size(); i++){

        }
        System.out.println(stars);

    }



    public void clickOnFiveStarCheckBox() throws InterruptedException {
        clickOn(fiveStarCheckBox);
        Thread.sleep(4000);
    }
    public void clickOnFourStarCheckBox() throws InterruptedException {
        clickOn(fourStarCheckBox);
        Thread.sleep(4000);
    }
    public void clickOnThreeRatingCheckBox() throws InterruptedException {
        clickOn(threeStarCheckBox);
        Thread.sleep(4000);
    }

}


