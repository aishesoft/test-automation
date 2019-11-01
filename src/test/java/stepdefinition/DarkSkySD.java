package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSky.DS_ApiPage;
import framework.webPages.DarkSky.DS_HomePage;
import framework.webPages.DarkSky.DS_RegisterPage;
import org.testng.Assert;

public class DarkSkySD {

    private DS_HomePage homepage = new DS_HomePage();
    private DS_RegisterPage registerPage = new DS_RegisterPage();
    private DS_ApiPage apiPage = new DS_ApiPage();

    @Given("^DarkSky homepage is launched$")
    public void darkSkyHomePageLaunch() throws InterruptedException {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY",
                "incorrect homepage");
        Thread.sleep(1000);
    }

    @Given("^I am on the DarkSky Register page$")
    public void darkSkyRegisterPage() throws InterruptedException {
        homepage.navigateToDarkSkyAPIPage();
        Thread.sleep(1000);
        apiPage.navigateToRegisterPage();
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky API: Register", "Wrong page");
        Thread.sleep(1000);
    }

    @When("^I click on Register button$")
    public void clickOnRegisterButton() throws InterruptedException {
        registerPage.clickOnRegisterButton();
        Thread.sleep(2000);
    }

    @Then("^I verify error message 'Please fill out this field'$")
    public void verifyTextInputErrorMessage(){
        String errorMessage = registerPage.textInputErrorMessage();
        Assert.assertEquals(errorMessage, "Please fill out this field.", "Error not found");
    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyTemp() throws InterruptedException {
        boolean isCurrentTempBetweenMinMaxTemp = false;
        if (homepage.getMinTemperatureFromTempLine() > homepage.getCurrentTemperature()
                || homepage.getCurrentTemperature() > homepage.getMaxTemperatureFromTempLine()) {
            System.out.println("ERROR: Current temperature out of boundary!");
        } else {
            isCurrentTempBetweenMinMaxTemp = true;
        }
        Assert.assertTrue(isCurrentTempBetweenMinMaxTemp);
        Thread.sleep(1000);
    }

    @When("^I expand today's timeline$")
    public void expandTodayTimeline() throws InterruptedException {
        homepage.scrollPage();
        Thread.sleep(2000);
        homepage.clickOnExpandIcon();
        Thread.sleep(2000);
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyLowestAndHighestTemperature() {
        Assert.assertEquals(homepage.getCompareToMinTemperature(), homepage.getMinTemperature(), "Error: MIN values are not the same");
        Assert.assertEquals(homepage.getCompareToMaxTemperature(), homepage.getMaxTemperature(), "Error: MAX values are not the same");
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimelineDisplaysHoursInTwoHourIncrement() {
        Assert.assertEquals(homepage.getTodayHoursFromCalendar(), homepage.getTimeFromTimeLineOnDarkSky(),
                "Time arrays' values are not equal");
    }
    //test to commit the branch


}
