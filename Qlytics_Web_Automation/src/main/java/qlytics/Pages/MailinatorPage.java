package qlytics.Pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import qlytics.Lib.AppLibrary;

public class MailinatorPage {

	private WebDriver mailDriver;

//	WebDriver driver;

	public static String verifyEmailLabel = "xpath://td[contains(text(),'[Qlytics Test] Please Confirm Your E-mail Address')]";

	public static String iframe = "xpath://iframe[@id='msg_body']";

	public static String ClickOnLink = "xpath://a[@target='_other']";

	public static String verificationCompleteLabel = "//label[text()='Email Verification Complete']";

	public static String deleteMailButton = "xpath://button[@title='Delete Emails']";

	public static String forgotPasswordLabel = "xpath://td[contains(text(),'BeanLogin: Forgot Password')]";

	public static String PasswordText = "xpath://tr//td//b";

	public MailinatorPage(WebDriver Driver) {
		super();
		this.mailDriver = Driver;
//		this.driver = driver;
	}

	public void getVerification(String email) throws Exception {

		// System.setProperty("webdriver.firefox.profile", "default");
		AppLibrary ap = new AppLibrary();
		mailDriver = ap.launchDefaultDriverInstance();

		
		boolean flag;
		int counter = 2;

		try {
			do {
				flag = false;
				counter--;
				System.out.println("Counter = " + counter);

				try {


					mailDriver
							.get("https://www.mailinator.com/v3/index.jsp?zone=public&query=" + email + "#/#inboxpane");
					AppLibrary.sleep(3000);

					AppLibrary.syncAndClick(mailDriver, verifyEmailLabel);

				} catch (Exception e) {
					flag = true;
				}

				AppLibrary.sleep(1000);
				mailDriver.switchTo().frame(AppLibrary.findElement(mailDriver, iframe));
				AppLibrary.syncAndClick(mailDriver, ClickOnLink);

				AppLibrary.switchToWindow(mailDriver, 2);
				AppLibrary.sleep(3000);


				if (!AppLibrary.isElementPresent(mailDriver, "xpath://input[@placeholder='Email Address']")) {
					mailDriver.navigate().refresh();

				}

				AppLibrary.findElement(mailDriver, "xpath://input[@placeholder='Email Address']");
				AppLibrary.findElement(mailDriver, "xpath://button[@class='ant-btn ant-btn-primary ant-btn-block']");
				// mailDriver.findElement(By.xpath(verificationCompleteLabel));

				AppLibrary.switchToWindow(mailDriver, 1);
				mailDriver.switchTo().defaultContent();
				AppLibrary.sleep(2000);
				AppLibrary.findElement(mailDriver, deleteMailButton).click();// delete
			} while (flag && counter > 0);

			mailDriver.quit();

		} catch (Exception e1) {
			mailDriver.quit();
			throw new Exception("Failed to access verification");
		}
	}
	
	public void getVerificationOnNewTab(String email) throws Exception {

//		 System.setProperty("webdriver.firefox.profile", "default");
		AppLibrary ap = new AppLibrary();
		ap.openNewTabByJavaScript(mailDriver);
		
		boolean flag;
		int counter = 2;

		try {
			do {
				flag = false;
				counter--;
				System.out.println("Counter = " + counter);

				try {
					AppLibrary.switchToWindow(mailDriver, 2);

					mailDriver
							.get("https://www.mailinator.com/v3/index.jsp?zone=public&query=" + email + "#/#inboxpane");
					AppLibrary.sleep(3000);

					AppLibrary.syncAndClick(mailDriver, verifyEmailLabel);

				} catch (Exception e) {
					flag = true;
				}

				AppLibrary.sleep(1000);
				mailDriver.switchTo().frame(AppLibrary.findElement(mailDriver, iframe));
				AppLibrary.syncAndClick(mailDriver, ClickOnLink);

				AppLibrary.switchToWindow(mailDriver, 3);
				AppLibrary.sleep(3000);


				if (!AppLibrary.isElementPresent(mailDriver, "xpath://input[@placeholder='Email Address']")) {
					mailDriver.navigate().refresh();

				}

				AppLibrary.findElement(mailDriver, "xpath://input[@placeholder='Email Address']");
				AppLibrary.findElement(mailDriver, "xpath://button[@class='ant-btn ant-btn-primary ant-btn-block']");
				mailDriver.close();

				AppLibrary.switchToWindow(mailDriver, 2);
				
				mailDriver.switchTo().defaultContent();
				AppLibrary.sleep(2000);
				AppLibrary.findElement(mailDriver, deleteMailButton).click();// delete
				mailDriver.close();
				AppLibrary.switchToWindow(mailDriver, 1);
			} while (flag && counter > 0);

			System.out.println("Mailinator mail verified");

		} catch (Exception e1) {
			mailDriver.quit();
			throw new Exception("Failed to access verification");
		}
	}
	

	public String getPassword(String email) throws Exception {

		String text;
		AppLibrary ap = new AppLibrary();
		mailDriver = ap.launchDefaultDriverInstance();

		boolean flag;
		int counter = 2;
		try {
			do {
				flag = false;
				counter--;
				System.out.println("Counter = " + counter);

				try {

					mailDriver
							.get("https://www.mailinator.com/v3/index.jsp?zone=public&query=" + email + "#/#inboxpane");
					AppLibrary.sleep(3000);

					AppLibrary.syncAndClick(mailDriver, forgotPasswordLabel);

				} catch (Exception e) {
					flag = true;
				}

				AppLibrary.sleep(1000);

				mailDriver.switchTo().frame(AppLibrary.findElement(mailDriver, iframe));
				text = AppLibrary.findElement(mailDriver, PasswordText).getText();

				mailDriver.switchTo().defaultContent();
				AppLibrary.findElement(mailDriver, deleteMailButton).click();// delete

			} while (flag && counter > 0);

			mailDriver.quit();

		} catch (Exception e1) {
			mailDriver.quit();
			throw new Exception("Failed to access verification");
		}
		return text;
	}

}
