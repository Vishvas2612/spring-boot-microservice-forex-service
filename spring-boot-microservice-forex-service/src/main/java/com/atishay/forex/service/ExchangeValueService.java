package com.atishay.forex.service;

import com.atishay.forex.model.ExchangeValue;

public interface ExchangeValueService {

	public ExchangeValue saveAndFlush(ExchangeValue exchangeValue);
}
