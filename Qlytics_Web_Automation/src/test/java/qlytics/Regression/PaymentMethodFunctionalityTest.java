package qlytics.Regression;

import java.io.IOException;

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
import qlytics.Pages.PaymentMethodPage;
import qlytics.Pages.SignUpPage;

public class PaymentMethodFunctionalityTest extends TestBase {

	public Logger logger;
	String emailAddress;
	String Password;

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("EmploymentHistoryFunctionalityTest");
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
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);
		AppLibrary.clickElement(driver, HeaderPage.organisationButton);
		AppLibrary.clickElement(driver, PaymentMethodPage.paymentMethodButton);
		AppLibrary.clickElement(driver, PaymentMethodPage.addBillingDetailsButton);
		new PaymentMethodPage(appLibrary).enterCardDetails("Test Card", "4111111111111111", "0223", "123", "47400");
		AppLibrary.sleep(2000);
		new PaymentMethodPage(appLibrary).verifyEnteredCardDetails("Test Card");
		new HeaderPage(appLibrary).Logout();
	}

	@Test(dependsOnMethods = "Creation")
	public void Deletion() throws Exception {

		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);
		AppLibrary.clickElement(driver, HeaderPage.organisationButton);
		AppLibrary.clickElement(driver, PaymentMethodPage.paymentMethodButton);
		AppLibrary.clickElement(driver, PaymentMethodPage.deleteButton);
		AppLibrary.waitUntilElementDisplayed(driver, PaymentMethodPage.fullNameLabel);
		AppLibrary.clickElement(driver, PaymentMethodPage.paymentMethodButton);
		new PaymentMethodPage(appLibrary).verifyPaymentmethodDeletion();

		System.out.println("Verified Successfully ");
	}
}