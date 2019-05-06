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
import qlytics.Pages.InvitationPage;
import qlytics.Pages.LoginPage;
import qlytics.Pages.MailinatorPage;
import qlytics.Pages.SignUpPage;

public class InvitationManagerUserVerificationTest extends TestBase {

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
		logger = Logger.getLogger("InvitationManagerUserVerificationTest");
		System.out.println("InvitationManagerUserVerificationTestStarted");
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

		new SignUpPage(appLibrary).registration(firstname, lastName, emailAddress + "@mailinator.com", Password,
				Password, PhoneNumber, firstname + "Company", jobTitle);

		AppLibrary.findElement(driver, SignUpPage.VerificationMessageForSignUp);

		AppLibrary.clickElement(driver, SignUpPage.loginLink);

		new MailinatorPage(appLibrary).getVerificationOnNewTab(emailAddress, "SignUp");

		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", "Admin123!@#");
		AppLibrary.findElement(driver, HeaderPage.DataMarButton);
		new HeaderPage(appLibrary).Logout();

	}

	@Test(dependsOnMethods = "registration")
	public void testInvitationManagerUserVerification() throws Exception {
		String unique = AppLibrary.getFDate() + "_" + AppLibrary.randInt();
		String ManEmail = "neoTestMan_" + unique;
		String Invitefirstname = appLibrary.generateRandomString(10);
		String InvitelastName = appLibrary.generateRandomString(10);
		String InvitejobTitle = "Tester" + appLibrary.generateRandomString(3);
		String InvitePhoneNumber = appLibrary.generateRandomNumber(10);
		String InvitePassword = "Admin123!@#";

		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);

		AppLibrary.clickElement(driver, HeaderPage.organisationButton);
		AppLibrary.clickElement(driver, InvitationPage.inviteMemberButton);

		// Invite member
		new InvitationPage(appLibrary).fillInviteMemberForm(ManEmail + "@mailinator.com", "managers");

		// Verify invited admin in pending invitation

		AppLibrary.clickElement(driver, InvitationPage.pendingInvitationButton);

		new InvitationPage(appLibrary).verifyPendingInvitationMemberData(ManEmail + "@mailinator.com",
				ManEmail + "@mailinator.com", "MANAGERS", "No", "");

		AppLibrary.clickElement(driver, InvitationPage.closePendingButton);
		new HeaderPage(appLibrary).Logout();

		new MailinatorPage(appLibrary).openLink(ManEmail, "Invitation");

		// Accept Invitation

		AppLibrary.clickElement(driver, InvitationPage.acceptButton);

		// Complete invited Admin Profile
		new SignUpPage(appLibrary).registrationForValidation(Invitefirstname, InvitelastName, "", InvitePassword,
				InvitePassword, InvitePhoneNumber, "", InvitejobTitle);

		new LoginPage(appLibrary).Login(ManEmail + "@mailinator.com", Password);

		new HeaderPage(appLibrary).Logout();

		// Verify accept invitation
		new LoginPage(appLibrary).Login(emailAddress + "@mailinator.com", Password);
		AppLibrary.clickElement(driver, HeaderPage.organisationButton);
		
		new InvitationPage(appLibrary).verifyInvitationMemberData(Invitefirstname, Invitefirstname, InvitelastName,
				ManEmail + "@mailinator.com", "Manager");

		AppLibrary.clickElement(driver, InvitationPage.pendingInvitationButton);

		//verify Pending Invitation >> Accept invitation(Yes)
		new InvitationPage(appLibrary).verifyPendingInvitationMemberData(ManEmail + "@mailinator.com",
				ManEmail + "@mailinator.com", "MANAGERS", "Yes", "");

		AppLibrary.clickElement(driver, InvitationPage.closePendingButton);

		new HeaderPage(appLibrary).Logout();

		System.out.println("Verified Successfully ");

	}

}
