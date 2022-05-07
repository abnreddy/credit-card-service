package com.card.controller;

import com.card.dto.CreditCardRequest;
import com.card.model.CreditCard;
import com.card.service.CreditCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("api/card")
@RestController
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping("/add")
    public ResponseEntity<Long> add(@RequestBody CreditCardRequest creditCardRequest){

        log.trace("Entered into add method");
        Long result = creditCardService.add(creditCardRequest);

        log.trace("Existed from add method");
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<CreditCard>> retrieveAll(){

        log.trace("Entered into retrieveAll method");
        List<CreditCard> result = creditCardService.retrieveAll();

        log.trace("Existed from retrieveAll method");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
