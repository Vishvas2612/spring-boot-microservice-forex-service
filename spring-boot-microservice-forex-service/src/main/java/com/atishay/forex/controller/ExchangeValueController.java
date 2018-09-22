package com.atishay.forex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atishay.forex.model.ExchangeValue;
import com.atishay.forex.repository.ExchangeValueRepository;

@RestController
@RequestMapping(value="/api/exchange-value")
public class ExchangeValueController {

	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		ExchangeValue exchangeValue = repository.findByCurrencyFromAndCurrencyTo(from, to);

		return exchangeValue;
	}
}
