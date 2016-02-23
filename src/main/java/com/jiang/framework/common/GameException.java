package com.jiang.framework.common;

public class GameException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int errorID;

	public int getErrorID() {
		return errorID;
	}

	public void setErrorID(int errorID) {
		this.errorID = errorID;
	}
}
