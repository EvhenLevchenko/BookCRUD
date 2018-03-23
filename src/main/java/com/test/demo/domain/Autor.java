package com.test.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "autor")
@ToString
@Builder
@Getter
public class Autor implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @Singular
    private List<Book> books;
}
