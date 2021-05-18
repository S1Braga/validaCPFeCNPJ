package com.ifoodteste.validacpfecnpjapplication.domain.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Document {

    private String document;
    private Boolean valid;
    private Enum document_type;

}
