package com.nxsystems.payanycard.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.nxsystems.payanycard.dao.CreditCardDao;
import com.nxsystems.payanycard.exception.PayAnyCardException;
import com.nxsystems.payanycard.exception.UniqueCreditCardException;
import com.nxsystems.payanycard.model.CreditCard;

@Service
public class CreditCardManagerImp implements CreditCardManager {

	@Autowired
	private CreditCardDao creditCardDao;
	
	@Transactional
	public void save(CreditCard creditCard) throws PayAnyCardException {
		
		//check request param
		Preconditions.checkNotNull(creditCard);
		Preconditions.checkNotNull(creditCard.getNumber());
		
		if(!this.verify(creditCard)){
			throw new IllegalArgumentException("Credit Card is not valid");
		}
		
		//verify if credit card exist or not
		boolean exist = creditCardDao.getById(creditCard.getNumber()) != null;
		
		if(exist)
			throw new UniqueCreditCardException(creditCard);
		
		//create new credit card
		creditCardDao.create(creditCard);
		
	}

	private boolean verify(CreditCard creditCard) {

		//TODO ... bla bla bla
		
		return true;
	}
	
}
