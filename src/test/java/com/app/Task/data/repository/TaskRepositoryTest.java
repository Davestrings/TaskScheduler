package com.app.Task.data.repository;

import com.app.Task.data.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class TaskRepositoryTest {

    @Autowired
    TaskRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createdTaskTest(){
        Task myTask = Task.builder()
                .name("Clean the bath-room")
                .type("Toilet job")
                .status("active").build();
        log.info("Task object created ---> {}", myTask);
        repository.save(myTask);

        assertThat(myTask.getId()).isNotNull();
        log.info("Task object after saving to db {}", myTask);
    }
}