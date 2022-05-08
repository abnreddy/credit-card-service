package com.card.publicis;

import com.card.publicis.dto.CreditCardRequest;
import com.card.publicis.model.CreditCard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseService {

    protected CreditCardRequest creditCardRequest;
    protected CreditCard creditCard;
    protected List<CreditCard> creditCards = new ArrayList<>();

    public BaseService(){
        creditCardRequest = createCreditCardRequest();
        creditCard = createCreditCard();
        creditCards.add(creditCard);
    }

    private CreditCardRequest createCreditCardRequest() {
       return CreditCardRequest.builder()
                .cardNumber(12345L)
                .name("test")
                .cardLimit(BigDecimal.TEN)
                .build();
    }

    private CreditCard createCreditCard() {
        return CreditCard.builder()
                .cardNumber(12345L)
                .name("test")
                .balance(BigDecimal.valueOf(200))
                .cardLimit(BigDecimal.TEN)
                .build();
    }
}
