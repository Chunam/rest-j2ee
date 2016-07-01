package org.phuong.model;

public class RestResponse {

	private String[] permissions;
	private boolean success;

	public RestResponse() {
		super();
	}

	public String[] getPermissions() {
		return permissions;
	}

	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
