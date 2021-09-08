package com.solomon.taskTracker.task;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;



@Data
@Document(collection = "Task")
public class Task {
    @Id
    private String _id;
    private String text;

    @Indexed(unique = true)
    private String day;
    private Boolean reminder;


    public Task(String text, String day, Boolean reminder) {
        this.text = text;
        this.day = day;
        this.reminder = reminder;
    }
}
