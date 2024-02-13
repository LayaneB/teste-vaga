package org.rethink.challenge.client;

import org.rethink.challenge.model.client.ConvertRequest;
import org.rethink.challenge.model.client.ExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value="urlExchangeServiceClient", url= "${url.exchangeserviceclient}")
public interface IExchangeServiceClient {

    @GetMapping("/convert/{from_currency}/{to_currency}")
    ResponseEntity<ExchangeResponse> convertCurrency(@PathVariable("from_currency") String fromCurrency, @PathVariable("to_currency") String toCurrency, @RequestBody ConvertRequest request);

}
