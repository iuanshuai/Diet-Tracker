package me.syus.diettracker.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "users_id_seq1")
    @SequenceGenerator(name = "users_id_seq1", sequenceName = "users_id_seq", allocationSize = 1)
    private Long Id;
    @Column
    private String email;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    public Long getId() {
        return Id;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
