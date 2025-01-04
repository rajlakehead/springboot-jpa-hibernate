package com.luv2code.mycoolapp;

import com.luv2code.mycoolapp.dao.StudentDAO;
import com.luv2code.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//getAllStudents(studentDAO);
			//getStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);

		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(2);

	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(2);
		student.setFirstName("Bayo");
		studentDAO.update(student);

		System.out.println(student);
	}

	private void getStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Panchal");

		for(Student s: students){
			System.out.println(s);
		}
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		System.out.println(students);
	}

	private void readStudent(StudentDAO studentDAO) {

		Student newStudent = new Student("Anjali", "Patel", "Anjali@gmail.com");

		studentDAO.save(newStudent);

		int theId = newStudent.getId();

		Student myStudent = studentDAO.findById(theId);
		System.out.println(myStudent);

	}

	private void createStudent(StudentDAO studentDAO) {

		Student newStudent = new Student("Nihar", "Panchal", "jaakjsn@gmail.com");

		studentDAO.save(newStudent);

		System.out.println("Saved student id: " + newStudent.getId());
	}

}
