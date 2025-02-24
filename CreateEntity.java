package qeagleAssignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
	
	public class CreateEntity {

		public static void main(String[] args) throws InterruptedException {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("leaf@2024");
			driver.findElement(By.id("Login")).click();
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement clickLegal = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
			js.executeScript("arguments[0].click();", clickLegal);
			Thread.sleep(3000);
			driver.findElement(By.xpath(
					"((//div[@class='slds-context-bar__label-action slds-p-left_none'])[14]//lightning-icon)[1]//lightning-primitive-icon"))
					.click();
			WebElement clickNewEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
			js.executeScript("arguments[0].click();", clickNewEntity);
			driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Kavin");
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
			String verLegal = driver
					.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by Kavin']"))
					.getText();
			if (verLegal.equals("Salesforce Automation by Kavin")) {
				System.out.println("Legal Entity created successfully");
			} else {
				System.out.println("Legal Entity was not created");
			}

		}

	}



