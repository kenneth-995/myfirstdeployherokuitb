package com.example.model.repository;

import com.example.model.entity.Family;
import com.example.model.entity.Subfamily;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SubfamilyRepository extends JpaRepository<Subfamily, Long>,
        JpaSpecificationExecutor<Subfamily> {

     // REST //
     Page<Subfamily> findByNameContainsIgnoreCase(String name, Pageable pageable) ;

     Page<Subfamily> findByFamily_Id(Long id, Pageable pageable);

     // WEB //
     List<Subfamily> findByNameContainsIgnoreCase(String name);

}
