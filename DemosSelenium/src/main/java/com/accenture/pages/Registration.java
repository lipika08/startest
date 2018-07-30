package com.accenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;


public class Registration {

WebDriver driver;

@BeforeClass
 public void initiate()
 {
	System.setProperty("webdriver.chrome.driver", "C:\\lipika\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get("https://www.timesjobs.com/candidate/register.html");
 }
 
public WebElement email() {
	 WebElement email= driver.findElement(By.id("emailAdd"));
	 return email;
  }
public WebElement pwd() {
	 WebElement pwd= driver.findElement(By.id("passwordField"));
	 return pwd;
 }
public WebElement cpwd() {
	 WebElement cpwd= driver.findElement(By.id("retypePassword"));
	 return cpwd;
 }
}
