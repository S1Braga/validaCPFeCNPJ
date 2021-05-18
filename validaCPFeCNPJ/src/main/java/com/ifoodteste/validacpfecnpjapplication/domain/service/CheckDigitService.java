package com.ifoodteste.validacpfecnpjapplication.domain.service;

import com.ifoodteste.validacpfecnpjapplication.domain.model.CheckDigit;
import com.ifoodteste.validacpfecnpjapplication.domain.model.DocumentType;
import com.ifoodteste.validacpfecnpjapplication.domain.service.helpers.CheckDigitDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckDigitService {

    @Cacheable("checkdigit")
    public CheckDigit verifyingDigit(String number) {


        return identifyType(number);

    }

    private CheckDigit identifyType(String number) {

        CheckDigit checkDigit;

        if (number.length() == 9) {

            checkDigit = CheckDigit.builder()
                    .document_base(number)
                    .check_digit(calculatingCheckDigitCPF(number))
                    .document_type(DocumentType.INDIVIDUAL)
                    .build();


        } else if (number.length() == 12) {

            checkDigit = CheckDigit.builder()
                    .document_base(number)
                    .check_digit(calculatingCheckDigitCNPJ(number))
                    .document_type(DocumentType.BUSINESS)
                    .build();

        } else {

            checkDigit = CheckDigit.builder()
                    .document_base(number)
                    .check_digit("it was not possible to calculate")
                    .document_type(DocumentType.NOT_IDENTIFIED)
                    .build();
        }

        return checkDigit;
    }

    private String calculatingCheckDigitCPF(String number) {

        return CheckDigitDocument.isCPF(number);
    }

    private String calculatingCheckDigitCNPJ(String number) {

        return CheckDigitDocument.isCNPJ(number);
    }

}


