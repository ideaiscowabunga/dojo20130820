package br.com.cafeteriaweb.exception;

import java.util.ArrayList;

public class ValidateException extends Exception {

	private static final long serialVersionUID = -169919237019352068L;
	
	private ArrayList<String> invalidationReasons;

	public ValidateException(ArrayList<String> invalidationReasons) {
		this.invalidationReasons = invalidationReasons;
	}
	
	public ArrayList<String> getInvalidationReasons() {
		return invalidationReasons;
	}
	
	@Override
	public String getMessage() {
		return invalidationReasons.toString();
	}
	
	@Override
	public String toString() {
		return invalidationReasons.toString();
	}
}
