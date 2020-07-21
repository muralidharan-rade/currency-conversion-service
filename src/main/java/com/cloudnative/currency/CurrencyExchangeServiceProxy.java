package com.cloudnative.currency;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrenyConversionBean getCurrencyExchangeValue(@PathVariable String from, @PathVariable String to);

}
