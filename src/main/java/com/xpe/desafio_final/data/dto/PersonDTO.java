package com.xpe.desafio_final.data.dto;

import com.xpe.desafio_final.data.enumeration.PersonTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {

    private Long personId;

    @NotEmpty(message = "{person.name.not.empty}")
    private String personName;

    @NotEmpty(message = "{person.document.not.empty}")
    private String personDocument;

    private String personPhone;

    @NotEmpty(message = "{person.email.not.empty}")
    @Email(message = "{person.email.invalid}")
    private String personEmail;

    private AddressDTO personAddress;

    @NotNull(message = "{person.type.not.null}")
    private PersonTypeEnum personType;
}
