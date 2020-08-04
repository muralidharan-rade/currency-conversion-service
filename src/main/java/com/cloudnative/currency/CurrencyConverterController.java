package com.cloudnative.currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConverterController {
	Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	CurrencyExchangeServiceProxy feignProxy;

	@GetMapping(path = "/currency-resttemplate/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenyConversionBean getCurrencyConversionFromTemplate(@PathVariable String from, @PathVariable String to,
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

	@GetMapping(path = "/currency/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenyConversionBean getCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrenyConversionBean bean = feignProxy.getCurrencyExchangeValue(from, to);
		logger.info("{} : " + bean);

		return new CurrenyConversionBean(bean.getId(), from, to, quantity, bean.getMultiple(),
				quantity.multiply(bean.getMultiple()), bean.getPort());
	}

}
