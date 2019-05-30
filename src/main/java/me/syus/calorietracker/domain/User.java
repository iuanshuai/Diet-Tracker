package me.syus.calorietracker.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "users_id_swq")
    @SequenceGenerator(name = "users_id_seq1", sequenceName = "users_id_seq", allocationSize = 1)
    private Long Id;
    @Column
    private String email;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;


}
