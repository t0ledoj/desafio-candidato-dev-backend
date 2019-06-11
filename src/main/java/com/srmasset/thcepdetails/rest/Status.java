package com.srmasset.thcepdetails.rest;

public class Status {

	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		String msg = "Os serviços estão funcionando normalmente.";
		System.out.println(status);
		if(status.isEmpty() | !status.equals("UP")) {
			msg = "Os serviços estão com problema.";
			System.out.println(status.equals("UP"));
		}
		return msg;
	}
	
}
