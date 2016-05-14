package com.practice.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementUtil {

	public static WebElement getButtonById(String id){
		return DriverManager.get().findElement(By.xpath("//input[@id='" + id + "']"));
	}
}
