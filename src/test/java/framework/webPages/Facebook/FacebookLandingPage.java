package framework.webPages.Facebook;

import framework.webPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FacebookLandingPage extends BasePage {
    //Elements (field values)
    private By emailTextField = By.id("email");
    private By passwordTextField = By.id("pass");
    private By loginButton = By.id("loginbutton");
    private By firstNameTextField = By.xpath("//input[@type='text' and @name ='firstname']");
    private By lastNameTextField = By.name("lastname");
    private By regEmailTextField = By.xpath("//input[@type='text' and @name ='reg_email__']");
    private By passwTextField = By.name("reg_passwd__");
    private By reEnterPasswTextField = By.name("reg_email_confirmation__");
    private By exclamationIconOne = By.xpath("//*[@id=\"u_0_j\"]/i[1]");
    private By signUpButton = By.name("websubmit");
    private By errorMessage = By.xpath("//div[@class='_5v-0 _53im']");
    private By nameErrorMessage = By.xpath("");
    private By text1 = By.xpath("//h2[text()='Sign Up' or text()='Create an account']");
    private By text2 = By.xpath("//div[contains(text(),'quick and')]");
    private By radiobutton = By.xpath("//span[@class='_5k_2 _5dba']");
    private By femaleRadioButton = By.xpath("//*[@id='u_0_6']");
    private By maleRadioButton = By.xpath("//*[@id='u_0_a']");
    private By photosAndUpdatesIcon = By.xpath("//*[@id=\"content\"]");
    private boolean isPhotosAndUpdatesIconDisplayed = false;
    private By monthDropDown = By.id("month");
    private boolean isMonthDropDownContainDuplicates = false;
    private By yearDropDown = By.xpath("//select[@id='year']");


    //Methods
    public void enterEmail(String email) {
        setValue(emailTextField, email);
    }
    public void enterPassword(String password) {
        setValue(passwordTextField, password);
    }
    public void clickOnLoginButton() {
        clickOn(loginButton);
    }

    public void enterFirstName(String firstName) {
        setValue(firstNameTextField, firstName);
    }
    public void enterLastName(String lastName) {
        setValue(lastNameTextField, lastName);
    }
    public void enterRegEmail(String regEmail) {
        setValue(regEmailTextField, regEmail);
    }
    public void enterPass(String regPassword) {
        setValue(passwTextField, regPassword);
    }
    public void clickOnPasswordField() {
        clickOn(passwTextField);
    }
    public void reEnterPass(String regPassword) {
        setValue(reEnterPasswTextField, regPassword);
    }
    public boolean isReEnterPassFieldDisplayed() {
        return isElementDisplayed(reEnterPasswTextField);
    }
    public boolean isExclamationIconDisplayed() {
        return isElementDisplayed(exclamationIconOne);
    }
    public void clickOnExclamationIcon() {
        clickOn(exclamationIconOne);
    }
    public void clickOnSignupButton() {
        clickOn(signUpButton);
    }


    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }
    public String getNameErrorMessage() {
        return getTextFromElement(nameErrorMessage);
    }
    public String getText1FromPage() {
        return getTextFromElement(text1);
    }
    public String getText2FromPage() {
        return getTextFromElement(text2);
    }
    public String getRadioButtonText() {
        return getTextFromElement(radiobutton);
    }
    public void selectMaleRadioButton() {
        clickOn(maleRadioButton);
    }
    public boolean isFemaleRadioButtonSelected() {
        return isElementSelected(femaleRadioButton);
    }
    public void selectFemaleRadioButton() {
        clickOn(femaleRadioButton);
    }
    public void isPhotosAndUpdatesIconDisplayed() {
        try {
            isElementDisplayed(photosAndUpdatesIcon);
            isPhotosAndUpdatesIconDisplayed = true;
        } catch (NoSuchElementException e) {
            e.getStackTrace();
        }
    }
    public void selectYearByVisibleText() {
        selectOptionByVisibleText(yearDropDown, "2019");
    }
    public void selectMonthByValue() {
        selectByValue(monthDropDown, "3");
    }
    public String selectMonthByVisibleText() {
       String newtext = selectOptionByVisibleText(monthDropDown, "Oct");
       return newtext;
    }
    public void selectMonthByIndex() {
        selectByIndex(monthDropDown, 5);
    }
    public void clickOnMonthDropdown() {
        clickOn(monthDropDown);
    }
    public String selectCurrentMonthInMonthDropdown() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("MMM");
            String currentMonth = sdf.format(calendar.getTime());

            WebElement monthDropDown = webAction(By.id("month"));
            Select months = new Select(monthDropDown);
            months.selectByVisibleText(currentMonth);
            return currentMonth;
        }

    public void findDuplicateValueInDropDown() {
        isDropDownHasDuplicates(monthDropDown);
    }





}
