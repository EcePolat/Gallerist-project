package com.ecepolat.controller.impl;

import com.ecepolat.controller.IRestCurrencyRatesController;
import com.ecepolat.controller.RestBaseController;
import com.ecepolat.controller.RootEntity;
import com.ecepolat.dto.CurrencyRatesResponse;
import com.ecepolat.service.ICurrencyRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/")
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController {

    @Autowired
    private ICurrencyRatesService currencyRatesService;

    @GetMapping("/currency-rates")
    @Override
    public RootEntity<CurrencyRatesResponse> getCurrencyRates(@RequestParam("startDate") String startDate, @RequestParam("startDate") String endDate) {
        return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
    }
}
