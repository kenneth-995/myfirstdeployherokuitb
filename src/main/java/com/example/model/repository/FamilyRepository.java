package com.example.model.repository;

import com.example.model.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FamilyRepository extends JpaRepository<Family, Long>,
        JpaSpecificationExecutor<Family> {

    List<FamilyRepository> findByNameContainsIgnoreCase(String name);

}
