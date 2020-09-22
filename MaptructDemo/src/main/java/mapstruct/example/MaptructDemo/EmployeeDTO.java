package mapstruct.example.MaptructDemo;

public class EmployeeDTO {
	 private int employeeId;
	 private String employeeName;
	 
	public EmployeeDTO() {
	}
	public EmployeeDTO(int employeeId, String employeeName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	 
}
