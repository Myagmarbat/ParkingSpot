package edu.mum.asd.project.application.model;

public class Staff {
	private Integer staffId;
	private String staffName;
	private String staffPass;
	public boolean valid;
	
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPass() {
		return staffPass;
	}
	public void setStaffPass(String staffPass) {
		this.staffPass = staffPass;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	
}