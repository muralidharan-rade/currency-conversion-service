package com.cloudnative.currency;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConverterController {

	@GetMapping(path = "/currency/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenyConversionBean getCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		return new CurrenyConversionBean(1L, from, to, quantity, new BigDecimal(100), new BigDecimal(100));
	}

}
