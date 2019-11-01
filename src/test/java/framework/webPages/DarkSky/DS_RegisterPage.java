package framework.webPages.DarkSky;

import framework.webPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

public class DS_RegisterPage extends BasePage {

    private By registerButton = By.xpath("//button[contains(text(),'Register')]");
    private By email = By.name("email");

    public void clickOnRegisterButton() {
        webAction(registerButton).click();
    }

    public String  textInputErrorMessage(){
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();

        WebElement field = webAction(email);
        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", field);
        //String message = (String)js.executeScript("return arguments[0].validationMessage;", field);
        String message = SharedSD.getDriver().findElement(By.name("email")).getAttribute("validationMessage");
        return message;
    }
}
