package com.practice.automation;

import org.openqa.selenium.support.ui.LoadableComponent;

import com.practice.automation.utils.DriverManager;
import com.practice.automation.utils.WebElementUtil;

public class Chapter2 extends LoadableComponent<Chapter2> {

	private final String NAME;

	public Chapter2(String name) {
		this.NAME = name;
	}

	@Override
	protected void isLoaded() throws Error {
		String url = DriverManager.get().getCurrentUrl();
		if (!url.equals(NAME)) {
			throw new Error("The wrong page has loaded");
		}
	}

	@Override
	protected void load() {
		DriverManager.get().get(NAME);
	}

	public boolean isButtonPresent(String button) {
		return WebElementUtil.getButtonById(button) != null ? true : false;
	}
}