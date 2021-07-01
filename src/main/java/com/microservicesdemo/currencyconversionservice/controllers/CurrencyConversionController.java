package com.microservicesdemo.currencyconversionservice.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicesdemo.currencyconversionservice.bean.CurrencyConversion;
import com.microservicesdemo.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionbyFeign(@PathVariable String from , @PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversion currencyConversion = proxy.retrieveExchangevalue(from, to);
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, 
				currencyConversion.getConversionMultiple(),
				currencyConversion.getConversionMultiple().multiply(quantity),
				currencyConversion.getEnvironment());
	}
}
