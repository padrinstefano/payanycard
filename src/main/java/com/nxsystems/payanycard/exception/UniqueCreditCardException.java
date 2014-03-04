package com.nxsystems.payanycard.exception;

import com.nxsystems.payanycard.model.CreditCard;

/**
 * Credit Card exist
 * 
 * @author padrinstefano
 *
 */
public class UniqueCreditCardException extends PayAnyCardException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CreditCard creditCard;

	public UniqueCreditCardException(CreditCard creditCard) {
		super();
		this.creditCard = creditCard;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}
	
	
}
