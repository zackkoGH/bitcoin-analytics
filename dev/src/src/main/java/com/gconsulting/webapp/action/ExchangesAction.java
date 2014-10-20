package com.gconsulting.webapp.action;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gconsulting.model.Exchange;
import com.gconsulting.service.ExchangeManager;

@SuppressWarnings("unchecked")
@Scope("request")
@Component("exchangeAction")
public class ExchangesAction extends BasePage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4820984471948349094L;
	
	private ExchangeManager exchangeManager;

	@Autowired
	public void setExchangeManager(
			@Qualifier("exchangeManager") ExchangeManager exchangeManager) {
		this.exchangeManager = exchangeManager;
	}

	public ExchangesAction() {
		setSortColumn("code"); // sets the default sort column
	}

	public List<Exchange> getExchanges() {
		return sort(exchangeManager.getAllExchange());
	}
}
