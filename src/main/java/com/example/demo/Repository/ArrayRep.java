package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.ArrayEntity;
public interface ArrayRep extends JpaRepository<ArrayEntity, Long> {

}
