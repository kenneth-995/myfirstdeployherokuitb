package com.example.model.service;

import com.example.model.entity.Family;
import com.example.model.repository.FamilyRepository;
import com.example.model.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyService extends BaseService<Family, Long, FamilyRepository> {

//    @Autowired
//    private FamilyRepository familyRepository;

    public List<Family> findByName(String name) {
        return this.repositorio.findByNameContainsIgnoreCase(name);
    }

    public List<Family> findAllOrderByName() {
        return this.repositorio.findAll(Sort.by("name"));
    }
}
