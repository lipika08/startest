package com.accenture.tests;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeTest;

public class Demo02_Robot {
	WebDriver d;
	int i =9;
  @Test
  public void robotclass() throws AWTException {
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_WINDOWS);
	  r.keyRelease(KeyEvent.VK_WINDOWS);
	  r.keyPress(KeyEvent.VK_WINDOWS);
	  r.keyRelease(KeyEvent.VK_WINDOWS);
	 while (i>1){
	  r.keyPress(KeyEvent.VK_CAPS_LOCK);
	  r.keyRelease(KeyEvent.VK_CAPS_LOCK);
	
	  r.keyPress(KeyEvent.VK_CAPS_LOCK);
	  r.keyRelease(KeyEvent.VK_CAPS_LOCK);
	  i --;
	 }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\lipika\\chromedriver.exe");
	 // d= new ChromeDriver();
	 // d.get("https://www.timesjobs.com/candidate/register.html");
  }

}
