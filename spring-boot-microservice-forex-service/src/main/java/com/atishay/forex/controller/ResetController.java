package com.atishay.forex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.atishay.forex.model.ExchangeValue;
import com.atishay.forex.payload.dto.ResponseErrorDTO;
import com.atishay.forex.payload.dto.ResponseWrapperDTO;
import com.atishay.forex.repository.ResetProjectRepository;
import com.atishay.forex.service.ExchangeValueService;
import com.atishay.forex.service.ResetProjectService;
import com.atishay.forex.utils.MethodUtils;

@RestController
@RequestMapping("/api/reset")
public class ResetController {

	@Autowired
	private ResetProjectRepository resetProjectRepository;

	@Autowired
	private ResetProjectService resetProjectService;

	@Autowired
	private ExchangeValueService exchangeValueService;

	@SuppressWarnings("unchecked")
	@PostMapping("/resetErp")
	public ResponseEntity<?> reset(HttpServletRequest httpServletRequest) {

		try {
			removeAllTables();

			ExchangeValue exchangeValueUSDAndINR = getExchangeValue("USD", "INR", 65d);
			exchangeValueUSDAndINR = exchangeValueService.saveAndFlush(exchangeValueUSDAndINR);

			ExchangeValue exchangeValueEURAndINR = getExchangeValue("EUR", "INR", 75d);
			exchangeValueEURAndINR = exchangeValueService.saveAndFlush(exchangeValueEURAndINR);

			ExchangeValue exchangeValueAUDAndINR = getExchangeValue("AUD", "INR", 25d);
			exchangeValueAUDAndINR = exchangeValueService.saveAndFlush(exchangeValueAUDAndINR);

		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity(
					new ResponseErrorDTO(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
							MethodUtils.getApiPathFromHttpServletRequest(httpServletRequest), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(new ResponseWrapperDTO(HttpServletResponse.SC_OK,
				httpServletRequest.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString(),
				"erp reseted successfully."));

	}

	public void removeAllTables() {
		removeProjectTables(new ExchangeValue());
	}

	@SuppressWarnings("hiding")
	public <T> void removeProjectTables(T t) {

		List<T> listOfT = resetProjectRepository.getAllRecords(t);

		if (!MethodUtils.isListIsNullOrEmpty(listOfT)) {
			for (T tt : listOfT) {

				resetProjectService.remove(tt);
			}
		}
	}

	public ExchangeValue getExchangeValue(String currencyFrom, String currencyTo, double conversationRate) {
		ExchangeValue exchangeValue = new ExchangeValue();
		exchangeValue.setCurrencyFrom(currencyFrom);
		exchangeValue.setCurrencyTo(currencyTo);
		exchangeValue.setConversationRate(conversationRate);

		return exchangeValue;
	}
}
