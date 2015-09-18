package com.indusmed.base;

public abstract class AbstractServiceRequest {
	private String requestProtocol;
	private String responseProtocol;
	
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
	
}
