package com.card.publicis.service.converter;

import com.card.publicis.dto.CreditCardRequest;
import com.card.publicis.model.CreditCard;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Function;

@Component
public class CreditCardRequestToCreditCardConverter implements Function<CreditCardRequest, CreditCard> {

    @Override
    public CreditCard apply(CreditCardRequest creditCardRequest) {
        return CreditCard.builder()
                .cardNumber(creditCardRequest.getCardNumber())
                .name(creditCardRequest.getName())
                .cardLimit(creditCardRequest.getCardLimit())
                .balance(BigDecimal.ZERO)
                .build();
    }
}
