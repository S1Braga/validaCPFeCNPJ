package com.ifoodteste.validacpfecnpjapplication.web;


import com.ifoodteste.validacpfecnpjapplication.domain.model.CheckDigit;
import com.ifoodteste.validacpfecnpjapplication.domain.service.CheckDigitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document/{document_number}/check_digit")
@RequiredArgsConstructor
public class CheckDigitController {

    private final CheckDigitService checkDigitService;

    @GetMapping
    public CheckDigit documentValidation(@PathVariable("document_number") String number) {

        return checkDigitService.verifyingDigit(number);
    }
}