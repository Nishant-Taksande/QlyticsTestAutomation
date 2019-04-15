package qlytics.Regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qlytics.Lib.AppLibrary;
import qlytics.Lib.TestBase;
import qlytics.Pages.LoginPage;

public class LoginValidationTest extends TestBase {

	public Logger logger;
	private WebDriver driverw;
	private AppLibrary appLibrary;

	@DataProvider(name = "LoginValidation")
	public String[][] getLoginValidationDataFromExcel() throws Exception {

		String str[][] = AppLibrary.readExcel("TestData/QlyticsLoginValidation.xls", 0);
		return str;
	}

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("LoginValidationTest");
		System.out.println("LoginValidationTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
		driverw = appLibrary.getDriverInstance();
	}

	@Test(dataProvider = "LoginValidation")
	public void testLoginValidation(String email, String psd, String emailvalidation, String psdvalidation,
			String otherValidation, String exeIndicator) throws IOException {

		appLibrary.launchAppDirectURL("");

		if (exeIndicator.equalsIgnoreCase("Yes")) {
			if (!email.equalsIgnoreCase("")) {

				AppLibrary.enterText(driverw, LoginPage.EmailAddressInput, email);
			}
			if (!psd.equalsIgnoreCase("")) {
				AppLibrary.enterText(driverw, LoginPage.LoginpasswordInput, psd);
			}
			AppLibrary.clickElement(driverw, LoginPage.LoginButton);

			if (!emailvalidation.equalsIgnoreCase("")) {
				AppLibrary.findElement(driverw, LoginPage.emailValidation.replace("Replace", emailvalidation));
			}

			if (!psdvalidation.equalsIgnoreCase("")) {
				AppLibrary.findElement(driverw, LoginPage.passValidation.replace("Replace", psdvalidation));
			}

			if (!otherValidation.equalsIgnoreCase("")) {
				AppLibrary.findElement(driverw, LoginPage.noActiveAcc.replace("Replace", otherValidation));
				
	
			}
		}
	}

	@Override
	@AfterMethod
	public void checkAlerts(ITestResult result) {
		System.out.println("i do nothign");
	}

	@Override
	@AfterClass(alwaysRun = true)
	public void quitBrowser() {
		appLibrary.closeBrowser();
		Reporter.log("Closing the Browser Successfully", true);
		System.out.println("Closing the Browser Successfully");
		Reporter.log("</table>");
	}

}
