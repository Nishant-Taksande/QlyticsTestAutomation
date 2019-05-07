package qlytics.Beans;

public class EmploymentHistoryBean {

	public String company = "";
	public String title = "";
	public String fromDate = "";
	public String toDate = "";

	public void setEmploymentBean(String companyVal, String titleVal, String fromVal, String toVal) {

		setCompany(companyVal);
		setTitle(titleVal);
		setFromDate(fromVal);
		setToDate(toVal);

	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
