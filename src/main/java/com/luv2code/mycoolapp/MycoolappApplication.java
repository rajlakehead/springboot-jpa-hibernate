package com.luv2code.mycoolapp;

import com.luv2code.mycoolapp.dao.StudentDAO;
import com.luv2code.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		Student newStudent = new Student("Raj", "Patel", "raj@gmail.com");

		studentDAO.save(newStudent);

		System.out.println("Saved student id: " + newStudent.getId());
	}

}
