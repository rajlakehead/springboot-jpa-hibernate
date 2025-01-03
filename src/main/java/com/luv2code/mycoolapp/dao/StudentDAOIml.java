package com.luv2code.mycoolapp.dao;

import com.luv2code.mycoolapp.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

}
