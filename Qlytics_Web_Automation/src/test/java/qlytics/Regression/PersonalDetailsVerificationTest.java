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
import qlytics.Pages.HeaderPage;
import qlytics.Pages.LoginPage;
import qlytics.Pages.MailinatorPage;
import qlytics.Pages.ProfilePage;
import qlytics.Pages.SignUpPage;

public class PersonalDetailsVerificationTest extends TestBase {

	public Logger logger;
	String emailAddress;
	String Password;
	String firstname;
	String lastName;

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("PersonalDetailsVerificationTest");
		System.out.println("PersonalDetailsVerificationTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");

	}

	@Test
	public void registration() throws Exception {
		String unique = AppLibrary.getFDate() + "_" + AppLibrary.randInt();
		emailAddress = "neoTest_" + unique;
		System.out.println(emailAddress);

		firstname = appLibrary.generateRandomString(10);
		lastName = appLibrary.generateRandomString(10);
		String jobTitle = "Tester" + appLibrary.generateRandomString(3);
		String PhoneNumber = appLibrary.generateRandomNumber(10);
		Password = "Admin123!@#";

		driver = appLibrary.getDriverInstance();

		appLibrary.launchAppDirectURL("");
		AppLibrary.clickElement(driver, SignUpPage.signUpLink);

		new SignUpPage(appLibrary).registration(firstname, lastName, emailAddress + "@mailinator.com", Password,
				Password, PhoneNumber, firstname + "Company", jobTitle);

		AppLibrary.findElement(driver, SignUpPage.VerificationMessageForSignUp);

		AppLibrary.clickElement(driver, SignUpPage.loginLink);

		new MailinatorPage(appLibrary).getVerificationOnNewTab(emailAddress,"SignUp");

		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", "Admin123!@#");
		AppLibrary.findElement(driver, HeaderPage.DataMarButton);
		new HeaderPage(appLibrary).Logout();

	}

	@Test(dependsOnMethods = "registration")
	public void verifyPersonalDetailsPage() throws Exception {

		String Overview = "3 years of experience in automation testing";
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);
		new HeaderPage(appLibrary).clickOnAccountSetting();
		new ProfilePage(appLibrary).FillPersonalDetailsForm(firstname + " " + lastName, "Tester", Overview, "85",
				"India", "Other - Accounting & Consulting", "Jupyter notebook|Amazon aws|Apache", "Private",
				"More than 30 hrs/week");

		new HeaderPage(appLibrary).Logout();

		// Verification
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);
		new HeaderPage(appLibrary).clickOnAccountSetting();
		AppLibrary.clickElement(driver, ProfilePage.profileButton);

		AppLibrary.sleep(3000);
		AppLibrary.waitUntilElementDisplayed(driver, ProfilePage.availabilityLabel);
		new ProfilePage(appLibrary).verifyPersonaldetails(firstname + " " + lastName, "Tester", Overview, "85", "India",
				"Other - Accounting & Consulting", "Jupyter notebook|Amazon aws|Apache", "Private",
				"More than 30 hrs/week");

//		new ProfilePage(appLibrary).verifyPersonaldetails("agam mishra", "Tester", Overview, "85", "India",
//				"Other - Accounting & Consulting", "Jupyter notebook|Amazon aws|Apache", "Private",
//				"More than 30 hrs/week");

		appLibrary.verifyUploadedImagePath(ContactInfoPage.profileImg, "TestImg.jpg", "href");
		System.out.println("Verified Successfully ");

	}

}
