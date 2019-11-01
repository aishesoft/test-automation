package framework.webPages.HotelsCom;

import framework.webPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.List;
import java.util.WeakHashMap;

public class HotelsHomePage extends BasePage {
    private By roomDropDown = By.xpath("//select[@id='qf-0q-compact-occupancy']");
    private By moreOptionsChoice = By.xpath("//option[contains(text(),'More options')]");
    private By newRoomsDropDown = By.id("qf-0q-rooms");
    private By destinationField = By.xpath("//input[@id='qf-0q-destination']");
    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    public int room;


    public void clickOnRoomsDropDown(){
        clickOn(roomDropDown);
    }

    public void selectRoomFromRoomsDropDown(String index) {
        clickOn(roomDropDown);
        clickOn(moreOptionsChoice);
        selectByValue(newRoomsDropDown, index);
    }

    public int verifyAppearedRoomSelection() {
        List<WebElement> roomsOptions = SharedSD.getDriver().findElements(By.xpath("//div[@class='widget-query-group widget-query-room-options']"));
        System.out.println(roomsOptions.size());
        return roomsOptions.size();
    }

    public boolean isAnyRoomsOptionDisplay() {
        boolean isAnyRoomsOptionDisplay = false;
        if (room == 9) {
            isAnyRoomsOptionDisplay = true;
        }
        return isAnyRoomsOptionDisplay;
    }

    public void enterDesiredLocation() throws InterruptedException {
        clickOn(destinationField);
        setValue(destinationField, "Upstate New York");
        Thread.sleep(2000);
        List<WebElement> suggestedList = SharedSD.getDriver().findElements(By.xpath("//tbody[@class='autosuggest-city']"));
        for (WebElement result : suggestedList) {
            if (result.getText().contains("New York")) {
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



}
