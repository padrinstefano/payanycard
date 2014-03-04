package com.nxsystems.payanycard.manager;

import com.nxsystems.payanycard.exception.PayAnyCardException;
import com.nxsystems.payanycard.model.CreditCard;

public interface CreditCardManager {

	public void save(CreditCard creditCard) throws PayAnyCardException;
	
}
