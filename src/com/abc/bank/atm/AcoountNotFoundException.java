package com.abc.bank.atm;

public class AcoountNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AcoountNotFoundException (String str)  
    { 
        super(str);  
    }  
}
