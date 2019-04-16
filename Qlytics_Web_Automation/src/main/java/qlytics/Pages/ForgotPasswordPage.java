package qlytics.Pages;

import org.openqa.selenium.WebDriver;

import qlytics.Lib.AppLibrary;

public class ForgotPasswordPage {

	WebDriver driver;
	public static String qlyticsLForgotPasswordLogo = "xpath://div[form[contains(@class,'forgot-password')]]//img[contains(@class,'login-logo')]";
	public static String recoverLabel = "xpath://small[text()='Recover your account password']";
	public static String emailInput = "xpath://div[form[contains(@class,'forgot-password')]]//input[@formcontrolname='email']";
	public static String resetPassButton = "xpath://div[form[contains(@class,'forgot-password')]]//button[span[contains(text(),'Reset Password')]]";
	public static String remeberYourPassLabel = "xpath://div[form[contains(@class,'forgot-password')]]//span[contains(text(),'Remembered your password?')]";
	public static String remeberYourPasLoginLink = "xpath://div[form[contains(@class,'forgot-password')]]//a[text()='Log in']";

	public static String welcomeBackLabel = "xpath://h1[text()='Welcome Back']";
	public static String platformLabel = "xpath://div[h1[text()='Welcome Back']]//h3[text()='#1 COGNITIVE AUTOMATION PLATFORM']";
	public static String cognitiveLabel = "xpath://div[h1[text()='Welcome Back']]//p[contains(text(),' The only Cognitive Automation platform built to provide the end-to-end Resources (developers, data sets, tools and applications), needed to quickly and efficiently transform human-driven business processes into machine-driven operations.')]";
	public static String workDoneLabel = "xpath://div[h1[text()='Welcome Back']]//h5[text()='TRANSFORM HOW WORK GETS DONE']";

	public static String verificationMessage = "xpath://span[text()='Password reset e-mail has been sent.']";

	// Reset Password
	public static String ResetPasswordLabel = "xpath://div[h5[small[contains(text(),'reset your password')]]]//small[text()='reset your password']";

	public static String newpassInput = "xpath://div[h5[small[contains(text(),'reset your password')]]]//input[@formcontrolname='new_password1']";
	public static String cnfNewPassInput = "xpath://div[h5[small[contains(text(),'reset your password')]]]//input[@formcontrolname='new_password2']";

	public static String resetPassButton2 = "xpath://div[h5[small[contains(text(),'reset your password')]]]//button[span[contains(text(),'Reset Password')]]";

	public ForgotPasswordPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public ForgotPasswordPage forgotPassUi() {

		AppLibrary.sleep(1000);
		AppLibrary.findElement(driver, qlyticsLForgotPasswordLogo);
		AppLibrary.findElement(driver, recoverLabel);
		AppLibrary.findElement(driver, emailInput);
		AppLibrary.findElement(driver, resetPassButton);
		AppLibrary.findElement(driver, remeberYourPassLabel);
		AppLibrary.findElement(driver, remeberYourPasLoginLink);
		AppLibrary.findElement(driver, welcomeBackLabel);
		AppLibrary.findElement(driver, platformLabel);
		AppLibrary.findElement(driver, cognitiveLabel);
		AppLibrary.findElement(driver, workDoneLabel);

		return new ForgotPasswordPage(driver);

	}

	public void enterNewPassword(String Pass, String newPass) {
		AppLibrary.sleep(1000);
		AppLibrary.enterText(driver, newpassInput, Pass);
		AppLibrary.enterText(driver, cnfNewPassInput, newPass);
		AppLibrary.clickElement(driver, resetPassButton2);

	}

}
