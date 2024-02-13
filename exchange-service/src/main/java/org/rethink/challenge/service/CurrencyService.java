package org.rethink.challenge.service;

import org.rethink.challenge.exception.ResponseException;
import org.rethink.challenge.model.CurrencyModel;
import org.rethink.challenge.model.response.ExchangeResponse;
import org.rethink.challenge.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class CurrencyService implements ICurrencyService{

    @Autowired
    private CurrencyRepository repository;
    @Override
    public ExchangeResponse convertCurrency(String fromCurrency, String toCurrency, BigDecimal valueUSD) {

        Optional<CurrencyModel> currencyModel = repository.findCurrencyModelByLabel(toCurrency);
        if(!currencyModel.isPresent()){
            throw new RuntimeException("Currency not available");
        }
        CurrencyModel currency = currencyModel.get();
        BigDecimal covertedValue = (valueUSD.multiply(currency.getValue()).multiply(currency.getTax())).setScale(2,RoundingMode.FLOOR);

        ExchangeResponse response = new ExchangeResponse();
        response.setConvertedValue(covertedValue);

        return response;
    }

    @Override
    public CurrencyModel createNewCurrency(CurrencyModel newCurrency) {
        Optional<CurrencyModel> currency = repository.findCurrencyModelByLabel(newCurrency.getLabel());
        if(currency.isPresent()){
            throw new ResponseException(HttpStatus.CONFLICT, "Currency alredy exists");
        }
        return repository.save(newCurrency);
    }

    @Override
    @Transactional
    public CurrencyModel updateCurrency(String currencyLabel, CurrencyModel currency) {
        Optional<CurrencyModel> currencyRepo = repository.findCurrencyModelByLabel(currencyLabel);
        if(!currencyRepo.isPresent()){
            throw new ResponseException(HttpStatus.NOT_FOUND, "Currency doesn't exists");
        }
        return repository.save(currency);
    }

    @Override
    public void deleteCurrency(String currencyLabel) {
        Optional<CurrencyModel> currencyRepo = repository.findCurrencyModelByLabel(currencyLabel);
        if(!currencyRepo.isPresent()) {
            throw new ResponseException(HttpStatus.NOT_FOUND, "Currency doesn't exists");
        }
        repository.delete(currencyRepo.get());


    }
}
