package com.ifoodteste.validacpfecnpjapplication.domain.service;

import com.ifoodteste.validacpfecnpjapplication.domain.model.Document;
import com.ifoodteste.validacpfecnpjapplication.domain.model.DocumentType;
import com.ifoodteste.validacpfecnpjapplication.domain.service.helpers.CheckValidDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {

    @Cacheable("documents")
    public Document documentValidation(String number) {


        return identifyType(number);

    }

    private Document identifyType(String number) {

        Document document;

        if (number.length() == 11) {

             document = Document.builder()
                    .document(number)
                    .document_type(DocumentType.INDIVIDUAL)
                    .valid(checkIfItIsValidCPF(number))
                    .build();


        } else if (number.length() == 14) {

            document = Document.builder()
                    .document(number)
                    .document_type(DocumentType.BUSINESS)
                    .valid(checkIfItIsValidCNPJ(number))
                    .build();

        } else {

             document = Document.builder()
                    .document(number)
                    .document_type(DocumentType.NOT_IDENTIFIED)
                    .valid(Boolean.FALSE)
                    .build();
        }

        return document;
    }

    private Boolean checkIfItIsValidCPF(String number) {

        return CheckValidDocument.isCPF(number);
    }

    private Boolean checkIfItIsValidCNPJ(String number){

        return CheckValidDocument.isCNPJ(number);
    }
}
