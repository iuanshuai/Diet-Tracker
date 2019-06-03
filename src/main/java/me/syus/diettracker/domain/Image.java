package me.syus.diettracker.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;



@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator="images_id_seq")
    @SequenceGenerator(name="images_id_seq", sequenceName="images_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String title;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name="food_id")
    private Food food1;

    public Image() {
    }
}
