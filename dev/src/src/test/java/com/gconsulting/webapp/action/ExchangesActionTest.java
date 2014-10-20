package com.gconsulting.webapp.action;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gconsulting.model.Exchange;
import com.gconsulting.service.ExchangeManager;

public class ExchangesActionTest extends BasePageTestCase {
	 
	    private ExchangesAction bean;
	    @Autowired @Qualifier("exchangeManager")
	    private ExchangeManager exchangeManager;
	 
	    @Override
	    @Before
	    public void onSetUp() {

	    	super.onSetUp();
	        bean = new ExchangesAction();
	        bean.setExchangeManager(exchangeManager);
	 
	        // add a test person to the database
	        Exchange exchange = new Exchange();
	        exchange.setCode("TSTEXC");
	        exchange.setName("Test Exchange");
	        exchange.setDescription("This is a Test Exchange");
	        exchangeManager.create(exchange);
	    }
	 
	    @Override
	    @After
	    public void onTearDown() {
	        super.onTearDown();
	        bean = null;
	    }
	 
	    @Test
	    public void testSearch() throws Exception {
	        assertTrue(bean.getExchanges().size() >= 1);
	        assertFalse(bean.hasErrors());
	    }
	}
