package com.codegym.repository;

import com.codegym.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserDAO extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String name);
}