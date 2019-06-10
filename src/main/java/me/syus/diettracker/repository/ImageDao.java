package me.syus.diettracker.repository;

import me.syus.diettracker.domain.Image;

import java.util.List;

public interface ImageDao {
    Image save(Image image);

    List<Image> findAll();

    Image findByIdEager(Long id);

    Image findById(Long id);
}
