package com.app.dto;

import javax.validation.constraints.NotBlank;

//DTO layer class to handle change password request data

public class ChangePasswordDTO {
	@NotBlank(message = "Old password can not be blank")
	private String oldPassword;
	@NotBlank(message = "New password can not be blank")
	private String newPassword;
	
	public ChangePasswordDTO() {
		// TODO Auto-generated constructor stub
	}

	public ChangePasswordDTO(String oldPassword, String newPassword) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ChangePasswordDTO [oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}
	
}
