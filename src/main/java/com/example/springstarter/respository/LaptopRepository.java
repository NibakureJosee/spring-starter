package com.example.springstarter.respository;
import com.example.springstarter.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}

