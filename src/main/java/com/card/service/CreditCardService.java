package com.card.service;

import com.card.dto.CreditCardRequest;
import com.card.model.CreditCard;
import com.card.repository.CreditCardRepository;
import com.card.service.converter.CreditCardRequestToCreditCardConverter;
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

    public Long add(CreditCardRequest creditCardRequest) {

        CreditCard creditCard = converter.apply(creditCardRequest);
        creditCardRepository.save(creditCard);
        return creditCard.getCardNumber();
    }

    public List<CreditCard> retrieveAll() {
        return creditCardRepository.findAll();
    }
}
