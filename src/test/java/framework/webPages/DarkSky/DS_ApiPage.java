package framework.webPages.DarkSky;

import framework.webPages.BasePage;
import org.openqa.selenium.By;

public class DS_ApiPage extends BasePage {
    private By signUpbutton = By.xpath("//a[@class='button filled']");

    public void navigateToRegisterPage(){
        webAction(signUpbutton).click();
    }

}
