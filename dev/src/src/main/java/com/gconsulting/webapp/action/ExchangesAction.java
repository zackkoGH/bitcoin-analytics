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
	private Exchange selectedExchange = new Exchange();
	private String code;

	@Autowired
	public void setExchangeManager(
			@Qualifier("exchangeManager") ExchangeManager exchangeManager) {
		this.exchangeManager = exchangeManager;
	}

	public ExchangesAction() {
		setSortColumn("code"); // sets the default sort column
//		isUpdate = false;
	}

	public List<Exchange> getExchanges() {
		return sort(exchangeManager.getAllExchange());
	}

	public Exchange getSelectedExchange() {
		return selectedExchange;
	}

	public void setSelectedExchange(Exchange selectedExchange) {
		this.selectedExchange = selectedExchange;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String delete() {

//		isUpdate = false;		
		exchangeManager.delete(selectedExchange);
		addMessage("exchanges.deleted");
		return "list";
	}

	public String edit() {

		if (code == null) {
			code = new String(getParameter("code"));
		}
		selectedExchange = exchangeManager.getExchangeByCode(code);
//		isUpdate = true;
//		getRequest().setAttribute("isUpdate", isUpdate);
		return "edit";
	}

	public String save() {

		String key = new String("");
		boolean isUpdate = (exchangeManager.getExchangeByCode(selectedExchange.getCode()) == null) ? false : true; 
//		isUpdate = (Boolean) getRequest().getAttribute("isUpdate");
		if(!isUpdate) {
			exchangeManager.create(selectedExchange);
			key = "exchanges.added";
		} else {
			exchangeManager.update(selectedExchange);
			key = "exchanges.updated";			
		}
		addMessage(key);
//		if(!isUpdate) {
//			return "edit";			
//		} else {
			return "list";			
//		}
	}
}
