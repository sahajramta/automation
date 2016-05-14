package com.practice.automation;

import org.openqa.selenium.By;

import com.practice.automation.utils.DriverManager;

public class HomePage {

	private static final String HOME = "http://book.theautomatedtester.co.uk";
	private static final String CHAPTER2 = "http://book.theautomatedtester.co.uk/chapter2";

	public HomePage() {
		DriverManager.get().get(HOME);
	}

	public Chapter2 clickChapter2() {
		clickChapter("2");
		return new Chapter2(CHAPTER2);
	}

	private void clickChapter(String number) {
		DriverManager.get().findElement(By.linkText("Chapter" + number)).click();
	}
}
