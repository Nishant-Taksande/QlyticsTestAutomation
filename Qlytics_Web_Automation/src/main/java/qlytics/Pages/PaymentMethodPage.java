package qlytics.Pages;

import org.openqa.selenium.WebDriver;

import qlytics.Lib.AppLibrary;

public class PaymentMethodPage {

	private AppLibrary appLibrary;
	private WebDriver driver;

	public static String paymentMethodButton = "xpath://li[contains(text(),'Payment Method')]";

	// PaymentMethodpage
	public static String paymentMethodLabel = "xpath://div[contains(text(),'Payment Method')]";
	public static String addBillingDetailsButton = "xpath://button[span[contains(text(),'Add Billing Method')]]";
	public static String addCardDetailsLabel = "xpath://div[contains(text(),'Add Card Details')]";
	public static String fullNameLabel = "xpath://label[text()='Full Name']";
	public static String fullNameInput = "xpath://input[@id='name']";
	public static String cardDetailsLabel = "xpath://label[text()='Card Details']";
	public static String cardNumberInput = "xpath://input[@placeholder='Card number']";
	public static String expiryDateInput = "xpath://input[@name='exp-date']";

	public static String cvcInput = "xpath://input[@name='cvc']";
	public static String zipInput = "xpath://input[@name='postal']";
	public static String savechangesButton = "xpath://button[@class='ant-btn ant-btn-primary']";
	public static String iframecardNumber = "xpath://iframe[contains(@name,'privateStripeFrame5')]";

	// dashBoard
	public static String cardnumberLabel = "xpath://div[text()='Card Number']";
	public static String cardTypeLabel = "xpath://div[text()='Card Type']";
	public static String cardHolderNameLabel = "xpath://div[text()='Card Holder Name']";
	public static String CreatedLabel = "xpath://div[text()='Created']";

	// Table data
	public static String cardNumber = "xpath://tr[@class='ant-table-row']//td[1]";
	public static String cardType = "xpath://tr[@class='ant-table-row']//td[2]";
	public static String cardHolderName = "xpath://tr[@class='ant-table-row']//td[3]";
	public static String Created = "xpath://tr[@class='ant-table-row']//td[4]";
	public static String deleteButton = "xpath://button[@class='ant-btn ant-btn-danger ant-btn-icon-only']";

	public PaymentMethodPage(AppLibrary appLibrary) {
		super();
		this.appLibrary = appLibrary;
		this.driver = appLibrary.getCurrentDriverInstance();
	}

	public PaymentMethodPage paymentMethodUi() {
		AppLibrary.verifyElement(driver, cardnumberLabel, true);
		AppLibrary.verifyElement(driver, cardTypeLabel, true);
		AppLibrary.verifyElement(driver, cardHolderNameLabel, true);
		AppLibrary.verifyElement(driver, CreatedLabel, true);
		AppLibrary.verifyElement(driver, addBillingDetailsButton, true);
		AppLibrary.clickElement(driver, addBillingDetailsButton);
		AppLibrary.sleep(3000);
		AppLibrary.verifyElement(driver, paymentMethodLabel, true);
		AppLibrary.verifyElement(driver, addCardDetailsLabel, true);
		AppLibrary.verifyElement(driver, fullNameLabel, true);
		AppLibrary.verifyElement(driver, fullNameInput, true);
		AppLibrary.verifyElement(driver, cardDetailsLabel, true);
		driver.switchTo().frame(AppLibrary.findElement(driver, iframecardNumber));
		AppLibrary.verifyElement(driver, cardNumberInput, true);
		AppLibrary.verifyElement(driver, expiryDateInput, true);
		AppLibrary.verifyElement(driver, cvcInput, true);

		AppLibrary.verifyAbsent(driver, zipInput);
		AppLibrary.enterText(driver, cardNumberInput, "4111111111111111");
		AppLibrary.verifyElement(driver, zipInput, true);
		driver.switchTo().defaultContent();
		AppLibrary.verifyElement(driver, savechangesButton, true);

		return new PaymentMethodPage(appLibrary);
	}

	public PaymentMethodPage enterCardDetails(String fullName, String cardNumber, String expiry, String cvc,
			String zip) {
		AppLibrary.enterText(driver, fullNameInput, fullName);

		driver.switchTo().frame(AppLibrary.findElement(driver, iframecardNumber));
		AppLibrary.enterText(driver, cardNumberInput, cardNumber);
		AppLibrary.enterText(driver, expiryDateInput, expiry);
		AppLibrary.enterText(driver, cvcInput, cvc);
		AppLibrary.enterText(driver, zipInput, zip);
		driver.switchTo().defaultContent();

		AppLibrary.clickElement(driver, savechangesButton);
		return new PaymentMethodPage(appLibrary);

	}

	public PaymentMethodPage verifyEnteredCardDetails(String fullName) {

		AppLibrary.verifyElement(driver, cardNumber);
		AppLibrary.verifyElement(driver, cardType);
		AppLibrary.verification(driver, cardHolderName, fullName);
		AppLibrary.verifyElement(driver, Created);

		return new PaymentMethodPage(appLibrary);

	}

	public PaymentMethodPage verifyPaymentmethodDeletion() {

		AppLibrary.clickElement(driver, paymentMethodButton);
		AppLibrary.verifyAbsent(driver, cardNumber);
		AppLibrary.verifyAbsent(driver, cardType);
		AppLibrary.verifyAbsent(driver, cardHolderName);
		AppLibrary.verifyAbsent(driver, Created);

		return new PaymentMethodPage(appLibrary);

	}

}
