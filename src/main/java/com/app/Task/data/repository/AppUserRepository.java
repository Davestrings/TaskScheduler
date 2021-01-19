package com.app.Task.data.repository;

import com.app.Task.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "users")
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByUsername(String username);
}
