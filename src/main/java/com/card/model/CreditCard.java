package com.card.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard {

    @Id
    private Long cardNumber;
    private String name;
    private BigDecimal balance;
    private BigDecimal cardLimit;
}
