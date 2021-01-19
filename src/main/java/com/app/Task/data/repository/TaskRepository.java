package com.app.Task.data.repository;

import com.app.Task.data.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "task")
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
