package org.rethink.challenge.model.client;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeResponse {
    private BigDecimal convertedValue;
}
