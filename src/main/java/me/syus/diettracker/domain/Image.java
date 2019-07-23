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

//    private String s3key;

    @ManyToOne
    @JoinColumn(name="food_id")
    private Food food;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Food getFood() {
        return food;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFood(Food food1) {
        this.food = food1;
    }

    public Image() {
    }
}
