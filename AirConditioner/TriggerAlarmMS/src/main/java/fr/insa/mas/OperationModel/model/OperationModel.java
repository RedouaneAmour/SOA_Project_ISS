package fr.insa.mas.OperationModel.model;

public class OperationModel {
	private boolean success;
	private String reason;
	
	public OperationModel(boolean success, String reason) {
		this.success = success;
		this.reason = reason;
	}
	public OperationModel(){
		
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
