package com.example.model;

import lombok.Data;

@Data
public class Modal {
	

	public Modal() {
		super();
	}

	public Modal(int code, boolean success, String message) {
		super();
		this.code = code;
		this.success = success;
		this.message = message;
	}

	private int code;
	
	private boolean success;
	
	private String message;
}
