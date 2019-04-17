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

public class ContactInfoUiTest extends TestBase {

	public Logger logger;

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
	public void ContactInfoPageUi() throws Exception {
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(driver).Login("agammishra12@gmail.com", "Admin123!@#");
		new HeaderPage(driver).clickOnAccountSetting();
		new ContactInfoPage(driver).contactInfoUi();
		System.out.println("Verified Successfully ");

	}
	
	
	
	


}
