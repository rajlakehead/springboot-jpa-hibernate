package com.luv2code.mycoolapp.dao;

import com.luv2code.mycoolapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOIml implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOIml(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName = :lastName", Student.class);
        theQuery.setParameter("lastName", lastName);
        return theQuery.getResultList();
    }
}
