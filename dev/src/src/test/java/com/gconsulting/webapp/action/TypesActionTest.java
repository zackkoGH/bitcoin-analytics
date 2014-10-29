package com.gconsulting.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gconsulting.Constants;
import com.gconsulting.model.FeeApiType;
import com.gconsulting.model.Market;
import com.gconsulting.service.ExchangeManager;

public class TypesActionTest extends BasePageTestCase {

	private TypesAction bean;
	@Autowired
	@Qualifier("exchangeManager")
	private ExchangeManager exchangeManager;

	@Override
	@Before
	public void onSetUp() {

		super.onSetUp();
		bean = new TypesAction();
		bean.setExchangeManager(exchangeManager);

		// add a test person to the database
		Market market = new Market();
		market.setCode("TSTMKT");
		market.setDescription("This is a Test Market");
		FeeApiType type = new FeeApiType();
		type.setMarket(market);
		type.setType(Constants.API_TYPE_ORDERBOOK);
		exchangeManager.create(type);
	}

	@Override
	@After
	public void onTearDown() {
		super.onTearDown();
		bean = null;
	}

	@Test
	public void testSearch() throws Exception {
		assertTrue(bean.getTypes().size() >= 1);
		assertFalse(bean.hasErrors());
	}

	@Test
	public void testAdd() throws Exception {

		Market market = new Market();
		market.setCode("TSTMKT2");
		market.setDescription("This is a Test Market");
		FeeApiType type = new FeeApiType();
		type.setMarket(market);
		type.setType(Constants.API_TYPE_ORDERBOOK);
		bean.setSelectedType(type);
		assertEquals("list", bean.save());
		assertFalse(bean.hasErrors());
	}

	@Test
	public void testEdit() throws Exception {

		log.debug("testing edit...");
		bean.setMarketCode("TSTMKT");
		bean.setType(Constants.API_TYPE_ORDERBOOK);
		assertEquals("edit", bean.edit());
		assertNotNull(bean.getSelectedType());
		assertFalse(bean.hasErrors());
	}

	@Test
	public void testSave() {

		bean.setMarketCode("TSTMKT");
		bean.setType(Constants.API_TYPE_ORDERBOOK);
		assertEquals("edit", bean.edit());
		assertNotNull(bean.getSelectedType());
		FeeApiType type = bean.getSelectedType();
		// update fields
		type.setType(Constants.API_TYPE_TRADES);
		bean.setSelectedType(type);
		assertEquals("edit", bean.save());
		assertFalse(bean.hasErrors());
	}

	@Test
	public void testRemove() throws Exception {

		Market market = new Market();
		market.setCode("TSTMKT2");
		market.setDescription("This is a Test Market");
		FeeApiType type = new FeeApiType();
		type.setMarket(market);
		type.setType(Constants.API_TYPE_ORDERBOOK);
		bean.setSelectedType(type);
		assertEquals("list", bean.delete());
		assertFalse(bean.hasErrors());
	}
}
