package com.example.model.repository;

import com.example.model.entity.IncludedGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositoryIncludedGuide extends JpaRepository<IncludedGuide, Long>,
        JpaSpecificationExecutor<RepositoryIncludedGuide> {



}
