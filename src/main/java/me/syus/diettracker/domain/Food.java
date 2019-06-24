package me.syus.diettracker.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.List;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "foods_id_seq1")
    @SequenceGenerator(name = "foods_id_seq1", sequenceName = "foods_id_seq", allocationSize = 1)
    private Long Id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_calorie")
    private int foodCalorie;

    @Column(name = "food_type")
    private String foodType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "food", cascade = CascadeType.ALL)
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Long getId() {
        return Id;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodCalorie() {
        return foodCalorie;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodCalorie(int foodCalorie) {
        this.foodCalorie = foodCalorie;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
