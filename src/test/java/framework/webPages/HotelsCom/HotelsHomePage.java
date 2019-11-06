package framework.webPages.HotelsCom;

import framework.webPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;
import java.util.List;

public class HotelsHomePage extends BasePage {

    private By roomDropDown = By.xpath("//select[@id='qf-0q-compact-occupancy']");
    private By moreOptionsChoice = By.xpath("//option[contains(text(),'More options')]");
    private By newRoomsDropDown = By.id("qf-0q-rooms");
    private By destinationField = By.xpath("//input[@id='qf-0q-destination']");
    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    private By closeButtonOnOverlay = By.xpath("//button[@class='cta widget-overlay-close']");

    public void selectRoomFromRoomsDropDown(String index) {
        clickOn(roomDropDown);
        clickOn(moreOptionsChoice);
        selectByValue(newRoomsDropDown, index);
    }

    public int verifyAppearedRoomSelection() {
        List<WebElement> roomsOptions = SharedSD.getDriver().findElements(By.xpath("//div[@class='widget-query-group widget-query-room-options']"));
        return roomsOptions.size();
    }

    public void enterDesiredLocation() throws InterruptedException {
        clickOn(destinationField);
        setValue(destinationField, "Central New York City");
        Thread.sleep(1000);
        List<WebElement> suggestedList = SharedSD.getDriver().findElements(By.xpath("//tbody[@class='autosuggest-city']/*"));
        for (WebElement result : suggestedList) {
            if (result.getText().contains(", New York, United States of America")) {
                result.click();
                Thread.sleep(1000);
                break;
            }
        }
    }

    public void clickOnSearchButton() throws InterruptedException {
        clickOn(searchButton);
        Thread.sleep(3000);
    }

    public void closeWidgetOverlay() {
        try {
            clickOn(closeButtonOnOverlay);
        } catch (NotFoundException e) {
            System.out.println("No promotion overlay display anymore");
        }
    }
}
