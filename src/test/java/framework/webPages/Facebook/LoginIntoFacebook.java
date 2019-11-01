package framework.webPages.Facebook;

import framework.webPages.BasePage;
import org.openqa.selenium.By;

public class LoginIntoFacebook extends BasePage {
    private By errorMessage = By.xpath("//div[@class='_5v-0 _53in']");

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }
}
