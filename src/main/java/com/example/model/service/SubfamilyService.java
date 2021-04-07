package com.example.model.service;

import com.example.model.entity.Subfamily;
import com.example.model.repository.SubfamilyRepository;
import com.example.model.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubfamilyService  extends BaseService<Subfamily, Long, SubfamilyRepository> {
    public List<Subfamily> findAllOrderByName() {
        return this.repositorio.findAll(Sort.by("name"));
    }
}
