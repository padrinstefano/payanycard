package com.nxsystems.payanycard.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class CreditCard extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	private String number;

	/*
	 * optimistic lock use this field
	 * */
	@Version
	private Integer version;

	public CreditCard() {
		super();
	}
	
	public CreditCard(String number) {
		this();
		this.number = number;
		this.version = 0;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof CreditCard))
			return false;

		final CreditCard creditCard = (CreditCard) other;

		if (!creditCard.getNumber().equals(getNumber()))
			return false;
		if (!creditCard.getVersion().equals(getVersion()))
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = getNumber().hashCode();
		result = 29 * result + getVersion();
		return result;
	}

}
