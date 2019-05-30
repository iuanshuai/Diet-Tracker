package me.syus.calorietracker.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class Food {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "foods_id_swq")
    @SequenceGenerator(name = "foods_id_seq1", sequenceName = "foods_id_seq", allocationSize = 1)
    private Long Id;
    @Column(name = "food_name")
    private String foodName;
    @Column(name = "food_calorie")
    private int FoodCalorie;
    @Column(name = "food_type")
    private String foodType;
}
