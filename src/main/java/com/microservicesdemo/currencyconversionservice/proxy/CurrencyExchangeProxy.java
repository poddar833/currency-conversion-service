package com.microservicesdemo.currencyconversionservice.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservicesdemo.currencyconversionservice.bean.CurrencyConversion;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangevalue(@PathVariable String from , @PathVariable String to);
}
