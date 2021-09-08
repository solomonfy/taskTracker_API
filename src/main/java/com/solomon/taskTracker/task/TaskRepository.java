package com.solomon.taskTracker.task;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByTextContaining(String text);
//    List<Task> findAllWithReminder(Boolean reminder);

}
