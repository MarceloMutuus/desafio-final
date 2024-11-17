package com.xpe.desafio_final.service;

import com.xpe.desafio_final.data.domain.Person;
import com.xpe.desafio_final.data.dto.PersonDTO;
import com.xpe.desafio_final.data.enumeration.PersonTypeEnum;
import com.xpe.desafio_final.data.mapper.PersonMapper;
import com.xpe.desafio_final.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    public Map<String,Long> toPersonCount() {
        var personTypeMap = PersonTypeEnum.getPersonTypeMap();
        AtomicLong totalCount = new AtomicLong(0);
        Map<String, Long> personCount = new HashMap<>();
        personTypeMap.forEach((typeKey,typeValue) -> {
            var count = personRepository.typeCount(PersonTypeEnum.valueOf(typeKey));
            totalCount.getAndAdd(count);
            personCount.put(typeValue, count);
        });
        personCount.put("Total de Registros", totalCount.get());
        return personCount;
    }

    public PersonDTO savePerson(PersonDTO personDTO) {
        var person = personRepository.save(personMapper.toPerson(personDTO));
        return personMapper.toPersonDTO(person);
    }

    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

    public List<PersonDTO> findAll() {
        var personList= personRepository.findAll();
        return personMapper.toPersonDTOList(personList);
    }

    public PersonDTO findById(Long personId) {
        var person = new Person();
        var optional = personRepository.findById(personId);
        if (optional.isPresent()) person = optional.orElseThrow();
        return personMapper.toPersonDTO(person);
    }

    public List<PersonDTO> findByName(String personName) {
        var person = personRepository.findByName(personName);
        return personMapper.toPersonDTOList(person);
    }
}
