package com.nxsystems.payanycard.test;

import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
public class SimpleTest {

	/*
	 * 
	 * */
	@Test
	public void create() {

		WebResource r = null;

		try {

			Client c = new Client();

			r = c.resource("http://localhost:8080/pay-any-card/rest/creditcard/?credit-card-number=asas33");

			String ctx = r.type(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON).post(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(ctx);
			
			Assert.assertEquals("true", ctx);

		}

		catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}
	}

}
