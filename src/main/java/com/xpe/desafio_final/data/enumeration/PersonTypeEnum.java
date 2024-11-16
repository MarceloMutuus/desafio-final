package com.xpe.desafio_final.data.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum PersonTypeEnum {

    CUSTOMER("Cliente"),
    PARTNER("Fornecedor"),
    EMPLOYEE("Colaborador");

    private final String personType;

    public static List<String> getPersonTypeList() {
        return Arrays.stream(PersonTypeEnum.values())
                .map(person -> PersonTypeEnum.valueOf(person.name()).getPersonType())
                .collect(Collectors.toList());
    }

    public static Map<String,String> getPersonTypeMap() {
        Map<String,String> personTypeMap = new HashMap<>();
        Arrays.stream(PersonTypeEnum.values())
            .forEach(personType -> personTypeMap.put(personType.name(),personType.getPersonType()));
        return personTypeMap;
    }
}
