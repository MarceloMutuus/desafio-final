package com.xpe.desafio_final.data.mapper;

import com.xpe.desafio_final.data.domain.Person;
import com.xpe.desafio_final.data.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    Person toPerson(PersonDTO personDTO);

    PersonDTO toPersonDTO(Person person);

    List<PersonDTO> toPersonDTOList(List<Person> personList);
}
