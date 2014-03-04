package com.nxsystems.payanycard.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nxsystems.payanycard.exception.UniqueCreditCardException;
import com.nxsystems.payanycard.manager.CreditCardManager;
import com.nxsystems.payanycard.model.CreditCard;


@Component
@Path("/creditcard")
@Produces(MediaType.APPLICATION_JSON)
public class CreditCardService implements ICreditCardService {

	private Log LOG = LogFactory.getLog(getClass());

	@Autowired
	private CreditCardManager creditCardManager;

	/**
	 * create new credit card
	 * 
	 * 
	 * @param creditCardNumber
	 * @return if everything is return true, else false
	 */
	@POST
	@Consumes("*/*")
	@Path("/")
	public Response create(@QueryParam("credit-card-number") String creditCardNumber) {


		if (LOG.isDebugEnabled())
			LOG.debug("[start] CreditCardService - create");
		
		
		try {

			creditCardManager.save(new CreditCard(creditCardNumber));
			
		} catch (Exception e) {
			LOG.error(e);

			if(e instanceof UniqueCreditCardException){
				return Response.status(ERR_CODE_CREDITCARD_UNIQUE_VIOLETED).build();
			}
			
			return Response.status(ERR_CODE).build();
		}

		if (LOG.isDebugEnabled())
			LOG.debug("[end] CreditCardService - create");

		
		return Response.status(ENTITY_CREATED).entity(Boolean.TRUE).build();
	}

}
