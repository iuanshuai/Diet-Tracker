package me.syus.diettracker.repository;

import me.syus.diettracker.domain.Food;

import java.util.List;

public interface FoodDao {
    Food save(Food user);

    List<Food> findAll();

    Food findByIdEager(Long id);

    Food findById(Long id);
}
