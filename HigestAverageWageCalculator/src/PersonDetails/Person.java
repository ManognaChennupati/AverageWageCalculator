package PersonDetails;

public class Person {
    private String Department;
    private String LastName;
    private String FirstName; 
    private  String JobTitle;
    private double Rate;

	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public double getRate() {
		return Rate;
	}
	public void setRate(double d) {
		Rate = d;
	}
 
}
