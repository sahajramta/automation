package com.practice.automation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.practice.automation.listeners.ScreenshotListeners;

//@Listeners(ScreenshotListeners.class)
public class DriverFactory {

	private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());

	private static ThreadLocal<WebDriverThread> driverThread;

	@BeforeSuite
	public static void instantiateDriverObject() {
		System.out.println("currentThread..instantiateDriverObject: "+Thread.currentThread().getName());
		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};
		System.out.println("In instantiateDriverObject...");
	}
	
//	@BeforeSuite
//	  public void beforeSuite() {
//		  System.out.println("beforeSuite");
//	  }

	public static WebDriver getDriver() throws Exception {
		System.out.println("currentThread..getDriver: "+Thread.currentThread().getName());
		return driverThread.get().getDriver();
	}

//	@AfterMethod
//	public static void clearCookies() throws Exception {
//		getDriver().manage().deleteAllCookies();
//	}

	@AfterSuite
	public static void closeDriverObjects() {
		for (WebDriverThread webDriverThread : webDriverThreadPool) {
			webDriverThread.quitDriver();
		}
	}
}
