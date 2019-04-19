package qlytics.Pages;

import org.openqa.selenium.WebDriver;

import qlytics.Lib.AppLibrary;

public class ProfilePage {
	
	WebDriver driver;
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

		public static String categoryInput = "" + profileParent
				+ "//nz-form-item[nz-form-label[label[contains(text(),'Category *')]]]//input";

		public static String categoryLabel = "" + profileParent + "//label[contains(text(),'Category *')]";

		public static String skillsInput = "" + profileParent
				+ "//nz-form-item[nz-form-label[label[contains(text(),'Skills *')]]]//nz-form-control";

		public static String skillsLabel = "" + profileParent + "//label[contains(text(),'Skills *')]";

		public static String visbilityLabel = "" + profileParent + "//label[contains(text(),'Visibility *')]";

		public static String visbilityInput = "" + profileParent + "//nz-select[contains(@formcontrolname,'visibility')]";

		public static String availabilityLabel = "" + profileParent + "//label[contains(text(),'Availability *')]";

		public static String availabilityInput = "" + profileParent
				+ "//nz-select[contains(@formcontrolname,'availability')]";

		public static String saveButtonprofile = "" + profileParent + "//button[//span[text()='Save']]";

		// Education

		public static String educationButton = "" + profileParent + "//div[text()='Education']";

		public static String educationHistoryLabel = "" + profileParent + "//div[text()='Education history']";

		public static String AddEducationButton = "" + profileParent + "//div[div[text()='Education history']]//button";

		public static String schoolLabel = "" + profileParent + "//div[text()='School/College']";
		public static String areaLabel = "" + profileParent + "//div[text()='Area']";

		public static String degreeLabel = "" + profileParent + "//div[text()='Degree']";

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

		public static String saveButton = "" + educationAddParent + "//button[span[span[contains(text(),'Save')]]]";

		public static String cancelButton = "" + educationAddParent + "//button[span[text()='Cancel']]";

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

		public static String School_CollegeUpdateLabel = "" + educationUpdateParent
				+ "//input[@formcontrolname='education_school']";
		public static String degreeUpdateEduLabel = "" + educationUpdateParent + "//label[text()='Degree *']";

		public static String degreeUpdateInput = "" + educationUpdateParent
				+ "//nz-form-item[nz-form-label[label[text()='Degree *']]]//input";

		public static String saveUpdateButton = "" + educationUpdateParent
				+ "//button[span[span[contains(text(),'Save')]]]";

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
	
		public ProfilePage(WebDriver driver) {
			super();
			this.driver = driver;
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
			return new ProfilePage(driver);

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

			return new ProfilePage(driver);
		}	
		
		

		public void FillEductaionForm(String description, String area, String school, String selectDegree) {

			AppLibrary.clickElement(driver, AddEducationButton);
			AppLibrary.enterText(driver, decriptionInput, description);
			AppLibrary.enterText(driver, areaInput, area);
			AppLibrary.enterText(driver, School_CollegeInput, school);
			AppLibrary.selectDropDown(driver,degreeInput,"xpath://ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']", selectDegree);
			AppLibrary.clickElement(driver, saveButton);
//			AppLibrary.clickElement(driver, ProfilePage.profileButton);
//			AppLibrary.sleep(5000);
//			AppLibrary.clickElement(driver, ProfilePage.educationButton);
//			
//			new ProfilePage(driver).FillEductaionForm("electrical", "bhopal", "nagaji", "Associate of Arts and Sciences (A.A.S.)");
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
			return new ProfilePage(driver);
		}
	
		
		public void FillEmploymentHistoryForm(String description, String area, String school, String selectDegree) {

			AppLibrary.clickElement(driver, AddEmploymentHistoryButton);
			AppLibrary.enterText(driver, compnayInput, description);
			AppLibrary.enterText(driver, titleEmploymentInput, area);
			
			AppLibrary.enterText(driver, selectDate, school);
			
			AppLibrary.selectDropDown(driver,degreeInput,"xpath://ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']", selectDegree);
			AppLibrary.clickElement(driver, saveButton);
		
		}
		
		
}
