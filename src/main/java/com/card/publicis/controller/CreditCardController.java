package com.card.publicis.controller;

import com.card.publicis.dto.CreditCardResponse;
import com.card.publicis.dto.ErrorMessage;
import com.card.publicis.model.CreditCard;
import com.card.publicis.dto.CreditCardRequest;
import com.card.publicis.service.CreditCardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("api/credit-card")
@RestController
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @ApiOperation(value = "Add Credit Card", nickname = "AddCreditCard", response = CreditCardResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Add Credit Card", response = CreditCardResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping("/add")
    public ResponseEntity<CreditCardResponse> add(@RequestBody CreditCardRequest creditCardRequest){

        log.trace("Entered into add method");
        CreditCardResponse result = creditCardService.add(creditCardRequest);

        log.trace("Existed from add method");
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @ApiOperation(value = "Get All Credit Cards", nickname = "getAllCreditCards")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get All Credit Cards")})
    @GetMapping("/get-all")
    public ResponseEntity<List<CreditCard>> getAllCreditCards(){

        log.trace("Entered into retrieveAll method");
        List<CreditCard> result = creditCardService.retrieveAll();

        log.trace("Existed from retrieveAll method");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
