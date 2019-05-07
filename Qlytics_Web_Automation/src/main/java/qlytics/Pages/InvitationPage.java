package qlytics.Pages;

import java.awt.peer.ListPeer;

import org.openqa.selenium.WebDriver;

import qlytics.Lib.AppLibrary;

public class InvitationPage {

	private AppLibrary appLibrary;
	private WebDriver driver;

	public static String invitationButton = "xpath://li[contains(text(),'Invitations')]";

	public static String invitationLabel = "xpath://div[contains(@class,'ant-card-head-title ')][contains(text(),'Invitations')]";

	public static String inviteMemberButton = "xpath://button[span[contains(text(),'Invite Member')]]";

	public static String pendingInvitationButton = "xpath://button[span[contains(text(),'Pending invitations')]]";

	public static String firstNameLabel = "xpath://div[text()='First Name']";

	public static String lastNameLabel = "xpath://div[text()='Last name']";

	public static String emailLabel = "xpath://nz-card[div[div[div[text()='Invitations']]]]//div[text()='Email']";

	public static String roleLabel = "xpath://div[text()='Role']";

	public static String pageNaviLeft = "xpath://nz-card[div[div[div[text()='Invitations']]]]//i[contains(@class,'anticon-left')]";

	public static String pageNaviRight = "xpath://nz-card[div[div[div[text()='Invitations']]]]//i[contains(@class,'anticon-right')]";

	public static String pageCounts = "xpath://li[contains(@class,'ant-pagination-item')]";

	public static String parent = "xpath://nz-card[div[div[div[text()='Invitations']]]]";
	
	public static String pendingInvitationParent = "xpath://div[@class='ant-modal-content']";
	
	

	// Click on invite member

	public static String sendInviteLabel = "xpath://div[text()='Send Invite']";

	public static String closeButton = "xpath://button[contains(@class,'ant-drawer-close')]";

	public static String emailsendInviteLabel = "xpath://label[text()='Email *']";

	public static String emailInput = "xpath://input[@formcontrolname='email']";

	public static String accessLabel = "xpath://label[contains(text(),'Access level *')]";

	public static String accessLabelInput = "xpath://div[@class='ant-select-selection__rendered']";

	public static String accessList = "xpath://ul[contains(@class,'ant-select-dropdown-menu')]//li[contains(text(),'Replace')]";

	public static String sendInviteButton = "xpath://button[span[span[text()='Send Invite']]]";

	// pending Invitation

	public static String closePendingButton = "xpath://button[contains(@class,'ant-modal-close')]";

	public static String allInvitedMembersLabel = "xpath://div[text()='All Invited members']";

	public static String emailPendingLabel = "xpath://thead[tr[th[div[text()='Access Level']]]]//div[text()='Email']";

	public static String accessPendingLabel = "xpath://div[text()='Access Level']";

	public static String acceptedLabel = "xpath://div[text()='Accepted']";

	public static String invitedOnLabel = "xpath://div[text()='Invited on']";

	public static String okButton = "xpath://button[span[contains(text(),'OK')]]";
	
	
	
	
	//After invitation page
	public static String qlyticsInvitationLogo = "xpath://img[contains(@class,'login-logo')]";

	public static String confirmInvitationLabel = "xpath://small[text()='Confirm your invitation ?']";

	public static String acceptButton = "xpath://button[span[contains(text(),'ACCEPT')]]";

	public static String declineButton = "xpath://button[span[contains(text(),'DECLINE')]]";
	
	

	public InvitationPage(AppLibrary appLibrary) {
		super();
		this.appLibrary = appLibrary;
		this.driver = appLibrary.getCurrentDriverInstance();
	}

	public InvitationPage inviteMemberPageUi() {

		AppLibrary.sleep(3000);
		AppLibrary.verifyElement(driver, invitationLabel, true);
		AppLibrary.verifyElement(driver, inviteMemberButton, true);
		AppLibrary.verifyElement(driver, pendingInvitationButton, true);
		AppLibrary.verifyElement(driver, firstNameLabel, true);
		AppLibrary.verifyElement(driver, lastNameLabel, true);
		AppLibrary.verifyElement(driver, emailLabel, true);
		AppLibrary.verifyElement(driver, roleLabel, true);
		AppLibrary.verifyElement(driver, pageNaviLeft, true);
		AppLibrary.verifyElement(driver, pageNaviRight, true);
		AppLibrary.verifyElement(driver, pageCounts, true);

		AppLibrary.clickElement(driver, inviteMemberButton);

		AppLibrary.verifyElement(driver, sendInviteLabel, true);
		AppLibrary.verifyElement(driver, closeButton, true);
		AppLibrary.verifyElement(driver, emailsendInviteLabel, true);
		AppLibrary.verifyElement(driver, emailInput, true);
		AppLibrary.verifyElement(driver, accessLabel, true);
		AppLibrary.verifyElement(driver, accessLabelInput, true);
		AppLibrary.verifyElement(driver, sendInviteButton, true);
		AppLibrary.clickElement(driver, closeButton);

		AppLibrary.clickElement(driver, pendingInvitationButton);

		AppLibrary.verifyElement(driver, closePendingButton, true);
		AppLibrary.verifyElement(driver, allInvitedMembersLabel, true);
		AppLibrary.verifyElement(driver, emailPendingLabel, true);
		AppLibrary.verifyElement(driver, accessPendingLabel, true);

		AppLibrary.verifyElement(driver, acceptedLabel, true);
		AppLibrary.verifyElement(driver, invitedOnLabel, true);
		AppLibrary.verifyElement(driver, okButton, true);
		return new InvitationPage(appLibrary);

	}

	public InvitationPage fillInviteMemberForm(String email, String accessLevel) {

		AppLibrary.enterText(driver, emailInput, email);
		AppLibrary.selectDropdown(driver, accessLabelInput, accessList.replace("Replace", accessLevel));
		AppLibrary.clickElement(driver, sendInviteButton);

		return new InvitationPage(appLibrary);
	}

	public InvitationPage verifyInvitationMemberData(String uniqueValue, String firstNameVerification,
			String lastNameVerification, String emailVerification, String roleVerification) {
		appLibrary.verifyListGridRow(parent, uniqueValue, firstNameVerification);
		appLibrary.verifyListGridRow(parent, uniqueValue, lastNameVerification);
		appLibrary.verifyListGridRow(parent, uniqueValue, emailVerification);
		appLibrary.verifyListGridRow(parent, uniqueValue, roleVerification);
		return new InvitationPage(appLibrary);
	}

	public InvitationPage verifyPendingInvitationMemberData(String uniqueValue, String email,
			String accessLevel, String Accepted, String invitedOn) {
		appLibrary.verifyListGridRow(pendingInvitationParent, uniqueValue, email);
		appLibrary.verifyListGridRow(pendingInvitationParent, uniqueValue, accessLevel);
		appLibrary.verifyListGridRow(pendingInvitationParent, uniqueValue, Accepted);
		appLibrary.verifyListGridRow(pendingInvitationParent, uniqueValue, invitedOn);
		return new InvitationPage(appLibrary);
	}

	
	public InvitationPage verifyAcceptInvitationPage() {
		
		AppLibrary.sleep(1000);
		AppLibrary.verifyElement(driver, qlyticsInvitationLogo,true);
		AppLibrary.verifyElement(driver, confirmInvitationLabel,true);
		AppLibrary.verifyElement(driver, acceptButton,true);
		AppLibrary.verifyElement(driver, declineButton,true);
		return new InvitationPage(appLibrary);
	}
	
	
	
	public InvitationPage verifyInvitationSignUpPageUi() {

		AppLibrary.sleep(1000);
		AppLibrary.verifyElement(driver, SignUpPage.qlyticsSignUpLogo,true);
		AppLibrary.verifyElement(driver, SignUpPage.createYourAccLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.firstNameLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.firtsNameInput,true);
		AppLibrary.verifyElement(driver, SignUpPage.lastNameLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.lastNameInput,true);
	
		AppLibrary.verifyAbsent(driver, SignUpPage.businessEmailLabel);
		AppLibrary.verifyAbsent(driver, SignUpPage.businessEmailInput);
		
		AppLibrary.verifyElement(driver, SignUpPage.passLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.passwordInput,true);
		AppLibrary.verifyElement(driver, SignUpPage.cnfPassLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.cnfPasswordInput,true);
		
		AppLibrary.verifyElement(driver, SignUpPage.phoneNumberLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.phoneNumberInput,true);
		
		AppLibrary.verifyAbsent(driver, SignUpPage.companyNameLabel);
		AppLibrary.verifyAbsent(driver, SignUpPage.companyNameInput);
		
		AppLibrary.verifyElement(driver, SignUpPage.jobTitleLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.jobTitleInput,true);
		AppLibrary.verifyElement(driver, SignUpPage.registerButton,true);
		AppLibrary.verifyElement(driver, SignUpPage.alreadyHaveAccLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.loginLink,true);
		AppLibrary.verifyElement(driver, SignUpPage.welcomeLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.platformLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.cognitiveLabel,true);
		AppLibrary.verifyElement(driver, SignUpPage.workDoneLabel,true);
		AppLibrary.sleep(1000);
		return new InvitationPage(appLibrary);

	}
	
	
}
