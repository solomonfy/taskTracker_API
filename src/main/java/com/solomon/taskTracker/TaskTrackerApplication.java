package com.solomon.taskTracker;

import com.solomon.taskTracker.task.Task;
import com.solomon.taskTracker.task.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
//@RestController
public class TaskTrackerApplication {
	
//	public LocalDate day = LocalDate.of(2021, Month.SEPTEMBER, 5);
//
	public static void main(String[] args) {
		SpringApplication.run(TaskTrackerApplication.class, args);
	}
//
//	@Bean
//	CommandLineRunner runner(TaskRepository taskRepository) {
//		return args -> {
//			Task task1 = new Task("Meeting", day, true);
//
//			Query query = new Query();
//			query.addCriteria(Criteria.where("day").is(day));
//			//			taskRepository.
//			taskRepository.insert(task1);
//		};
//
//	}

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/cors-javaconfig").allowedOrigins("http://localhost:8080", "http://localhost:4200");
			}
		};
	}
}
