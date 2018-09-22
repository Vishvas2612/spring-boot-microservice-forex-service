package com.atishay.forex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atishay.forex.model.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, String> {
	ExchangeValue findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);
}
