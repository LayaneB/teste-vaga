package org.rethink.challenge.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CurrencyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id")
    public Long id;
    @Column(name = "currency_label", nullable=false, length = 200)
    public String label;
    @Column(name = "currency_value")
    public BigDecimal value;
    @Column(name = "currency_tax")
    public BigDecimal tax;

}
