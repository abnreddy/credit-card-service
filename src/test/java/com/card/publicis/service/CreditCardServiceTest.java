package com.card.publicis.service;

import com.card.publicis.dto.CreditCardResponse;
import com.card.publicis.model.CreditCard;
import com.card.publicis.repository.CreditCardRepository;
import com.card.publicis.service.converter.CreditCardRequestToCreditCardConverter;
import com.card.publicis.BaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreditCardServiceTest extends BaseService  {

    @Mock
    private CreditCardRepository creditCardRepository;
    @Mock
    private CreditCardRequestToCreditCardConverter converter;
    @InjectMocks
    private CreditCardService creditCardService;


    @Test
    void addTest(){
        Mockito.when(converter.apply(creditCardRequest)).thenReturn(creditCard);
        Mockito.when(creditCardRepository.save(creditCard)).thenReturn(creditCard);
        CreditCardResponse actual = creditCardService.add(creditCardRequest);
        Assertions.assertEquals(12345L, actual.getCardNumber());
    }

    @Test
    void retrieveTest(){
        Mockito.when(creditCardRepository.findAll()).thenReturn(creditCards);
        List<CreditCard> actual = creditCardService.retrieveAll();
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals(12345L, actual.get(0).getCardNumber());
    }
}
