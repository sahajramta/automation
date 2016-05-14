package com.practice.automation.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static WebDriver DRIVER;

	public DriverManager(WebDriver driver) {
		DRIVER = driver;
	}

	public static WebDriver get() {
		return DRIVER;
	}

}
