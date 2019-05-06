package qlytics.Regression;

import java.io.IOException;

import org.apache.http.entity.mime.Header;
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
import qlytics.Pages.SignUpPage;

public class ContactInfoPageVerification extends TestBase {

	public Logger logger;
	String emailAddress;
	String firstname;
	String lastName;
	String jobTitle;
	String PhoneNumber;
	String Password;

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

		firstname = appLibrary.generateRandomString(10);
		lastName = appLibrary.generateRandomString(10);
		jobTitle = "Tester" + appLibrary.generateRandomString(3);
		PhoneNumber = appLibrary.generateRandomNumber(10);
		Password = "Admin123!@#";

		driver = appLibrary.getDriverInstance();

		appLibrary.launchAppDirectURL("");
		AppLibrary.clickElement(driver, SignUpPage.signUpLink);

		new SignUpPage(appLibrary).registration(firstname, lastName, emailAddress + "@mailinator.com", Password, Password,
				PhoneNumber, firstname + "Company", jobTitle);

		AppLibrary.findElement(driver, SignUpPage.VerificationMessageForSignUp);

		AppLibrary.clickElement(driver, SignUpPage.loginLink);

		new MailinatorPage(appLibrary).getVerificationOnNewTab(emailAddress,"SignUp");

		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", "Admin123!@#");
		AppLibrary.findElement(driver, HeaderPage.DataMarButton);
		new HeaderPage(appLibrary).Logout();

	}

	@Test(dependsOnMethods = "registration")
	public void verifyContactInfoPageWithSignUp() throws Exception {
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);
		new HeaderPage(appLibrary).clickOnAccountSetting();
		new ContactInfoPage(appLibrary).verifyContactInfoData(firstname, lastName, PhoneNumber, jobTitle);
		appLibrary.uploadImage(driver, ContactInfoPage.profileUploadButton, "ProfilePic.png", ContactInfoPage.profileImg,"href");
		appLibrary.verifyUploadedImagePath(HeaderPage.ProfilePicHeader, "ProfilePic.png","src");
		System.out.println("Verified Successfully ");

	}

}
