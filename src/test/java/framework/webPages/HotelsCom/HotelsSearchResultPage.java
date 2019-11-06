package framework.webPages.HotelsCom;

import framework.webPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.*;
import java.util.List;

public class HotelsSearchResultPage extends BasePage {

        private By fiveStarCheckBox = By.xpath("//input[@id='f-star-rating-5']");
        private By fourStarCheckBox = By.xpath("//input[@id='f-star-rating-4']");
        private By threeStarCheckBox = By.xpath("//input[@id='f-star-rating-3']");
        private By todaysDealPrice = By.xpath("//ins[contains(text(),'$')]");
        private By landmarkMenu = By.xpath("//fieldset[@id='filter-landmarks']//legend[@class='filter-legend']");
        private By locationCheckBox = By.xpath("//input[@id='f-lid-1662393']");
        private By milageDropDown = By.xpath("//select[@id='f-distance']");


    public void scrollSlowMotion() throws InterruptedException {
        slowScroll();
    }

    public boolean findPriceOfTodaysDeal() {
        boolean isPriceLessThan200 = false;
        int dealPrice = Integer.parseInt(getTextFromElement(todaysDealPrice).replaceAll("[^0-9]", ""));
        if (dealPrice <= 200)
            isPriceLessThan200 = true;
        return isPriceLessThan200;
    }

    public void selectDistanceLocation() throws InterruptedException {
//        Actions actions = new Actions(SharedSD.getDriver());
//        WebElement mainMenu = SharedSD.getDriver().findElement(By.xpath("//a[contains(text(),'Distance')]"));
//        actions.moveToElement(mainMenu);
//        Thread.sleep(2000);
//        WebElement subMenu = SharedSD.getDriver().findElement(By.xpath("//a[contains(text(),'5th Avenue')]"));
//        actions.moveToElement(subMenu);
//        actions.click().build().perform();
//        Thread.sleep(3000);

        scrollByPixel(0, 250);
        Thread.sleep(2000);
        clickOn(landmarkMenu);
        clickOn(locationCheckBox);
        Thread.sleep(4000);
        scrollByPixel(0, 150);
        clickOn(milageDropDown);
        Thread.sleep(1000);
        selectOptionByVisibleText(milageDropDown, "2 miles");
        Thread.sleep(1000);
    }

    public boolean findAllHotelsOnPage() {
        boolean isHiltonOnTheList = false;
        List<WebElement> hotelsList = SharedSD.getDriver().findElements(By.xpath("//li[contains(@class, 'hotel')]"));
        for (WebElement hotel : hotelsList) {
            if (hotel.getText().contains("Hilton")) {
                isHiltonOnTheList = true;
                break;
            }
        } return isHiltonOnTheList;
    }

    public boolean findAllMiles() {
        List<WebElement> miles = SharedSD.getDriver().findElements(By.xpath("//li//article[1]//section[1]//div[1]//ul[1]/li[1]"));
        List<String> milesInStringList =  new ArrayList<>();
        for (WebElement mile : miles) {
            milesInStringList.add((mile.getText().replaceAll("[^0-9_.]", "")).replaceAll(".$", ""));
        }
        String[] milesInStringArray = new String[milesInStringList.size()];
        milesInStringArray = milesInStringList.toArray(milesInStringArray);
        double[] milesInDoubleArr = new double[milesInStringArray.length];
        for (int i = 0; i < milesInStringArray.length; i++) {
            milesInDoubleArr[i] = Double.parseDouble(milesInStringArray[i]);
        }

        double desiredRadiusInMiles = 2.0;
        boolean isHotelWithinTheRadius = false;
        for (int r = 0; r < milesInDoubleArr.length; r++) {
            if (milesInDoubleArr[r] <= desiredRadiusInMiles) {
                isHotelWithinTheRadius = true;
            } else {
                System.out.println("Some hotels are not within the radius 2 miles");
            }
        }
        return isHotelWithinTheRadius;
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

    public boolean findStarsInResults(int hotelStar) {
        List<WebElement> stars = SharedSD.getDriver().findElements(By.xpath("//li[contains(@class,'hotel')]//span[contains(@class,'star-rating-text')][contains(text(),'star')]"));
        ArrayList<Character> starArr = new ArrayList<>();
        for (WebElement star : stars) {
            if (star.getText().contains("star")) {
               starArr.add(star.getText().charAt(0));
            }
        }
        boolean isIncorrectStartInTheList = true;
        Set<Character> set = new HashSet<>(starArr);
            if ((set.size() == 1 ) && (set.contains(hotelStar)))
                isIncorrectStartInTheList = false;
        return isIncorrectStartInTheList;
    }
}


