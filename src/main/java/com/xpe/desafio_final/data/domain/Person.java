package com.xpe.desafio_final.data.domain;

import com.xpe.desafio_final.data.enumeration.PersonTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person",
    uniqueConstraints = @UniqueConstraint(columnNames = {"person_document", "person_type"}))
@Getter
@Setter
public class Person {
    @Column(name = "person_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "person_document", nullable = false, length = 14)
    private String personDocument;

    @Column(name = "person_phone")
    private String personPhone;

    @Column(name = "person_email", nullable = false)
    private String personEmail;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address personAddress;

    @Column(name = "person_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PersonTypeEnum personType;
}
