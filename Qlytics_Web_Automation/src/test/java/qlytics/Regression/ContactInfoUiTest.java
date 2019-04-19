package qlytics.Regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qlytics.Lib.AppLibrary;
import qlytics.Lib.TestBase;
import qlytics.Pages.ContactInfoPage;
import qlytics.Pages.ForgotPasswordPage;
import qlytics.Pages.HeaderPage;
import qlytics.Pages.LoginPage;
import qlytics.Pages.MailinatorPage;
import qlytics.Pages.SignUpPage;

public class ContactInfoUiTest extends TestBase {

	public Logger logger;
	String emailAddress;
	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("ContactInfoUiTest");
		System.out.println("ContactInfoUiTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");

	}

	@Test
	public void registration() throws Exception {
		String unique = AppLibrary.getFDate() + "_" + AppLibrary.randInt();
		emailAddress = "neoTest_" + unique;
		System.out.println(emailAddress);

		String firstname = appLibrary.generateRandomString(10);
		String LastName = appLibrary.generateRandomString(10);

		String Password = "Admin123!@#";

		driver = appLibrary.getDriverInstance();

		appLibrary.launchAppDirectURL("");
		AppLibrary.clickElement(driver, SignUpPage.signUpLink);

		new SignUpPage(driver).registration(firstname, LastName, emailAddress + "@mailinator.com", Password, Password,
				"8989700929", firstname + "Company", "Tester");

		AppLibrary.findElement(driver, SignUpPage.VerificationMessageForSignUp);

		AppLibrary.clickElement(driver, SignUpPage.loginLink);

		new MailinatorPage(driver).getVerificationOnNewTab(emailAddress);

		new LoginPage(driver).Login(emailAddress + "@mailinator.com", "Admin123!@#");
		AppLibrary.findElement(driver, HeaderPage.DataMarButton);
		new HeaderPage(driver).Logout();

	}
	
	@Test(dependsOnMethods = "registration")
	public void ContactInfoPageUi() throws Exception {
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(driver).Login(emailAddress+ "@mailinator.com", "Admin123!@#");
		new HeaderPage(driver).clickOnAccountSetting();
		new ContactInfoPage(driver).contactInfoUi();
		System.out.println("Verified Successfully ");

	}
	
	
	
	


}