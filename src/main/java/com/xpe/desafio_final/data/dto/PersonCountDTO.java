package com.xpe.desafio_final.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PersonCountDTO {

    private Long totalCount;
    private Long customerCount;
    private Long partnerCount;
    private Long employeeCount;
}
