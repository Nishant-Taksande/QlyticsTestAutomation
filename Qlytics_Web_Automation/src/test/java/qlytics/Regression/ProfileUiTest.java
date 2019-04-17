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
import qlytics.Pages.ProfilePage;

public class ProfileUiTest extends TestBase {

	public Logger logger;

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("ProfileUiTest");
		System.out.println("ProfileUiTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");

	}

	@Test
	public void PersonalDetailsPageUi() throws Exception {
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(driver).Login("agammishra12@gmail.com", "Admin123!@#");
		new HeaderPage(driver).clickOnAccountSetting();
		new ProfilePage(driver).PersonalDetailsPageUi();
		System.out.println("Verified Successfully ");

	}
	
	
	@Test
	public void EducationPageUi() throws Exception {
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(driver).Login("agammishra12@gmail.com", "Admin123!@#");
		new HeaderPage(driver).clickOnAccountSetting();
		new ProfilePage(driver).educationUi();
		System.out.println("Verified Successfully ");

	}	
	
	@Test
	public void EmploymentHistoryPageUi() throws Exception {
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(driver).Login("agammishra12@gmail.com", "Admin123!@#");
		new HeaderPage(driver).clickOnAccountSetting();
		new ProfilePage(driver).EmploymentHistoryUi();
		System.out.println("Verified Successfully ");

	}

}
