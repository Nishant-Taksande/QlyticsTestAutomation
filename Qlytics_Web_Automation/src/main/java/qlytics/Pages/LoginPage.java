package qlytics.Pages;

import org.openqa.selenium.WebDriver;

import qlytics.Lib.AppLibrary;

public class LoginPage {

	WebDriver driver;

	public static String qlyticsLoginLogo = "xpath://div[form[button[@class='ant-btn ant-btn-primary ant-btn-block']]]//img[contains(@class,'login-logo')]";
	public static String LoginTOYourAccLabel = "xpath://small[text()='LOG IN TO YOUR ACCOUNT']";
	public static String EmailAddressInput = "xpath://input[@placeholder='Email Address']";
	public static String LoginpasswordInput = "xpath://input[@placeholder='Password']";
	public static String LoginButton = "xpath://button[@class='ant-btn ant-btn-primary ant-btn-block']";
	public static String orLabel = "xpath://span[text()='or']";
	public static String signUpLink = "xpath://a[text()='Sign up']";
	public static String forgotPassLink = "xpath://a[text()='Forgot password']";

	public static String welcomeBackLabel = "xpath://h1[text()='Welcome Back']";
	public static String platformLabel = "xpath://div[h1[text()='Welcome Back']]//h3[text()='#1 COGNITIVE AUTOMATION PLATFORM']";
	public static String cognitiveLabel = "xpath://div[h1[text()='Welcome Back']]//p[contains(text(),' The only Cognitive Automation platform built to provide the end-to-end Resources (developers, data sets, tools and applications), needed to quickly and efficiently transform human-driven business processes into machine-driven operations.')]";
	public static String workDoneLabel = "xpath://div[h1[text()='Welcome Back']]//h5[text()='TRANSFORM HOW WORK GETS DONE']";

	
	//Validation 
	public static String noActiveAcc = "xpath://span[text()='No active account found with the given credentials']";
	public static String emailValidation = "xpath://div[span[nz-input-group[input[@formcontrolname='email']]]]//div[text()=\"Replace\"]";
	public static String passValidation = "xpath://div[span[nz-input-group[input[@placeholder='Password']]]]//div[text()=\"Replace\"]";
	
	
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LoginPage LoginPageUi() {

		AppLibrary.sleep(1000);
		AppLibrary.verifyElement(driver, qlyticsLoginLogo,true);
		AppLibrary.verifyElement(driver, LoginTOYourAccLabel,true);
		AppLibrary.verifyElement(driver, EmailAddressInput,true);
		AppLibrary.verifyElement(driver, LoginpasswordInput,true);
		AppLibrary.verifyElement(driver, LoginButton,true);
		AppLibrary.verifyElement(driver, orLabel,true);
		AppLibrary.verifyElement(driver, signUpLink,true);
		AppLibrary.verifyElement(driver, forgotPassLink,true);
		AppLibrary.verifyElement(driver, welcomeBackLabel,true);
		AppLibrary.verifyElement(driver, platformLabel,true);
		AppLibrary.verifyElement(driver, cognitiveLabel,true);
		AppLibrary.verifyElement(driver, workDoneLabel,true);

		return new LoginPage(driver);

	}

	public void Login(String emailaddess, String pass) {
		AppLibrary.sleep(1000);
		AppLibrary.enterText(driver, EmailAddressInput, emailaddess);
		AppLibrary.enterText(driver, LoginpasswordInput, pass);
		AppLibrary.clickElement(driver, LoginButton);
		AppLibrary.sleep(1000);
	}

}
