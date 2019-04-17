package qlytics.Pages;

import org.openqa.selenium.WebDriver;

import qlytics.Lib.AppLibrary;

public class ContactInfoPage {
	WebDriver driver;

	// contact Information
	public static String contactInfoButton = "xpath://li[span[contains(text(),'Contact Information')]]";
	public static String contactInfoLabel = "xpath://div[text()='Contact Information']";

	public static String contactInfoParent = "xpath://div[ql-contact-information[nz-card[div[div[div[text()='Contact Information']]]]]]";

	public static String profileImgLabel = "" + contactInfoParent + "//label[text()='Profile Picture *']";
	public static String profileUploadButton = "" + contactInfoParent + "//div[@class='ant-upload']";
	public static String firstNameLabel = "" + contactInfoParent + "//label[@for='first_name']";
	public static String firstNameInput = "" + contactInfoParent + "//input[@id='first_name']";
	public static String lastnameLabel = "" + contactInfoParent + "//label[@for='last_name']";
	public static String lastNameInput = "" + contactInfoParent + "//input[@id='last_name']";

	public static String jobTitleLabel = "" + contactInfoParent + "//label[@for='job_title']";
	public static String jobTitleInput = "" + contactInfoParent + "//input[@id='job_title']";

	public static String phoneNoLabel = "" + contactInfoParent + "//label[@for='phone_number']";
	public static String phoneNoInput = "" + contactInfoParent + "//input[@id='phone_number']";

	public static String saveButtonContInfo = "" + contactInfoParent + "//button[//span[text()='Save changes']]";
	
	
	public ContactInfoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public ContactInfoPage contactInfoUi() {

		AppLibrary.sleep(3000);
		AppLibrary.verifyElement(driver, contactInfoButton, true);
		AppLibrary.verifyElement(driver, contactInfoLabel, true);
		AppLibrary.verifyElement(driver, profileImgLabel, true);
		AppLibrary.verifyElement(driver, profileUploadButton, true);
		AppLibrary.verifyElement(driver, firstNameLabel, true);
		AppLibrary.verifyElement(driver, firstNameInput, true);
		AppLibrary.verifyElement(driver, lastnameLabel, true);
		AppLibrary.verifyElement(driver, lastNameInput, true);
		AppLibrary.verifyElement(driver, jobTitleLabel, true);
		AppLibrary.verifyElement(driver, jobTitleInput, true);
		AppLibrary.verifyElement(driver, phoneNoLabel, true);
		AppLibrary.verifyElement(driver, phoneNoInput, true);
		AppLibrary.verifyElement(driver, saveButtonContInfo, true);

		return new ContactInfoPage(driver);

	}
	
}
