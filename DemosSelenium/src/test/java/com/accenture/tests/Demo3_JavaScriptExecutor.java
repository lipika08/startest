package com.accenture.tests;

import org.testng.annotations.Test;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Demo3_JavaScriptExecutor {
	WebDriver d;
  @Test
  public void javascript() throws AWTException{
	  //d.manage().window().maximize();
	  JavascriptExecutor j= (JavascriptExecutor)d;
	  j.executeScript("alert('hello')");
	  d.switchTo().alert().dismiss();
	  j.executeScript("window.scroll(0,1000)");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\lipika\\chromedriver.exe");
	  d= new ChromeDriver();
	  d.get("https://www.timesjobs.com/candidate/register.html");
  }

}
