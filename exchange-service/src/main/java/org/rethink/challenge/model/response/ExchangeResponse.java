package org.rethink.challenge.model.response;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class ExchangeResponse {

    private BigDecimal convertedValue;


}
