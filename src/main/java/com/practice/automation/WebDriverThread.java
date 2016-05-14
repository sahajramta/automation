package com.practice.automation;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//import static com.masteringselenium.config.DriverType.valueOf;

public class WebDriverThread {

	/*
	 * private WebDriver webdriver;
	 * 
	 * private final String operatingSystem =
	 * System.getProperty("os.name").toUpperCase(); private final String
	 * systemArchitecture = System.getProperty("os.arch");
	 * 
	 * public WebDriver getDriver() throws Exception { if (null == webdriver) {
	 * System.out.println(" "); System.out.println("Current Operating System: "
	 * + operatingSystem); System.out.println("Current Architecture: " +
	 * systemArchitecture);
	 * System.out.println("Current Browser Selection: Firefox");
	 * System.out.println(" "); webdriver = new
	 * FirefoxDriver(DesiredCapabilities.firefox()); }
	 * 
	 * return webdriver; }
	 * 
	 * public void quitDriver() { if (null != webdriver) { webdriver.quit();
	 * webdriver = null; } }
	 */

	private WebDriver webdriver;
	private DriverType selectedDriverType;

	private final DriverType defaultDriverType = DriverType.FIREFOX;
	private final String browser = System.getProperty("browser").toUpperCase();
//	private final String browser = "FIREFOX";
	private final String operatingSystem = System.getProperty("os.name")
			.toUpperCase();
	private final String systemArchitecture = System.getProperty("os.arch");

	public WebDriver getDriver() throws Exception {
		if (null == webdriver) {
			selectedDriverType = determineEffectiveDriverType();
			DesiredCapabilities desiredCapabilities = selectedDriverType
					.getDesiredCapabilities();
			instantiateWebDriver(desiredCapabilities);
		}

		return webdriver;
	}

	public void quitDriver() {
		if (webdriver !=null) {
			webdriver.quit();
		}
	}

	private DriverType determineEffectiveDriverType() {
		DriverType driverType = defaultDriverType;
		try {
			driverType = DriverType.valueOf(browser);
		} catch (IllegalArgumentException ignored) {
			System.err.println("Unknown driver specified, defaulting to '"
					+ driverType + "'...");
		} catch (NullPointerException ignored) {
			System.err.println("No driver specified, defaulting to '"
					+ driverType + "'...");
		}
		return driverType;
	}

	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities)
			throws MalformedURLException {
		System.out.println(" ");
		System.out.println("Current Operating System: " + operatingSystem);
		System.out.println("Current Architecture: " + systemArchitecture);
		System.out.println("Current Browser Selection: " + selectedDriverType);
		System.out.println(" ");
		webdriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
	}

}
