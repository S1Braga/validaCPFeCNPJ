package com.ifoodteste.validacpfecnpjapplication.web;


import com.ifoodteste.validacpfecnpjapplication.domain.model.Document;
import com.ifoodteste.validacpfecnpjapplication.domain.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document/{document_number}/validation")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping
    public Document documentValidation(@PathVariable("document_number") String number) {

        return documentService.documentValidation(number);
    }
}
