package com.card.controller;

import com.card.BaseService;
import com.card.model.CreditCard;
import com.card.service.CreditCardService;
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
        Mockito.when(creditCardService.add(Mockito.any())).thenReturn(12345L);
        ResponseEntity<Long> actual = creditCardController.add(creditCardRequest);

        Assertions.assertEquals(HttpStatus.CREATED, Objects.requireNonNull(actual.getStatusCode()));
        Assertions.assertEquals(12345L, Objects.requireNonNull(actual.getBody()).longValue());
    }

    @Test
    void retrieveTest(){
        Mockito.when(creditCardService.retrieveAll()).thenReturn(creditCards);
        Mockito.when(creditCardService.retrieveAll()).thenReturn(creditCards);
        ResponseEntity<List<CreditCard>> actual = creditCardController.retrieveAll();

        Assertions.assertEquals(HttpStatus.OK, Objects.requireNonNull(actual.getStatusCode()));
        Assertions.assertEquals(1, Objects.requireNonNull(actual.getBody()).size());
        Assertions.assertEquals("test", Objects.requireNonNull(actual.getBody()).get(0).getName());
    }
}
