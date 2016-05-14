package com.practice.automation.advance;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.practice.automation.DriverFactory;

public class TestNGFirst extends DriverFactory {
  @Test
  public void f() {
	  System.out.println("hello test ng");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod");
  }

//  @BeforeSuite
//  public void beforeSuite() {
//	  System.out.println("beforeSuite");
//  }
//
//  @AfterSuite
//  public void afterSuite() {
//	  System.out.println("afterSuite");
//  }

}
