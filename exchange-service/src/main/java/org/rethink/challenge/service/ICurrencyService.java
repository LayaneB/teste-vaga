package org.rethink.challenge.service;

import org.rethink.challenge.model.CurrencyModel;
import org.rethink.challenge.model.response.ExchangeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

public interface ICurrencyService {

    ExchangeResponse convertCurrency( String fromCurrency, String toCurrency, BigDecimal value);

    CurrencyModel createNewCurrency(CurrencyModel newCurrency);

    CurrencyModel updateCurrency(String currencyLabel, CurrencyModel currency);

    void deleteCurrency(String currencyLabel);
}
