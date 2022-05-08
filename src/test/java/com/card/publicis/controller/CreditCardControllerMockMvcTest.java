package com.card.publicis.controller;

import com.card.publicis.dto.CreditCardResponse;
import com.card.publicis.model.CreditCard;
import com.card.publicis.service.CreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 class CreditCardControllerMockMvcTest {

    private MockMvc mockMvc;

    @Mock
    private CreditCardService creditCardService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CreditCardController(creditCardService)).build();
    }

    @Test
    void shouldReturnSuccessResponse_whenGetAllEndPointIsCalled() throws Exception {
        List<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(CreditCard.builder().name("Brahma").cardNumber(4111111111111111L).cardLimit(new BigDecimal(100)).build());
        when(creditCardService.retrieveAll()).thenReturn(creditCards);
        this.mockMvc.perform(get("/api/credit-card/get-all")).andExpect(status().isOk());
    }

    @Test
    void shouldReturn201SuccessResponse_whenAddEndPointIsCalledWithRequest() throws Exception {
        String creditCardRequest = "{\"name\":\"Brahma\",\"cardNumber\":\"4111331122114411\",\"cardLimit\":\"240.0\"}";
        CreditCardResponse creditCardResponse = CreditCardResponse.builder().build();
        when(creditCardService.add(any())).thenReturn(creditCardResponse);
        this.mockMvc.perform(post("/api/credit-card/add").contentType(MediaType.APPLICATION_JSON).content(creditCardRequest)).andExpect(status().isCreated());
    }

}
