package qlytics.Pages;

import org.openqa.selenium.WebDriver;

import qlytics.Lib.AppLibrary;

public class SignUpPage {

	WebDriver driver;

	public static String qlyticsSignUpLogo = "xpath://div[@class='login-box']//img[contains(@class,'login-logo')]";
	public static String createYourAccLabel = "xpath://small[text()='CREATE YOUR ACCOUNT']";
	public static String firstNameLabel = "xpath://label[contains(text(),'First Name')]";
	public static String firtsNameInput = "xpath://input[@id='firstName']";
	public static String lastNameLabel = "xpath://label[contains(text(),'Last Name')]";
	public static String lastNameInput = "xpath://input[@id='lastName']";
	public static String businessEmailLabel = "xpath://label[contains(text(),'Business Email')]";
	public static String businessEmailInput = "xpath://input[@id='email']";
	public static String passLabel = "xpath://label[@for='password'][contains(text(),'Password')]";
	public static String passwordInput = "xpath://input[@id='password']";
	public static String cnfPassLabel = "xpath://label[contains(text(),'Confirm Password')]";
	public static String cnfPasswordInput = "xpath://input[@id='confirmPassword']";
	public static String phoneNumberLabel = "xpath://label[contains(text(),'Phone Number')]";
	public static String phoneNumberInput = "xpath://input[@id='phoneNumber']";
	public static String companyNameLabel = "xpath://label[contains(text(),'Company Name')]";
	public static String companyNameInput = "xpath://input[@id='companyName']";
	public static String jobTitleLabel = "xpath://label[contains(text(),'Job Title')]";
	public static String jobTitleInput = "xpath://input[@id='jobTitle']";
	public static String registerButton = "xpath://button[@class='ant-btn ant-btn-primary']";
	public static String alreadyHaveAccLabel = "xpath://span[contains(text(),'Already Have an account.')]";
	public static String loginLink = "xpath://a[text()='Login']";
	public static String welcomeLabel = "xpath://h1[text()='Welcome']";
	public static String platformLabel = "xpath://div[h1[text()='Welcome']]//h3[text()='#1 COGNITIVE AUTOMATION PLATFORM']";
	public static String cognitiveLabel = "xpath://div[h1[text()='Welcome']]//p[contains(text(),' The only Cognitive Automation platform built to provide the end-to-end Resources (developers, data sets, tools and applications), needed to quickly and efficiently transform human-driven business processes into machine-driven operations.')]";
	public static String workDoneLabel = "xpath://div[h1[text()='Welcome']]//h5[text()='TRANSFORM HOW WORK GETS DONE']";

	public static String signUpLink = "xpath://a[text()='Sign up']";

	// Verification Message
	public static String VerificationMessageForSignUp = "xpath://span[text()='Verification e-mail sent.']";

	// Validation Message
	public static String child = "//small[text()=\"Replace\"]";
	public static String child1 = "//div[contains(text(),\"Replace\")]";
	public static String firstNameValidation = "xpath://div[span[input[@id='firstName']]]" + child + "";
	public static String lastNamevalidation = "xpath://div[span[input[@id='lastName']]]" + child + "";
	public static String businessValidation = "xpath://div[span[input[@id='email']]]" + child + "";
	public static String passwordValidation = "xpath://div[span[input[@id='password']]]" + child + "";
	public static String otherPasswordvalidation = "xpath://div[span[input[@id='password']]]" + child1 + "";

	public static String cnfPasswordValidation = "xpath://div[span[input[@id='confirmPassword']]]" + child + "";
	public static String otherCnfPasswordValidation = "xpath://div[span[input[@id='confirmPassword']]]" + child1 + "";

	public static String phoneNumberValidation = "xpath://div[span[input[@id='phoneNumber']]]" + child + "";
	public static String otherphoneNumberValidation = "xpath://div[span[input[@id='phoneNumber']]]" + child1 + "";

	public static String comapnyNameValidation = "xpath://div[span[input[@id='companyName']]]" + child + "";

	public static String jobTitleValidation = "xpath://div[span[input[@id='jobTitle']]]" + child + "";
	
	public static String otherValidation = "xpath://span[contains(text(),'Replace')]";

	public SignUpPage(WebDriver driver) {
		super();
		this.driver = driver;

	}

	public SignUpPage verifySignUpPageUi() {

		AppLibrary.sleep(1000);
		AppLibrary.findElement(driver, qlyticsSignUpLogo);
		AppLibrary.findElement(driver, createYourAccLabel);
		AppLibrary.findElement(driver, firstNameLabel);
		AppLibrary.findElement(driver, firtsNameInput);
		AppLibrary.findElement(driver, lastNameLabel);
		AppLibrary.findElement(driver, lastNameInput);
		AppLibrary.findElement(driver, businessEmailLabel);
		AppLibrary.findElement(driver, businessEmailInput);
		AppLibrary.findElement(driver, passLabel);
		AppLibrary.findElement(driver, passwordInput);
		AppLibrary.findElement(driver, cnfPassLabel);
		AppLibrary.findElement(driver, cnfPasswordInput);
		AppLibrary.findElement(driver, phoneNumberLabel);
		AppLibrary.findElement(driver, phoneNumberInput);
		AppLibrary.findElement(driver, companyNameLabel);
		AppLibrary.findElement(driver, companyNameInput);
		AppLibrary.findElement(driver, jobTitleLabel);
		AppLibrary.findElement(driver, jobTitleInput);
		AppLibrary.findElement(driver, registerButton);
		AppLibrary.findElement(driver, alreadyHaveAccLabel);
		AppLibrary.findElement(driver, loginLink);
		AppLibrary.findElement(driver, welcomeLabel);
		AppLibrary.findElement(driver, platformLabel);
		AppLibrary.findElement(driver, cognitiveLabel);
		AppLibrary.findElement(driver, workDoneLabel);
		AppLibrary.sleep(1000);
		return new SignUpPage(driver);

	}

	public void registration(String firstName, String lastName, String email, String pass, String CnfPass,
			String PhoneNo, String CompanyName, String jobTitle) {

		AppLibrary.enterText(driver, firtsNameInput, firstName);
		AppLibrary.enterText(driver, lastNameInput, lastName);
		AppLibrary.enterText(driver, businessEmailInput, email);
		AppLibrary.enterText(driver, passwordInput, pass);
		AppLibrary.enterText(driver, cnfPasswordInput, CnfPass);
		AppLibrary.enterText(driver, phoneNumberInput, PhoneNo);
		AppLibrary.enterText(driver, companyNameInput, CompanyName);
		AppLibrary.enterText(driver, jobTitleInput, jobTitle);
		AppLibrary.clickElement(driver, registerButton);
	}

	public void registrationForValidation(String firstName, String lastName, String email, String pass, String CnfPass,
			String PhoneNo, String CompanyName, String jobTitle) {

		if (!firstName.equalsIgnoreCase("")) {
			AppLibrary.enterText(driver, firtsNameInput, firstName);
		}
		if (!lastName.equalsIgnoreCase("")) {
			AppLibrary.enterText(driver, lastNameInput, lastName);
		}
		if (!email.equalsIgnoreCase("")) {
			AppLibrary.enterText(driver, businessEmailInput, email);
		}
		if (!pass.equalsIgnoreCase("")) {
			AppLibrary.enterText(driver, passwordInput, pass);
		}
		if (!CnfPass.equalsIgnoreCase("")) {
			AppLibrary.enterText(driver, cnfPasswordInput, CnfPass);
		}
		if (!PhoneNo.equalsIgnoreCase("")) {
			AppLibrary.enterText(driver, phoneNumberInput, PhoneNo);
		}
		if (!CompanyName.equalsIgnoreCase("")) {
			AppLibrary.enterText(driver, companyNameInput, CompanyName);
		}
		if (!jobTitle.equalsIgnoreCase("")) {
			AppLibrary.enterText(driver, jobTitleInput, jobTitle);
		}

		AppLibrary.clickElement(driver, registerButton);

	}
}
