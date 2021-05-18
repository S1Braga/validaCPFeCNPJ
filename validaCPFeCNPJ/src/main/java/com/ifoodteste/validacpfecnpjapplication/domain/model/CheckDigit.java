package com.ifoodteste.validacpfecnpjapplication.domain.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CheckDigit {

    private String document_base;
    private String check_digit;
    private Enum document_type;

}
