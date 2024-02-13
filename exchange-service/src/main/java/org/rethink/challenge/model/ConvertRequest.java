package org.rethink.challenge.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConvertRequest {
    private BigDecimal usdValue;
}
