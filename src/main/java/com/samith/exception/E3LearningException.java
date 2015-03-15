package com.samith.exception;

/**
 * The Class E3LearningException.
 */
public class E3LearningException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The err code. */
	private String errCode;
	
	/** The exception msg. */
	private String exceptionMsg;
	 
	/**
	 * Instantiates a new e3 learning exception.
	 *
	 * @param errorCode the error code
	 * @param exceptionMsg the exception msg
	 */
	public E3LearningException(String errorCode, String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
		this.errCode = errorCode;
	}
	
	/**
	 * Gets the exception msg.
	 *
	 * @return the exception msg
	 */
	public String getExceptionMsg(){
		return this.exceptionMsg;
	}
	
	/**
	 * Sets the exception msg.
	 *
	 * @param exceptionMsg the new exception msg
	 */
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	/**
	 * Gets the err code.
	 *
	 * @return the err code
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * Sets the err code.
	 *
	 * @param errCode the new err code
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}
