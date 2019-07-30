package me.syus.diettracker.repository;

import me.syus.diettracker.domain.Authority;

import java.util.List;

public interface AuthorityDao {


    public Authority save(Authority a);

    public List<Authority> findAuthoritiesByUserId(Long userId);


}
