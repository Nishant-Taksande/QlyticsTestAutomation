package qlytics.Regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.ShellAPI.APPBARDATA;

import qlytics.Lib.AppLibrary;
import qlytics.Lib.TestBase;
import qlytics.Pages.ContactInfoPage;
import qlytics.Pages.HeaderPage;
import qlytics.Pages.LoginPage;
import qlytics.Pages.MailinatorPage;
import qlytics.Pages.ProfilePage;
import qlytics.Pages.SignUpPage;

public class ContactInfoEditTest extends TestBase {

	public Logger logger;
	String emailAddress;
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

		String firstname = appLibrary.generateRandomString(10);
		String lastName = appLibrary.generateRandomString(10);
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
	public void verifyContactInfoPageWithSignUp() throws Exception {

		String firstname = appLibrary.generateRandomString(10);
		String lastName = appLibrary.generateRandomString(10);
		String jobTitle = "Tester" + appLibrary.generateRandomString(3);
		String PhoneNumber = appLibrary.generateRandomNumber(10);

		Password = "Admin123!@#";

		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);
		new HeaderPage(appLibrary).clickOnAccountSetting();
		appLibrary.uploadImage(driver, ContactInfoPage.profileUploadButton, "ProfilePic.png",
				ContactInfoPage.profileImg, "href");
		new ContactInfoPage(appLibrary).editContactInfo(firstname, lastName, PhoneNumber, jobTitle);

		AppLibrary.clickElement(driver, ProfilePage.profileButton);
		AppLibrary.sleep(3000);
		AppLibrary.clickElement(driver, ContactInfoPage.contactInfoButton);
		AppLibrary.sleep(2000);

		
		appLibrary.uploadImage(driver, ContactInfoPage.profileUploadButton, "TestImg.jpg", ContactInfoPage.profileImg,
				"href");
		// Verification
		new ContactInfoPage(appLibrary).verifyContactInfoData(firstname, lastName, PhoneNumber, jobTitle);
		appLibrary.verifyUploadedImagePath(HeaderPage.ProfilePicHeader, "TestImg.jpg", "src");

		System.out.println("Verified Successfully ");

	}

}
