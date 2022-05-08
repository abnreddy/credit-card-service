package com.card.publicis.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CreditCardResponse {

    private String name;
    private Long cardNumber;
    private BigDecimal balance;
    private BigDecimal limit;
}
