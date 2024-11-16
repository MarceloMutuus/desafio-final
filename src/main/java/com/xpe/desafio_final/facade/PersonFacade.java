package com.xpe.desafio_final.facade;

import com.xpe.desafio_final.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class PersonFacade {

    private final PersonService personService;

    public Map<String, Long> personCount() {
        return personService.toPersonCount();
    }
}
