package com.cloudnative.currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConverterController {

	@GetMapping(path = "/currency/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenyConversionBean getCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrenyConversionBean> responseBean = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrenyConversionBean.class,
				uriVariables);

		return new CurrenyConversionBean(responseBean.getBody().getId(), from, to, quantity,
				responseBean.getBody().getMultiple(), quantity.multiply(responseBean.getBody().getMultiple()));
	}

}
