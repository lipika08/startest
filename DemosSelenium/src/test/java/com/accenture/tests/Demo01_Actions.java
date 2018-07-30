package com.accenture.tests;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class Demo01_Actions {
	WebDriver d;
	String e_mail="lipika_singh@gmail.com";
  @Test
  public void movetoElement() throws InterruptedException, AWTException {
	  Actions a = new Actions(d);
	  WebElement email= d.findElement(By.id("emailAdd"));
	  a.moveToElement(email).keyDown(email,Keys.SHIFT).sendKeys(e_mail).build().perform();
	  
	  //email.sendKeys("lipika_singh@gmail.com");
	  d.findElement(By.id("resumeFile_basic")).click();
	  Thread.sleep(1000);
	  Robot r= new Robot();
	  setClipboardData("C:\\Users\\pdc4-training.pdc4\\Downloads\\Assign2.docx");
	  r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);
	  r.keyPress(KeyEvent.VK_CONTROL);
	  r.keyPress(KeyEvent.VK_V);
	  r.keyRelease(KeyEvent.VK_V);
	  r.keyRelease(KeyEvent.VK_CONTROL);
	  r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);
	  a.contextClick().build().perform();
	 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\lipika\\chromedriver.exe");
	  d= new ChromeDriver();
	  d.get("https://www.timesjobs.com/candidate/register.html");
  }

  public static void setClipboardData(String string){
	  StringSelection stringSelection = new StringSelection(string);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
  }
}
