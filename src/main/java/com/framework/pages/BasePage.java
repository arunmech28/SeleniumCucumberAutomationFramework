package com.framework.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.constants.Constants;
import com.framework.utils.CurrentThreadInstance;

// TODO: Auto-generated Javadoc
/**
 * The Class BasePage.
 */
public class BasePage {

	/**
	 * Explicitly wait.
	 *
	 * @param element the element
	 */
	public void explicitlyWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(CurrentThreadInstance.getDriver(), Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Explicitly wait.
	 *
	 * @param element the element
	 * @param timeout the timeout
	 */
	public void explicitlyWait(WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(CurrentThreadInstance.getDriver(), timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Go to url.
	 *
	 * @param url the url
	 */
	public void goToUrl(String url) {
		CurrentThreadInstance.getDriver().get(url);
	}
	
	/**
	 * Element get text.
	 *
	 * @param by the by
	 * @return the string
	 */
	public String elementGetText(By by) {
		return elementGetText(CurrentThreadInstance.getDriver().findElement(by));
	}

	/**
	 * Click.
	 *
	 * @param by the by
	 */
	public void click(By by) {
		click(CurrentThreadInstance.getDriver().findElement(by));
	}

	/**
	 * Sendkeys.
	 *
	 * @param by the by
	 * @param text the text
	 */
	public void sendkeys(By by, String text) {
		sendkeys(CurrentThreadInstance.getDriver().findElement(by), text);
	}

	/**
	 * Select by value.
	 *
	 * @param by the by
	 * @param text the text
	 */
	public void selectByValue(By by, String text) {
		selectByValue(CurrentThreadInstance.getDriver().findElement(by), text);
	}

	/**
	 * Select by visible text.
	 *
	 * @param by the by
	 * @param text the text
	 */
	public void selectByVisibleText(By by, String text) {
		selectByVisibleText(CurrentThreadInstance.getDriver().findElement(by), text);
	}

	/**
	 * Select by index.
	 *
	 * @param by the by
	 * @param index the index
	 */
	public void selectByIndex(By by, int index) {
		selectByIndex(CurrentThreadInstance.getDriver().findElement(by), index);
	}

	/**
	 * Move to element.
	 *
	 * @param by the by
	 */
	public void moveToElement(By by) {
		moveToElement(CurrentThreadInstance.getDriver().findElement(by));
	}

	/**
	 * Switch to new window.
	 */
	public void switchToNewWindow() {
		String parentWinHandle = CurrentThreadInstance.getDriver().getWindowHandle();
		Set<String> winHandles = CurrentThreadInstance.getDriver().getWindowHandles();
		for (String temp : winHandles) {
			if (!temp.equalsIgnoreCase(parentWinHandle)) {
				CurrentThreadInstance.getDriver().switchTo().window(temp);
			}
		}
	}
	
	/**
	 * Element get text.
	 *
	 * @param element the element
	 * @return the string
	 */
	public String elementGetText(WebElement element) {
		return element.getText();
	}

	/**
	 * Click.
	 *
	 * @param element the element
	 */
	public void click(WebElement element) {
		explicitlyWait(element);
		highlightElement(element);
		element.click();
	}

	/**
	 * Sendkeys.
	 *
	 * @param element the element
	 * @param text the text
	 */
	public void sendkeys(WebElement element, String text) {
		explicitlyWait(element);
		highlightElement(element);
		element.sendKeys(text);
	}

	/**
	 * Move to element.
	 *
	 * @param element the element
	 */
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(CurrentThreadInstance.getDriver());
		actions.moveToElement(element).build().perform();
	}

	/**
	 * Highlight element.
	 *
	 * @param element the element
	 */
	private void highlightElement(WebElement element) {
		((JavascriptExecutor) CurrentThreadInstance.getDriver())
				.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	/**
	 * Select by value.
	 *
	 * @param element the element
	 * @param text the text
	 */
	public void selectByValue(WebElement element, String text) {
		new Select(element).selectByValue(text);
	}

	/**
	 * Select by visible text.
	 *
	 * @param element the element
	 * @param text the text
	 */
	public void selectByVisibleText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}

	/**
	 * Select by index.
	 *
	 * @param element the element
	 * @param index the index
	 */
	public void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

}
