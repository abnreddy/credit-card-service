package com.card.service;

import com.card.BaseService;
import com.card.model.CreditCard;
import com.card.repository.CreditCardRepository;
import com.card.service.converter.CreditCardRequestToCreditCardConverter;
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
        Long actual = creditCardService.add(creditCardRequest);
        Assertions.assertEquals(12345L, actual);
    }

    @Test
    void retrieveTest(){
        Mockito.when(creditCardRepository.findAll()).thenReturn(creditCards);
        List<CreditCard> actual = creditCardService.retrieveAll();
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals(12345L, actual.get(0).getCardNumber());
    }
}
