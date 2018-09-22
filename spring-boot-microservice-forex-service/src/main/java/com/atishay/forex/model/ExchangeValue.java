package com.atishay.forex.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.atishay.forex.utils.VariableUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = VariableUtils.TABLE_NAME_FOR_EXCHANGE_VALUE)
@JsonInclude(Include.NON_EMPTY)
public class ExchangeValue {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "exchangeValueId", nullable = false, insertable = false, updatable = false)
	private String id;

	@Column(name = "currencyFrom")
	private String currencyFrom;

	@Column(name = "currencyTo")
	private String currencyTo;

	@Column(name = "conversationRate", columnDefinition = "Decimal(10,2)")
	private Double conversationRate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public Double getConversationRate() {
		return conversationRate;
	}

	public void setConversationRate(Double conversationRate) {
		this.conversationRate = conversationRate;
	}

}
