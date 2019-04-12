package qlytics.Regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qlytics.Lib.AppLibrary;
import qlytics.Lib.TestBase;
import qlytics.Pages.LoginPage;

public class LoginUiTest extends TestBase {

	public Logger logger;

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("LoginUiTest");
		System.out.println("LoginUiTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");

	}

	@Test
	public void LoginPageUi() throws Exception {
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		new LoginPage(driver).LoginPageUi();
		System.out.println("Verified Successfully ");

	}

}
