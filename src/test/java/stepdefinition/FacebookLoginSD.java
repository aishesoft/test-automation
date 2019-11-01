package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.Facebook.FacebookLandingPage;
import framework.webPages.Facebook.LoginIntoFacebook;
import org.testng.Assert;

import javax.xml.ws.WebEndpoint;

public class FacebookLoginSD {

    private FacebookLandingPage landingPage = new FacebookLandingPage();
    private LoginIntoFacebook loginPage = new LoginIntoFacebook();

    @Given("^I am on Facebook home page$")
    public void iAmOnFacebookHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Facebook - Log In or Sign Up", "Invalid Home Page");
    }

    @When("^Enter (.+) into (username|email|password) field$")
    public void enterDataIntoInputTextField(String inputText, String textField) {
        switch (textField) {
//            case "username":
//                landingPage.enterEmail(inputText);
//                break;
            case "password":
                landingPage.enterPassword(inputText);
                break;
            case "email":
                landingPage.enterEmail(inputText);
                break;
        }
    }

    @When("^Click on (Login|Create account) button$")
    public void clickLoginButton(String button) {
        switch (button) {
            case "Login":
                landingPage.clickOnLoginButton();
                break;
            case "create account":
                //Implement Create account object
                break;
        }
    }

    @Then("^Verifying invalid login information message on the page$")
    public void verifyInvalidFacebookLoginPage() {
        loginPage.getErrorMessage();
        Assert.assertEquals(loginPage.getErrorMessage(), "The email or phone number you’ve entered doesn’t match any account. Sign up for an account.\nClose popup and return");
    }

    @When("^Enter (.+) into First name field$")
    public void enterFirstName(String firstName) throws InterruptedException {
        landingPage.enterFirstName(firstName);
        Thread.sleep(1000);
    }

    @When("^Enter (.+) into Last name field$")
    public void enterLastName(String lastName) {
        landingPage.enterLastName(lastName);
    }

    @When("^Enter (.+) into Email address field$")
    public void enterEmailAddress(String email) {
        landingPage.enterRegEmail(email);
    }

    @When("^Click on password field$")
    public void clickOnPasswordField() {
        landingPage.clickOnPasswordField();
    }

    @When("^Click on red exclamation icon$")
    public void clickOnExlamationIcon() {
        landingPage.clickOnExclamationIcon();
    }

    @Then("^Verify incorrect email was entered message$")
    public void verifyMessageIncorrectEmailAddress() throws InterruptedException {
        Assert.assertEquals("Please enter a valid mobile number or email address.\nClose popup and return", landingPage.getErrorMessage());
        Thread.sleep(1000);
    }
    @When("^Click on month drop down$")
    public void clickOnMonthDropDown() {
        landingPage.clickOnMonthDropdown();
    }

    @When("^Select current month from drop down$")
    public void selectCurrentMonthInMonthDropDown() {
        landingPage.selectCurrentMonthInMonthDropdown();
    }

    @Then("^Verify the correct month is selected$")
    public void verifySelectedMonth() {
        Assert.assertEquals("Oct", landingPage.selectMonthByVisibleText());
    }

    @When("^Click on drop down and find out if it contains duplicates$")
    public void verifyDropDownDoesNotContainDuplicates() {
        landingPage.findDuplicateValueInDropDown();
    }

}
