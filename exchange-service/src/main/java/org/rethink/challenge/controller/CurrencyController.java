package org.rethink.challenge.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.rethink.challenge.model.ConvertRequest;
import org.rethink.challenge.model.CurrencyModel;
import org.rethink.challenge.model.response.ExchangeResponse;
import org.rethink.challenge.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path="book-exchange")
@RequiredArgsConstructor
@Log4j2
public class CurrencyController {

    @Autowired
    private ICurrencyService service;

    @GetMapping("/convert/{from_currency}/{to_currency}")
    public ResponseEntity<ExchangeResponse> convertCurrency(@PathVariable("from_currency") String fromCurrency, @PathVariable("to_currency") String toCurrency, @RequestBody ConvertRequest request) {
        return ResponseEntity.ok(service.convertCurrency(fromCurrency, toCurrency, request.getUsdValue()));
    }

    @PostMapping("/new-currency")
    public ResponseEntity<CurrencyModel> createNewCurrency(@RequestBody CurrencyModel newCurrency) {
        log.info("Recebendo uma requisição: metodo=criar, requestDto={}", newCurrency);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewCurrency(newCurrency));
    }

    @PutMapping("/{currency_label}")
    public ResponseEntity<CurrencyModel> updateCurrency(@PathVariable("currency_label") String currencyLabel, @RequestBody CurrencyModel newCurrency) {
        return ResponseEntity.ok(service.updateCurrency(currencyLabel, newCurrency));
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{currency_label}")
    public void deleteCurrency(@PathVariable("currency_label") String currencyLabel) {
       service.deleteCurrency(currencyLabel);
    }

}
