package com.atishay.forex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atishay.forex.model.ExchangeValue;
import com.atishay.forex.repository.ExchangeValueRepository;
import com.atishay.forex.service.ExchangeValueService;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService{

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@Transactional
	@Override
	public ExchangeValue saveAndFlush(ExchangeValue exchangeValue) {
		return exchangeValueRepository.saveAndFlush(exchangeValue);
	}
	
	
}
