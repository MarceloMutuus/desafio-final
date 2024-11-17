package com.xpe.desafio_final.api;

import com.xpe.desafio_final.data.dto.PersonDTO;
import com.xpe.desafio_final.facade.PersonFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("v1")
public class PersonApi {

    private final PersonFacade personFacade;

    @GetMapping(value = "count")
    public Map<String, Long> getCount() {
        return personFacade.personCount();
    }

    @PostMapping(value = "save")
    public PersonDTO save(@RequestBody PersonDTO personDTO) {
        return personFacade.savePerson(personDTO);
    }
}
