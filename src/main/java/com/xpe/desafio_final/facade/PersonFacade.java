package com.xpe.desafio_final.facade;

import com.xpe.desafio_final.data.dto.PersonDTO;
import com.xpe.desafio_final.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class PersonFacade {

    private final PersonService personService;

    public Map<String, Long> personCount() {
        return personService.toPersonCount();
    }

    public PersonDTO savePerson(PersonDTO personDTO) {
        return personService.savePerson(personDTO);
    }

    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    public PersonDTO findById(Long personId) {
        return personService.findById(personId);
    }

    public PersonDTO findByName(String personName) {
        return personService.findByName(personName);
    }
}
