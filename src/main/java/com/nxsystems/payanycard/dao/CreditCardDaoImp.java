package com.nxsystems.payanycard.dao;

import org.springframework.stereotype.Repository;

import com.nxsystems.payanycard.model.CreditCard;

@Repository
public class CreditCardDaoImp extends AJpaDao<CreditCard> implements CreditCardDao {

	@Override
	protected Class<CreditCard> getClazz() {
		return CreditCard.class;
	}

}
