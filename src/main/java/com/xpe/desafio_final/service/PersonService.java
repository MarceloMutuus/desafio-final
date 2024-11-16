package com.xpe.desafio_final.service;

import com.xpe.desafio_final.data.enumeration.PersonTypeEnum;
import com.xpe.desafio_final.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Map<String,Long> toPersonCount() {
        var personTypeMap = PersonTypeEnum.getPersonTypeMap();
        Map<String, Long> personCount = new HashMap<>();
        personTypeMap.forEach((typeKey,typeValue) -> {
            personCount.put(typeValue, personRepository.typeCount(PersonTypeEnum.valueOf(typeKey)));
        });
        return personCount;
    }
}
