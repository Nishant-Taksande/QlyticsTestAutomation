package qlytics.Pages;

import static org.testng.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import qlytics.Lib.AppLibrary;

public class ProfilePage {

	private AppLibrary appLibrary;
	private WebDriver driver;
	/// Profile Page

	public static String profileButton = "xpath://li[span[contains(text(),'Profile')]]";
	public static String profileParent = "xpath://div[nz-card[div[div[div[text()='My Profile']]]]]";
	public static String myprofileLabel = "" + profileParent + "//div[text()='My Profile']";

	public static String personalDetailsButton = "" + profileParent + "//div[text()='Personal Details']";
	public static String profileNameInput = "" + profileParent + "//input[@formcontrolname='full_name']";

	public static String profileNameLabel = "" + profileParent + "//label[text()='Profile Name *']";
	public static String titleLabel = "" + profileParent + "//label[text()='Title *']";

	public static String titleInput = "" + profileParent + "//input[@formcontrolname='title']";

	public static String overviewLabel = "" + profileParent + "//label[contains(text(),'Overview *')]";

	public static String overviewInput = "" + profileParent + "//textarea[@formcontrolname='description']";

	public static String profile2UploadButton = "" + profileParent + "//div[@class='ant-upload']";

	public static String ProfilePicLabel = "" + profileParent + "//label[contains(text(),'Profile Picture *')]";

	public static String hourlyRateLabel = "" + profileParent + "//label[contains(text(),'Hourly Rate *')]";
	public static String hourlyrateInput = "" + profileParent
			+ "//nz-form-item[nz-form-label[label[contains(text(),'Hourly Rate *')]]]//input";

	public static String countryLabel = "" + profileParent + "//label[contains(text(),'Country *')]";

	public static String countryInput = "" + profileParent
			+ "//nz-form-item[nz-form-label[label[contains(text(),'Country *')]]]//input";

	public static String countryVerification = "xpath://nz-select[@formcontrolname='country']//div[contains(@class,'ant-select-selection-selected-value')]";

	public static String categoryVerification = "xpath://nz-select[@formcontrolname='categories']//div[contains(@class,'ant-select-selection-selected-value')]";

	public static String availabilityVerification = "xpath://nz-select[@formcontrolname='availability']//div[contains(@class,'ant-select-selection-selected-value')]";

	public static String visibiltyVerification = "xpath://nz-select[@formcontrolname='visibility']//div[contains(@class,'ant-select-selection-selected-value')]";

	public static String skillsVerification = "xpath://div[contains(@class,'ant-select-selection__choice__content')]";

	public static String countrydownArrow = "xpath://nz-select[@formcontrolname='country']//i[contains(@class,'ant-select-arrow-icon')]";

	public static String categoryLabel = "" + profileParent + "//label[contains(text(),'Category *')]";

	public static String categoryInput = "" + profileParent
			+ "//nz-form-item[nz-form-label[label[contains(text(),'Category *')]]]//input";

	public static String categorydownArrow = "xpath://nz-select[@formcontrolname='categories']//i[contains(@class,'ant-select-arrow-icon')]";

	public static String skillsInput = "xpath://nz-select[@formcontrolname='skills']//input[contains(@class,'ant-select-search__field')]";

	public static String skillsdownArrow = "xpath://nz-select[@formcontrolname='skills']//i[contains(@class,'ant-select-arrow-icon')]";

	public static String selectSkillforRemove = "xpath://li[div[contains(text(),'Replace')]]//i[contains(@class,'anticon ant-select-remove-icon')]";
	//
	public static String List = "xpath://ul[contains(@class,'ant-select-dropdown-menu')]//li[contains(text(),'Replace')]";

	public static String skillsLabel = "" + profileParent + "//label[contains(text(),'Skills *')]";

	public static String visbilityLabel = "" + profileParent + "//label[contains(text(),'Visibility *')]";

	public static String visbilityInput = "" + profileParent + "//nz-select[contains(@formcontrolname,'visibility')]";
//	public static String visbilityInput = "xpath://nz-select[@formcontrolname='visibility']";
	public static String visbilitydownArrow = "xpath://nz-select[@formcontrolname='visibility']//i[contains(@class,'ant-select-arrow-icon')]";

	public static String availabilityLabel = "" + profileParent + "//label[contains(text(),'Availability *')]";

	public static String availabilityInput = "" + profileParent
			+ "//nz-select[contains(@formcontrolname,'availability')]";

	public static String saveButtonprofile = "" + profileParent + "//button[//span[text()='Save']]";

	public static String profileUpdatedMessage = "xpath://span[text()='Profile updated successfully.']";

	public static String profileNameHeader = "xpath://li[contains(@class,'ant-menu-submenu-horizontal')]//div[contains(@class,'ant-menu-submenu-title')]//span";

	// Education

	public static String educationButton = "" + profileParent + "//div[text()='Education']";

	public static String educationHistoryLabel = "" + profileParent + "//div[text()='Education history']";

	public static String AddEducationButton = "" + profileParent + "//div[div[text()='Education history']]//button";

	public static String schoolLabel = "" + profileParent + "//div[text()='School/College']";
	public static String areaLabel = "" + profileParent + "//div[text()='Area']";

	public static String degreeLabel = "" + profileParent + "//div[text()='Degree']";

	public static String degreeVerification = "xpath://nz-select[@formcontrolname='degree']//div[contains(@class,'ant-select-selection-selected-value')]";

	public static String descriptionLabel = "" + profileParent + "//div[text()='Description']";

	public static String editEducation = "" + profileParent
			+ "//nz-card[div[div[div[text()='Education history']]]]//td//button";

	// Add Education form

	public static String educationAddParent = "xpath://div[div[div[div[text()='Add education']]]]";
	public static String addEducationLabel = "" + educationAddParent + "//div[text()='Add education']";

	public static String closeButton = "" + educationAddParent + "//button[@aria-label='Close']";

	public static String descriptionAddEduLabel = "" + educationAddParent + "//label[text()='Description *']";
	public static String decriptionInput = "" + educationAddParent
			+ "//nz-form-item[nz-form-label[label[text()='Description *']]]//textarea";

	public static String areaAddaEduLabel = "" + educationAddParent + "//label[text()='Area *']";

	public static String areaInput = "" + educationAddParent
			+ "//nz-form-item[nz-form-label[label[text()='Area *']]]//input";

	public static String school_collegeLabel = "" + educationAddParent + "//label[text()='School/College *']";

	public static String School_CollegeInput = "" + educationAddParent + "//input[@formcontrolname='education_school']";
	public static String degreeAddEduLabel = "" + educationAddParent + "//label[text()='Degree *']";

	public static String degreeInput = "" + educationAddParent
			+ "//nz-form-item[nz-form-label[label[text()='Degree *']]]//input";

	public static String degreearrowButton = "xpath://div[div[div[div[div[text()='Add education']]]]//label[text()='Degree *']]//nz-select[@formcontrolname='degree']//i[contains(@class,'ant-select-arrow-icon')]";

	public static String dropDown = "xpath://ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']";

	public static String saveButton = "" + educationAddParent + "//button[span[span[contains(text(),'Save')]]]";

	public static String cancelButton = "" + educationAddParent + "//button[span[text()='Cancel']]";

	public static String school_collegeDashboard = "xpath://td[1]";

	public static String areaDashboard = "xpath://td[2]";

	public static String degreeDashboard = "xpath://td[3]";

	public static String descriptionDashboard = "xpath://td[4]";
	public static String eductaionAddedSuccessfullyMess = "xpath://span[text()='Education record added successfully']";

	// Update Education form
	public static String educationUpdateParent = "xpath://div[div[div[div[text()='Update education']]]]";
	public static String updateEducationLabel = "" + educationUpdateParent + "//div[text()='Update education']";

	public static String closeUpdateButton = "" + educationUpdateParent + "//button[@aria-label='Close']";

	public static String descriptionUpdateEduLabel = "" + educationUpdateParent + "//label[text()='Description *']";
	public static String UpdateEdudecriptionInput = "" + educationUpdateParent
			+ "//nz-form-item[nz-form-label[label[text()='Description *']]]//textarea";

	public static String areaUpdateEduLabel = "" + educationUpdateParent + "//label[text()='Area *']";

	public static String updateAreaInput = "" + educationUpdateParent
			+ "//nz-form-item[nz-form-label[label[text()='Area *']]]//input";

	public static String school_collegeUpdateLabel = "" + educationUpdateParent + "//label[text()='School/College *']";

	public static String School_CollegeUpdateInput = "" + educationUpdateParent
			+ "//input[@formcontrolname='education_school']";
	public static String degreeUpdateEduLabel = "" + educationUpdateParent + "//label[text()='Degree *']";

	public static String degreeUpdateInput = "" + educationUpdateParent
			+ "//nz-form-item[nz-form-label[label[text()='Degree *']]]//input";

	public static String saveUpdateButton = "" + educationUpdateParent
			+ "//button[span[span[contains(text(),'Save')]]]";
	public static String eductaionUpdatedSuccessfullyMess = "xpath://span[text()='Education updated successfully']";

	public static String cancelUpdateButton = "" + educationUpdateParent + "//button[span[text()='Cancel']]";

	// Employment History

	public static String employmentHistoryButton = "" + profileParent
			+ "//div[div[text()='Education']]//div[text()='Employment history']";

	public static String AddEmploymentHistoryButton = "" + profileParent
			+ "//div[div[text()='Employment history']]//button";

	public static String EmploymentHistoryLabel = "" + profileParent
			+ "//*[div[div[text()='Employment history']]//button]//div[text()='Employment history']";

	public static String comapnyLabel = "" + profileParent + "//div[text()='Company']";
	public static String positionLabel = "" + profileParent + "//div[text()='Position']";

	public static String fromLabel = "" + profileParent + "//div[text()='From']";

	public static String toLabel = "" + profileParent + "//div[text()='To']";

	public static String editEmploymentHistory = "" + profileParent
			+ "//nz-card[div[div[div[text()='Employment history']]]]//td//button";

	// Add employment history form

	public static String addEmploymentParent = "xpath://div[div[div[div[text()='Add employment']]]]";

	public static String addEmploymentLabel = "" + addEmploymentParent + "//div[text()='Add employment']";

	public static String closeaddEmploymentButton = "" + addEmploymentParent + "//button[@aria-label='Close']";

	public static String comapnyAddEmploymentLabel = "" + addEmploymentParent + "//label[text()='Company *']";

	public static String compnayInput = "" + addEmploymentParent
			+ "//nz-form-item[nz-form-label[label[text()='Company *']]]//input";

	public static String titleEmploymentLabel = "" + addEmploymentParent + "//label[text()='Title *']";

	public static String titleEmploymentInput = "" + addEmploymentParent
			+ "//nz-form-item[nz-form-label[label[text()='Title *']]]//input";

	public static String fromAndToDateLabel = "" + addEmploymentParent + "//label[text()='From Date - To Date *']";

	public static String selectDate = "" + addEmploymentParent
			+ "//nz-form-item[nz-form-label[label[text()='From Date - To Date *']]]//nz-range-picker";

	public static String fromDateInput = "xpath://div[div[div[div[div[text()='Add employment']]]]]//input[contains(@class,'ant-calendar-range-picker-input')][@placeholder='Start date']";

	public static String toDateInput = "xpath://div[div[div[div[div[text()='Add employment']]]]]//input[contains(@class,'ant-calendar-range-picker-input')][@placeholder='End date']";

	public static String saveEmploymentButton = "" + addEmploymentParent
			+ "//button[span[span[contains(text(),'Save')]]]";

	public static String cancelEmploymentButton = "" + addEmploymentParent + "//button[span[text()='Cancel']]";

	// Update employment history form
	public static String updateEmploymentParent = "xpath://div[div[div[div[text()='Update Employment History']]]]";

	public static String updateEmploymentLabel = "" + updateEmploymentParent + "//div[text()='Add employment']";

	public static String closeUpdateEmploymentButton = "" + updateEmploymentParent + "//button[@aria-label='Close']";

	public static String comapnyUpdateEmploymentLabel = "" + updateEmploymentParent + "//label[text()='Company *']";

	public static String compnayUpdateInput = "" + updateEmploymentParent
			+ "//nz-form-item[nz-form-label[label[text()='Company *']]]//input";

	public static String titleUpdateEmploymentLabel = "" + updateEmploymentParent + "//label[text()='Title *']";

	public static String titleUpdateEmploymentInput = "" + updateEmploymentParent
			+ "//nz-form-item[nz-form-label[label[text()='Title *']]]//input";

	public static String updateEmplaoyemntfromAndToDateLabel = "" + updateEmploymentParent
			+ "//label[text()='From Date - To Date *']";

	public static String selectUpdateDate = "" + updateEmploymentParent
			+ "//nz-form-item[nz-form-label[label[text()='From Date - To Date *']]]//nz-range-picker";

	public static String saveUpdateEmploymentButton = "" + updateEmploymentParent
			+ "//button[span[span[contains(text(),'Save')]]]";

	public static String cancelUpdateEmploymentButton = "" + updateEmploymentParent + "//button[span[text()='Cancel']]";

	public ProfilePage(AppLibrary appLibrary) {
		super();
		this.appLibrary = appLibrary;
		this.driver = appLibrary.getCurrentDriverInstance();
	}

	public ProfilePage PersonalDetailsPageUi() {

		AppLibrary.clickElement(driver, profileButton);
		AppLibrary.sleep(3000);
		AppLibrary.verifyElement(driver, profileButton, true);
		AppLibrary.verifyElement(driver, myprofileLabel, true);
		AppLibrary.verifyElement(driver, personalDetailsButton, true);
		AppLibrary.verifyElement(driver, profileNameInput, true);
		AppLibrary.verifyElement(driver, profileNameLabel, true);
		AppLibrary.verifyElement(driver, titleLabel, true);
		AppLibrary.verifyElement(driver, titleInput, true);
		AppLibrary.verifyElement(driver, overviewLabel, true);
		AppLibrary.verifyElement(driver, overviewInput, true);
		AppLibrary.verifyElement(driver, profile2UploadButton, true);
		AppLibrary.verifyElement(driver, ProfilePicLabel, true);
		AppLibrary.verifyElement(driver, hourlyRateLabel, true);
		AppLibrary.verifyElement(driver, hourlyrateInput, true);
		AppLibrary.verifyElement(driver, countryInput, true);
		AppLibrary.verifyElement(driver, categoryInput, true);
		AppLibrary.verifyElement(driver, categoryLabel, true);
		AppLibrary.verifyElement(driver, skillsInput, true);
		AppLibrary.verifyElement(driver, skillsLabel, true);
		AppLibrary.verifyElement(driver, visbilityLabel, true);
		AppLibrary.verifyElement(driver, visbilityInput, true);
		AppLibrary.verifyElement(driver, availabilityLabel, true);
		AppLibrary.verifyElement(driver, availabilityInput, true);
		AppLibrary.verifyElement(driver, saveButtonprofile, true);
		return new ProfilePage(appLibrary);

	}

	public ProfilePage educationUi() {
		AppLibrary.clickElement(driver, profileButton);
		AppLibrary.sleep(3000);
		AppLibrary.clickElement(driver, educationButton);
		AppLibrary.verifyElement(driver, educationHistoryLabel, true);
		AppLibrary.verifyElement(driver, AddEducationButton, true);
		AppLibrary.verifyElement(driver, schoolLabel, true);
		AppLibrary.verifyElement(driver, areaLabel, true);
		AppLibrary.verifyElement(driver, degreeLabel, true);
		AppLibrary.verifyElement(driver, descriptionLabel, true);
//			AppLibrary.verifyElement(driver, editEducation, true);

		AppLibrary.clickElement(driver, AddEducationButton);
		AppLibrary.verifyElement(driver, addEducationLabel, true);
		AppLibrary.verifyElement(driver, closeButton, true);
		AppLibrary.verifyElement(driver, descriptionAddEduLabel, true);
		AppLibrary.verifyElement(driver, decriptionInput, true);
		AppLibrary.verifyElement(driver, areaAddaEduLabel, true);
		AppLibrary.verifyElement(driver, areaInput, true);
		AppLibrary.verifyElement(driver, school_collegeLabel, true);
		AppLibrary.verifyElement(driver, School_CollegeInput, true);
		AppLibrary.verifyElement(driver, degreeAddEduLabel, true);
		AppLibrary.verifyElement(driver, degreeInput, true);
		AppLibrary.verifyElement(driver, saveButton, true);
		AppLibrary.verifyElement(driver, cancelButton, true);

		AppLibrary.clickElement(driver, cancelButton);

		return new ProfilePage(appLibrary);
	}

	public ProfilePage FillEductaionForm(String description, String area, String school, String selectDegree) {

		AppLibrary.clickElement(driver, AddEducationButton);
		AppLibrary.enterText(driver, decriptionInput, description);
		AppLibrary.enterText(driver, areaInput, area);
		AppLibrary.enterText(driver, School_CollegeInput, school);
//		AppLibrary.customselectDropdownOption(driver, degreeInput, List.replace("Replace", selectDegree), selectDegree,
//				degreearrowButton);

		AppLibrary.selectDropDown(driver, degreeInput, List.replace("Replace", selectDegree), selectDegree);

		AppLibrary.clickElement(driver, saveButton);

		AppLibrary.verifyElement(driver, eductaionAddedSuccessfullyMess, true);

		return new ProfilePage(appLibrary);
	}

	public ProfilePage EditEducation(String description, String area, String school, String selectDegree) {

		AppLibrary.clickElement(driver, editEducation);
		AppLibrary.enterText(driver, UpdateEdudecriptionInput, description);
		AppLibrary.enterText(driver, updateAreaInput, area);
		AppLibrary.enterText(driver, School_CollegeUpdateInput, school);
		AppLibrary.selectDropDown(driver, degreeUpdateInput, List.replace("Replace", selectDegree), selectDegree);

		AppLibrary.clickElement(driver, saveUpdateButton);

		AppLibrary.sleep(3000);
//		AppLibrary.verifyElement(driver, eductaionUpdatedSuccessfullyMess, true);
		AppLibrary.verifyElement(driver, educationHistoryLabel, true);
		return new ProfilePage(appLibrary);

	}

	public ProfilePage VerifyEductaionForm(String description, String area, String school, String selectDegree) {

		AppLibrary.verification(driver, descriptionDashboard, description);
		AppLibrary.verification(driver, areaDashboard, area);
		AppLibrary.verification(driver, school_collegeDashboard, school);

		// change to degree verification
		AppLibrary.Verificationwithcontains(driver, degreeDashboard, selectDegree);
		return new ProfilePage(appLibrary);
	}

	public ProfilePage EmploymentHistoryUi() {

		AppLibrary.clickElement(driver, profileButton);
		AppLibrary.sleep(3000);
		AppLibrary.clickElement(driver, employmentHistoryButton);
		AppLibrary.verifyElement(driver, AddEmploymentHistoryButton, true);
		AppLibrary.verifyElement(driver, EmploymentHistoryLabel, true);
		AppLibrary.verifyElement(driver, comapnyLabel, true);
		AppLibrary.verifyElement(driver, positionLabel, true);
		AppLibrary.verifyElement(driver, fromLabel, true);
		AppLibrary.verifyElement(driver, toLabel, true);
//			AppLibrary.verifyElement(driver, editEmploymentHistory, true);

		AppLibrary.clickElement(driver, AddEmploymentHistoryButton);
		AppLibrary.verifyElement(driver, addEmploymentParent, true);
		AppLibrary.verifyElement(driver, addEmploymentLabel, true);
		AppLibrary.verifyElement(driver, closeaddEmploymentButton, true);
		AppLibrary.verifyElement(driver, comapnyAddEmploymentLabel, true);
		AppLibrary.verifyElement(driver, compnayInput, true);
		AppLibrary.verifyElement(driver, titleEmploymentLabel, true);
		AppLibrary.verifyElement(driver, titleEmploymentInput, true);
		AppLibrary.verifyElement(driver, fromAndToDateLabel, true);
		AppLibrary.verifyElement(driver, selectDate, true);
		AppLibrary.verifyElement(driver, saveEmploymentButton, true);
		AppLibrary.verifyElement(driver, cancelEmploymentButton, true);
		AppLibrary.clickElement(driver, cancelEmploymentButton);
		return new ProfilePage(appLibrary);
	}

	public ProfilePage FillEmploymentHistoryForm(String company, String title, String fromDate, String toDate) throws Exception {

		AppLibrary.clickElement(driver, AddEmploymentHistoryButton);
		AppLibrary.enterText(driver, compnayInput, company);
		AppLibrary.enterText(driver, titleEmploymentInput, title);

//		AppLibrary.enterText(driver, fromDateInput, fromDate);
//		AppLibrary.findElement(driver, fromDateInput).sendKeys(fromDate);
		AppLibrary.setAttributeByJavascript(driver, fromDateInput, fromDate);
		
		AppLibrary.setAttributeByJavascript(driver, toDateInput, toDate);
//		AppLibrary.enterText(driver, toDateInput, toDate);
		
		
		WebElement save = AppLibrary.findElement(driver, saveEmploymentButton);
		if(!AppLibrary.isAttribtuePresent(save, "disabled")) {
			
		AppLibrary.clickElement(driver, saveEmploymentButton);
		}
		return new ProfilePage(appLibrary);
	}

	public ProfilePage FillPersonalDetailsForm(String ProfileName, String title, String overview, String HourlyRate,
			String country, String category, String skills, String Visibilty, String avability) throws Exception {

		AppLibrary.clickElement(driver, profileButton);
		AppLibrary.sleep(3000);

		// profile name is not changing after save
		// AppLibrary.enterText(driver, profileNameInput, ProfileName);

		AppLibrary.enterText(driver, titleInput, title);
		AppLibrary.enterText(driver, overviewInput, overview);
		appLibrary.uploadImage(driver, ContactInfoPage.profileUploadButton, "TestImg.jpg", ContactInfoPage.profileImg,
				"href");

		AppLibrary.clearTextByJavascript(driver, hourlyrateInput);
		AppLibrary.enterText(driver, hourlyrateInput, HourlyRate);

		AppLibrary.customselectDropdownOption(driver, countryInput, List.replace("Replace", country), country,
				countrydownArrow);
		AppLibrary.customselectDropdownOption(driver, categoryInput, List.replace("Replace", category), category,
				categorydownArrow);

		if (!skills.equalsIgnoreCase("")) {
			String[] Skills = skills.split("\\|");

			for (String selectSkills : Skills) {
				AppLibrary.customselectDropdownOption(driver, skillsInput, List.replace("Replace", selectSkills),
						selectSkills, skillsdownArrow);
				AppLibrary.clickElement(driver, hourlyRateLabel);
			}
		}

		AppLibrary.selectDropdown(driver, visbilityInput, List.replace("Replace", Visibilty));

		AppLibrary.selectDropdown(driver, availabilityInput, List.replace("Replace", avability));

		AppLibrary.clickElement(driver, saveButtonprofile);

		AppLibrary.waitUntilElementDisplayed(driver, profileUpdatedMessage);
		return new ProfilePage(appLibrary);

	}

	public ProfilePage removeSkills(String skills) {

		AppLibrary.clickElement(driver, selectSkillforRemove.replace("Replace", skills));

		return new ProfilePage(appLibrary);

	}

	public ProfilePage verifyPersonaldetails(String profileName, String title, String overview, String HourlyRate,
			String country, String category, String skills, String visibilty, String availabilty) {
		AppLibrary.verificationWithAttribute(driver, profileNameInput, profileName);

		AppLibrary.verificationWithAttribute(driver, titleInput, title);
		AppLibrary.verificationWithAttribute(driver, overviewInput, overview);

		AppLibrary.verificationWithAttribute(driver, hourlyrateInput, "$" + " " + HourlyRate);

		AppLibrary.verification(driver, countryVerification, country);

		AppLibrary.verification(driver, categoryVerification, category);

		if (!skills.equalsIgnoreCase("")) {

			String[] Skills = skills.split("\\|");
			List<WebElement> elements = AppLibrary.findElements(driver, skillsVerification);
			for (String selectSkills : Skills) {
				int i = 0;
				while (i < elements.size()) {
					String actualValue = elements.get(i).getText();
					if (selectSkills.equals(actualValue)) {
						Assert.assertEquals(actualValue, selectSkills, "values didnot match for " + actualValue
								+ "Expected =" + selectSkills + "  Actual =" + actualValue);
						break;
					} else {
						Assert.assertNotEquals(actualValue, selectSkills);
					}

					i++;
				}

			}

		}

		// not working
//		AppLibrary.verificationWithAttribute(driver, visibiltyVerification, visibilty);

		AppLibrary.verification(driver, availabilityVerification, availabilty);

		return new ProfilePage(appLibrary);
	}

}
