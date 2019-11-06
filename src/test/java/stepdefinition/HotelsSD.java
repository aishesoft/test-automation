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

    @Given("^Hotels.com homepage is launched$")
    public void navigateToHotelsHomePage() throws InterruptedException {
        homePage.closeWidgetOverlay();
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for " +
                        "Hotel Reservations from Luxury Hotels to Budget Accommodations", "Incorrect homepage");
        Thread.sleep(500);
    }

    @When("I select (.+) from select_rooms room dropdown")
    public void selectRoomFromRoomsDropDown(String room) throws InterruptedException {
        homePage.selectRoomFromRoomsDropDown(room);
        Thread.sleep(1000);
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

    @When("^I select Landmark and set the max radius$")
    public void setDistanceForHotel() throws InterruptedException {
        searchResultPage.selectDistanceLocation();
    }

    @Then("^I verify system displays all hotels within 2 miles radius of Landmark$")
    public void verifyHotelsWithingOneMileRadiusOfDowntown() throws InterruptedException {
        searchResultPage.scrollSlowMotion();
        Assert.assertTrue(searchResultPage.findAllMiles(), "Some hotels are not within the desired mile radius");
    }

    @Then("^I verify Hilton Hotel is within radius$")
    public void verifyHiltonHotelInListOfSearchResults() {
        Assert.assertTrue(searchResultPage.findAllHotelsOnPage(), "Hilton is not in the list of Hotels");
    }

    @When("^I select property (.+) star class$")
    public void selectStars(String star) throws InterruptedException {
        switch (star) {
            case "5":
                searchResultPage.clickOnFiveStarCheckBox();
                break;
            case "4":
                searchResultPage.clickOnFourStarCheckBox();
                break;
            case "3":
                searchResultPage.clickOnThreeRatingCheckBox();
                break;
        }
    }

    @Then("^I verify system displays only selected (.+) hotels on search result$")
    public void filterResultsDisplayOnlyNStartsHotels(int star) throws InterruptedException {
        searchResultPage.scrollSlowMotion();
        //searchResultPage.dynamicScrollTillEndOfSearResult();
        Assert.assertTrue(searchResultPage.findStarsInResults(star),  "Not match" );;

    }







    @Then("^I verify todays deal is less than USD200$")
    public void verifyTodaysDeal() throws InterruptedException {
        Assert.assertTrue(searchResultPage.findPriceOfTodaysDeal(), "Today's Deal price is more than $200");
    }



}
