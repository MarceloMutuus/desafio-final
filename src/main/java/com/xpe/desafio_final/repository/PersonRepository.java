package com.xpe.desafio_final.repository;

import com.xpe.desafio_final.data.domain.Person;
import com.xpe.desafio_final.data.enumeration.PersonTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value =  "SELECT COUNT(1) AS totallCount " +
                    " FROM Person AS p " +
                    " WHERE p.personType = :personType")
    Long typeCount(PersonTypeEnum personType);
}
