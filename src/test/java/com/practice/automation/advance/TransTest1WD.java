package com.practice.automation.advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.practice.automation.DriverFactory;

public class TransTest1WD extends DriverFactory {

//	@Test(groups={"TransactionTab"})
	@Test
	public void googleCheeseExample() throws Exception {
		googleExampleThatSearchesFor("Cheese!");
	}

//	@Test(groups={"TransactionTab"})
	@Test
	public void googleMilkExample() throws Exception {
		googleExampleThatSearchesFor("Milk!");
	}
	
//	@Test(groups={"TransactionTab"})
	@Test
	public void googleMuleExample() throws Exception {
		googleExampleThatSearchesFor("Mule!");
	}
	
	private void googleExampleThatSearchesFor(final String searchString)
			throws Exception {
//		instantiateDriverObject();
		WebDriver webDriver = getDriver();

		webDriver.get("http://www.google.com");

		WebElement searchField = webDriver.findElement(By.name("q"));

		searchField.clear();
		searchField.sendKeys(searchString);

		System.out.println("Page title is: " + webDriver.getTitle());

		searchField.submit();

		(new WebDriverWait(webDriver, 10))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driverObject) {
						return driverObject.getTitle().toLowerCase()
								.startsWith(searchString.toLowerCase());
					}
				});

		System.out.println("Page title is: " + webDriver.getTitle());

	}
}
