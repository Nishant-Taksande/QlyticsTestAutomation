package qlytics.Regression;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qlytics.Lib.AppLibrary;
import qlytics.Lib.TestBase;
import qlytics.Pages.HeaderPage;
import qlytics.Pages.LoginPage;
import qlytics.Pages.MailinatorPage;
import qlytics.Pages.ProfilePage;
import qlytics.Pages.SignUpPage;

public class EducationEditTest extends TestBase {

	public Logger logger;
	String emailAddress;
	String Password;

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("EducationEditTest");
		System.out.println("EducationEditTestStarted");
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
	public void Creation() throws Exception {

		List<String> givenList = Arrays.asList("IItm", "ips", "iit", "iim");
		Random rand = new Random();
		String college = givenList.get(rand.nextInt(givenList.size()));

		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);
		new HeaderPage(appLibrary).clickOnAccountSetting();
		AppLibrary.clickElement(driver, ProfilePage.profileButton);
		AppLibrary.waitUntilElementDisplayed(driver, ProfilePage.educationButton);
		AppLibrary.clickElement(driver, ProfilePage.educationButton);

		// Create education
		new ProfilePage(appLibrary).FillEductaionForm("electrical", "bhopal", college,
				"Associate of Arts and Sciences (A.A.S.)");

		new HeaderPage(appLibrary).Logout();
	}

	@Test(dependsOnMethods = "Creation")
	public void edition() throws Exception {

		List<String> givenList = Arrays.asList("IItm", "ips", "iit", "iim");
		Random rand = new Random();
		String college = givenList.get(rand.nextInt(givenList.size()));

		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);
		new HeaderPage(appLibrary).clickOnAccountSetting();
		AppLibrary.clickElement(driver, ProfilePage.profileButton);
		AppLibrary.waitUntilElementDisplayed(driver, ProfilePage.educationButton);
		AppLibrary.clickElement(driver, ProfilePage.educationButton);
		// Edit
		new ProfilePage(appLibrary).EditEducation("Software", "gwalior", college, "Doctorate");

		// Verification
		new ProfilePage(appLibrary).VerifyEductaionForm("Software", "gwalior", college, "Doctorate");

		System.out.println("Verified Successfully ");
	}

}
