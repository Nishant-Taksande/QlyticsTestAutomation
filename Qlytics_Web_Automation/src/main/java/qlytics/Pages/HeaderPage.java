package qlytics.Pages;

import org.openqa.selenium.WebDriver;

import qlytics.Lib.AppLibrary;

public class HeaderPage {

	private AppLibrary appLibrary;
	private WebDriver driver;

	public static String qlyticsLogo = "xpath://img[@class='logo-large']";
	public static String projectButton = "xpath://li[contains(text(),'Projects')]";
	public static String talentHubButton = "xpath://li[contains(text(),'Talent Hub')]";
	public static String DataMarButton = "xpath://li[contains(text(),'Data Marketplace')]";
	public static String organisationButton = "xpath://li[contains(text(),'Organisation Settings')]";

	public static String accountSettingButton = "xpath://li[contains(text(),'Account Settings')]";
	
	// Logout
	public static String profileButton = "xpath://ul[@class='action-menu ml-10 ant-menu ant-menu-root ant-menu-dark ant-menu-horizontal ng-star-inserted']";
	public static String logoutButton = "xpath://*[contains(text(),'Logout')]";
	
	public static String ProfilePicHeader = "xpath://img[@class='ng-star-inserted']";
	
	
	

	public HeaderPage(AppLibrary appLibrary)
	{
		
		super();
		this.appLibrary=appLibrary;
		this.driver =appLibrary.getCurrentDriverInstance();
	}
	
	public HeaderPage Logout() {

		AppLibrary.sleep(1000);
		AppLibrary.mouseHover(driver, profileButton);
//		AppLibrary.clickElement(driver, profileButton);
		AppLibrary.clickElement(driver, logoutButton);
		
		return new HeaderPage(appLibrary);

	}

	public HeaderPage clickOnAccountSetting() {

		AppLibrary.sleep(1000);
		AppLibrary.mouseHover(driver, profileButton);
//		AppLibrary.clickElement(driver, profileButton);
		AppLibrary.clickElement(driver, accountSettingButton);
		AppLibrary.sleep(5000);
		return new HeaderPage(appLibrary);
	}
	
	
}
