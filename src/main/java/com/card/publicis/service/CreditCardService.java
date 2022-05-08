package com.card.publicis.service;

import com.card.publicis.dto.CreditCardRequest;
import com.card.publicis.dto.CreditCardResponse;
import com.card.publicis.model.CreditCard;
import com.card.publicis.repository.CreditCardRepository;
import com.card.publicis.service.converter.CreditCardRequestToCreditCardConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardRequestToCreditCardConverter converter;

    public CreditCardService(CreditCardRepository creditCardRepository, CreditCardRequestToCreditCardConverter converter) {
        this.creditCardRepository = creditCardRepository;
        this.converter = converter;
    }

    public CreditCardResponse add(CreditCardRequest creditCardRequest) {

        CreditCard creditCard = converter.apply(creditCardRequest);
        creditCardRepository.save(creditCard);
        return CreditCardResponse.builder()
                .cardNumber(creditCard.getCardNumber())
                .build();
    }

    public List<CreditCard> retrieveAll() {
        return creditCardRepository.findAll();
    }
}
