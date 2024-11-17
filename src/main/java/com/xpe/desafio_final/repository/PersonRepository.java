package com.xpe.desafio_final.repository;

import com.xpe.desafio_final.data.domain.Person;
import com.xpe.desafio_final.data.enumeration.PersonTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value =  "SELECT COUNT(1) AS count " +
                    " FROM Person AS p " +
                    " WHERE p.personType = :personType")
    Long typeCount(@Param("personType") PersonTypeEnum personType);

    @Query(value =  " FROM Person AS p" +
                    " WHERE p.personName LIKE :personName%")
    Person findByName(@Param("personName") String personName);
}
