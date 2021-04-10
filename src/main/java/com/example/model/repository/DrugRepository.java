package com.example.model.repository;

import com.example.model.entity.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long>,
        JpaSpecificationExecutor<Drug> {

    List<Drug> findByNameContainsIgnoreCase(String name);

    Page<Drug> findByNameContainsIgnoreCase(String name, Pageable pageable);


}
