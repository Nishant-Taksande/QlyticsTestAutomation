package qlytics.Regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.opc.internal.signature.DigitalSignatureOriginPart;
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
import qlytics.Pages.SignUpPage;

public class SignUpFullValidationTest extends TestBase {

	public Logger logger;
//	private WebDriver driverw;
	private AppLibrary appLibrary;
	private String testName;

	@DataProvider(name = "Registration")
	public String[][] getRegistrationDataFromExcelOne() throws Exception {

		String str[][] = AppLibrary.readExcel("TestData/QlyticsSignUpPageValidation.xls", 0);
		return str;
	}

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("SignUpFullValidationTest");
		System.out.println("SignUpFullValidationTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
		testName = this.getClass().getSimpleName();
		testName = ((testName != null && !(testName.equals("Default test"))) ? testName
				: this.getClass().getSimpleName());
		driver = appLibrary.getDriverInstance();
		appLibrary.launchApp("");
		AppLibrary.clickElement(driver, LoginPage.signUpLink);
	}

	@Test(dataProvider = "Registration")
	public void testSignupFullValidation(String id,String email, String psd, String cnfPassword, String firstName,
			String lastName, String phoneNumber, String companyName, String jobTitle, String emailvalidation,
			String psdvalidation, String passOtherValidation, String cnfPassValidation, String cnfPassOtherValidation,
			String firstNameValidation, String lastNameValidation, String phoneNoValidation,
			String otherPhoneValidation, String companyNameValidation, String jobTitlevalidation,
			String otherValidation, String exeIndicator) throws Exception {

		if (exeIndicator.equalsIgnoreCase("Yes")) {
			driver.navigate().refresh();
			new SignUpPage(appLibrary).registrationForValidation(firstName, lastName, email, psd, cnfPassword, phoneNumber,
					companyName, jobTitle);

			if (!firstNameValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver, SignUpPage.firstNameValidation.replace("Replace", firstNameValidation),true);
			}

			if (!lastNameValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver, SignUpPage.lastNamevalidation.replace("Replace", lastNameValidation),true);
			}

			if (!emailvalidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver, SignUpPage.businessValidation.replace("Replace", emailvalidation),true);
			}

			if (!psdvalidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver, SignUpPage.passwordValidation.replace("Replace", psdvalidation),true);
			}

			if (!passOtherValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver,
						SignUpPage.otherPasswordvalidation.replace("Replace", passOtherValidation),true);
			}
			if (!cnfPassValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver, SignUpPage.cnfPasswordValidation.replace("Replace", cnfPassValidation),true);
			}
			if (!cnfPassOtherValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver,
						SignUpPage.otherCnfPasswordValidation.replace("Replace", cnfPassOtherValidation),true);
			}

			if (!phoneNoValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver, SignUpPage.phoneNumberValidation.replace("Replace", phoneNoValidation),true);
			}

			if (!otherPhoneValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver,
						SignUpPage.otherphoneNumberValidation.replace("Replace", otherPhoneValidation),true);
			}

			if (!companyNameValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver,
						SignUpPage.comapnyNameValidation.replace("Replace", companyNameValidation),true);
			}

			if (!jobTitlevalidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver,
						SignUpPage.jobTitleValidation.replace("Replace", jobTitlevalidation),true);
			}
			
			if (!otherValidation.equalsIgnoreCase("")) {
				AppLibrary.verifyElement(driver,
						SignUpPage.otherValidation.replace("Replace", otherValidation),true);
			}
			
		}

	}

	@Override
	@AfterMethod
	public void checkAlerts(ITestResult result) {
		appLibrary.checkAlertsForScreenshot(result, testName);
		
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
