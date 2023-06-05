package com.spring.springboot.dal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@MappedSuperclass
@SuperBuilder
public abstract class AbstractIdentificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
