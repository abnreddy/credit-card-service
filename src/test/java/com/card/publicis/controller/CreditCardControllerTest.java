package com.card.publicis.controller;

import com.card.publicis.BaseService;
import com.card.publicis.dto.CreditCardResponse;
import com.card.publicis.model.CreditCard;
import com.card.publicis.service.CreditCardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
class CreditCardControllerTest extends BaseService {

    @InjectMocks
    private CreditCardController creditCardController;
    @Mock
    private CreditCardService creditCardService;

    @Test
    void addTest(){
        Mockito.when(creditCardService.add(Mockito.any())).thenReturn(CreditCardResponse.builder().cardNumber(12345L).build());
        ResponseEntity<CreditCardResponse> actual = creditCardController.add(creditCardRequest);

        Assertions.assertEquals(HttpStatus.CREATED, Objects.requireNonNull(actual.getStatusCode()));
        Assertions.assertEquals(12345L, Objects.requireNonNull(actual.getBody()).getCardNumber().longValue());
    }

    @Test
    void retrieveTest(){
        Mockito.when(creditCardService.retrieveAll()).thenReturn(creditCards);
        Mockito.when(creditCardService.retrieveAll()).thenReturn(creditCards);
        ResponseEntity<List<CreditCard>> actual = creditCardController.getAllCreditCards();

        Assertions.assertEquals(HttpStatus.OK, Objects.requireNonNull(actual.getStatusCode()));
        Assertions.assertEquals(1, Objects.requireNonNull(actual.getBody()).size());
        Assertions.assertEquals("test", Objects.requireNonNull(actual.getBody()).get(0).getName());
    }
}
