package qlytics.Regression;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.ApplicationCache;

import qlytics.Lib.AppLibrary;
import qlytics.Lib.TestBase;
import qlytics.Pages.LoginPage;
import qlytics.Pages.SignUpPage;

public class SignUpAbsentValidationTest extends TestBase {

	public Logger logger;
//	private WebDriver driverw;
	private AppLibrary appLibrary;

	@DataProvider(name = "Registration")
	public String[][] getRegistrationDataFromExcelOne() throws Exception {

		String str[][] = AppLibrary.readExcel("TestData/QlyticsSignUpPageValidation.xls", 4);
		return str;
	}

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("SignUpAbsentValidationTest");
		System.out.println("SignUpAbsentValidationTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");

		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		AppLibrary.clickElement(driver, LoginPage.signUpLink);
	}

	@Test(dataProvider = "Registration")
	public void testSignUpAbsentValidation(String email, String psd, String cnfPassword, String firstName,
			String lastName, String phoneNumber, String companyName, String jobTitle, String emailvalidation,
			String psdvalidation, String passOtherValidation, String cnfPassValidation, String cnfPassOtherValidation,
			String firstNameValidation, String lastNameValidation, String phoneNoValidation,
			String otherPhoneValidation, String companyNameValidation, String jobTitlevalidation, String exeIndicator)
			throws Exception {

		if (exeIndicator.equalsIgnoreCase("Yes")) {

			new SignUpPage(driver).registrationForValidation(firstName, lastName, email, psd, cnfPassword, phoneNumber,
					companyName, jobTitle);

			if (!firstNameValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver, SignUpPage.firstNameValidation.replace("Replace", firstNameValidation));
				
			
			}

			if (!lastNameValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver, SignUpPage.lastNamevalidation.replace("Replace", lastNameValidation));
			}

			if (!emailvalidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver, SignUpPage.businessValidation.replace("Replace", emailvalidation));
			}

			if (!psdvalidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver, SignUpPage.passwordValidation.replace("Replace", psdvalidation));
			}

			if (!passOtherValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver,
						SignUpPage.otherPasswordvalidation.replace("Replace", passOtherValidation));
			}
			if (!cnfPassValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver, SignUpPage.cnfPasswordValidation.replace("Replace", cnfPassValidation));
			}
			if (!cnfPassOtherValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver,
						SignUpPage.otherCnfPasswordValidation.replace("Replace", cnfPassOtherValidation));
			}

			if (!phoneNoValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver, SignUpPage.phoneNumberValidation.replace("Replace", phoneNoValidation));
			}

			if (!otherPhoneValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver,
						SignUpPage.otherphoneNumberValidation.replace("Replace", otherPhoneValidation));
			}

			if (!companyNameValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver,
						SignUpPage.comapnyNameValidation.replace("Replace", companyNameValidation));
			}

			if (!jobTitlevalidation.equalsIgnoreCase("")) {
				AppLibrary.verifyAbsent(driver, SignUpPage.jobTitleValidation.replace("Replace", jobTitlevalidation));
			}

			driver.navigate().refresh();
		}

	}

	@Override
	@AfterMethod
	public void checkAlerts(ITestResult result) {
		System.out.println("im doing nothign");
	}

	@Override
	@AfterClass(alwaysRun = true)
	public void quitBrowser() {
		if (driver != null)
			driver.quit();

		Reporter.log("Closing the Browser Successfully", true);
		System.out.println("Closing the Browser Successfully");
		Reporter.log("</table>");
	}
}
