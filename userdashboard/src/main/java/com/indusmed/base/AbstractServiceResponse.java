package com.indusmed.base;

public abstract class AbstractServiceResponse {
	private boolean successful;
	private String requestProtocol;
	private String responseProtocol;
	private String message;
	
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public String getRequestProtocol() {
		return requestProtocol;
	}
	public void setRequestProtocol(String requestProtocol) {
		this.requestProtocol = requestProtocol;
	}
	public String getResponseProtocol() {
		return responseProtocol;
	}
	public void setResponseProtocol(String responseProtocol) {
		this.responseProtocol = responseProtocol;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
