package edu.itstep.javaintro.sql;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String family_name;

    private int age;
    private int egn;

    public Person(String name, String family_name, int age, int egn){
        this.name = name;
        this.family_name = family_name;
        this.age = age;
        this.egn = egn;
    }

}
