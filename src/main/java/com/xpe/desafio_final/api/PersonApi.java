package com.xpe.desafio_final.api;

import com.xpe.desafio_final.data.dto.PersonDTO;
import com.xpe.desafio_final.facade.PersonFacade;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public PersonDTO save(@Valid @RequestBody PersonDTO personDTO) {
        return personFacade.savePerson(personDTO);
    }

    @GetMapping(value = "find-all")
    public List<PersonDTO> findAll() {
        return personFacade.findAll();
    }

    @GetMapping(value = "id/{id}")
    public PersonDTO findById(@PathVariable Long id) {
        return personFacade.findById(id);
    }

    @GetMapping(value = "name/{name}")
    public PersonDTO findByName(@PathVariable String name) {
        return personFacade.findByName(name);
    }
}
