package com.accenture.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Demo04_TakingScreenshots {
	static WebDriver d;
	 static int counter=1;

  @BeforeTest
  public void beforeTest() throws IOException {
	  System.setProperty("webdriver.chrome.driver", "C:\\lipika\\chromedriver.exe");
	  d= new ChromeDriver();
	  d.get("https://www.timesjobs.com/candidate/register.html");
	  d.manage().window().maximize();
	  takeScreenshot();
	  
  }
  @Test
  public void movetoElement() throws InterruptedException, AWTException, IOException {
	  Actions a = new Actions(d);
	  WebElement email= d.findElement(By.id("emailAdd"));
	  a.moveToElement(email).keyDown(email,Keys.SHIFT).sendKeys("lipika").build().perform();
	  takeScreenshot();
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
	  takeScreenshot();
	 
  }
  public static void  takeScreenshot() throws IOException{
	TakesScreenshot t = (TakesScreenshot)d;
	File f= t.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f,new File("C:\\lipika\\failure"+counter+".jpg" ));
	counter++;
  }
  
  public static void setClipboardData(String string){
	  StringSelection stringSelection = new StringSelection(string);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
  }
  
}
