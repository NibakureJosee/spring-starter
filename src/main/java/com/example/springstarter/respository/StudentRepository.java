package com.example.springstarter.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springstarter.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

