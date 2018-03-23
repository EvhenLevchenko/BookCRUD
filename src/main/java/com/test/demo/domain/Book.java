package com.test.demo.domain;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;
}
