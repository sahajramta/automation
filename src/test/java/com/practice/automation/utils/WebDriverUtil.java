package com.practice.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum WebDriverUtil {

	FIREFOX("FIREFOX"), CHROME("CHROME");

	WebDriverUtil(String name) {
//		if (name.equals("FIREFOX")) {
			webDriver = new FirefoxDriver();
//		} 
//		else if (name.equals("CHROME")) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\softwares\\selenium\\chromedriver_win32\\chromedriver.exe");
//			webDriver = new ChromeDriver();
//		}
	}

	public WebDriver getDriver() {
		return webDriver;
	}

	WebDriver webDriver;

	// WebDriver firefoxDriver = new FirefoxDriver();
	// WebDriver chromeDriver = new ChromeDriver();

}
