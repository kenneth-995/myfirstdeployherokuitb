package com.example.model.repository;

import com.example.model.entity.Subfamily;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubfamilyRepository extends JpaRepository<Subfamily, Long>,
        JpaSpecificationExecutor<Subfamily> {

     Page<Subfamily> findByNameContainsIgnoreCase(String name, Pageable pageable) ;

     Page<Subfamily> findByFamily_Id(Long id, Pageable pageable);
}
