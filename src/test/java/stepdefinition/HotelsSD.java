package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsCom.HotelsHomePage;
import framework.webPages.HotelsCom.HotelsSearchResultPage;
import org.testng.Assert;

public class HotelsSD {
    private HotelsHomePage homePage = new HotelsHomePage();
    private HotelsSearchResultPage searchResultPage = new HotelsSearchResultPage();
    public int room;

    @Given("^Hotels.com homepage is launched$")
    public void navigateToHotelsHomePage() throws InterruptedException {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations",
                "Incorrect homepage");
        Thread.sleep(1000);
    }

    @When("I select (.+) from select_rooms room dropdown")
    public void selectRoomFromRoomsDropDown(String room) throws InterruptedException {
        homePage.clickOnRoomsDropDown();
        Thread.sleep(1000);
        homePage.selectRoomFromRoomsDropDown(room);
    }

    @Then("^I verify (.+) number_of_room_dropdown is displayed$")
    public void verifyNumberOfRoomsSelectionDisplayed(int room) {
        if (room < 9) {
            Assert.assertEquals(homePage.verifyAppearedRoomSelection(), room, "Not Identical");
        } else {
            Assert.assertEquals(homePage.verifyAppearedRoomSelection(), 0, "Not Identical");
        }
    }



    @Given("^I am on default locations search result screen$")
    public void IamOnSearchResultScreen() throws InterruptedException {
        homePage.enterDesiredLocation();
        homePage.clickOnSearchButton();
    }

    @Then("^I verify system displays all hotels within 10 miles radius of airport$")
    public void verifyHotelsWithingOneMileRadiusOfDowntown() {

    }

    @Then("^I verify Hilton Hotel is within radius$")
    public void verifyHiltonHotelInListOfSearchResults() {

    }

    @When("^I select property (.+) star class$")
    public void selectStars(String star) throws InterruptedException {
        switch (star) {
            case "5-star":
                searchResultPage.clickOnFiveStarCheckBox();
                break;
            case "4-star":
                searchResultPage.clickOnFourStarCheckBox();
                break;
            case "3-star":
                searchResultPage.clickOnThreeRatingCheckBox();
                break;
        }
    }

    @Then("^I verify system displays only selected star hotels on search result$")
    public void filterResultsDisplayOnlyNStartsHotels() {
        searchResultPage.findStarsInResults();

    }







    @Then("^I verify todays deal is less than USD200$")
    public void verifyTodaysDeal() throws InterruptedException {
        Assert.assertTrue(searchResultPage.findPriceOfTodaysDeal(), "Today's Deal price is more than $200");
    }



}
