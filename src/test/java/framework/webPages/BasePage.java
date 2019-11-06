package framework.webPages;

import com.google.common.base.Function;
import org.apache.commons.codec.digest.Sha2Crypt;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	public void selectByValue(By locator, String value) {
		WebElement webElement = webAction(locator);
		Select parameter = new Select(webElement);
		parameter.selectByValue(value);
	}

	public String selectOptionByVisibleText(By locator, String text) {
		WebElement webElement = webAction(locator);
		Select parameter = new Select(webElement);
		parameter.selectByVisibleText(text);
		return text;
	}

	public void selectByIndex(By locator, int index) {
		WebElement webElement = webAction(locator);
		Select parameter = new Select(webElement);
		parameter.selectByIndex(index);
	}
	public void isDropDownHasDuplicates(By locator) {
		List<WebElement> months = webAction(locator).findElements(locator);
		String[] stringMonths = new String[months.size()];
		List<String> duplicateValues = new ArrayList<>();
		int a = 0;
		for(WebElement e : months) {
			stringMonths[a]= e.getText();
			a++;
		}
		for (int i = 0; i < stringMonths.length; i++) {
			for (int j = 1; j < months.size(); j++) {
				if (stringMonths[i].equals(stringMonths[j])) {
					duplicateValues.add(stringMonths[j]);
				}
			}
		}
		if (duplicateValues.size() == 0) {
			System.out.println("No duplicates found");
		} else {
			System.out.println("Duplicated values are: " + Arrays.toString(duplicateValues.toArray()));
		}
	}

	public void scrollByPixel(int x, int y) {
		JavascriptExecutor jsScrollBy = (JavascriptExecutor)SharedSD.getDriver();
		jsScrollBy.executeScript("scrollBy(" + x + "," + y + ");"); //this will scroll 400 pixels downward.
	}

	public String getTodayFromDateLibrary(String dateFormat){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String today = sdf.format(date);
		return today;
	}

	public void  dynamicScrolling() throws InterruptedException {
			long lastHeight = (long) ((JavascriptExecutor)SharedSD.getDriver()).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) SharedSD.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (long) ((JavascriptExecutor) SharedSD.getDriver()).executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
			}
	}

	public  void scrollUntilVisibleElement(By locator) throws InterruptedException {

		WebElement element = SharedSD.getDriver().findElement(locator);
		((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
	}

	public void slowScroll() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)SharedSD.getDriver();
		for (int second = 0;; second++) {
			if(second >=10){
				break;
			}
			jse.executeScript("window.scrollBy(0,800)", ""); //y value '800' can be altered
			Thread.sleep(2000);
		}
	}

}
