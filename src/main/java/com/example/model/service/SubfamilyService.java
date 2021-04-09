package com.example.model.service;

import com.example.error.Family.FamilyNotFoundException;
import com.example.model.dto.subfamily.CreateUptateDTOSubfamily;
import com.example.model.entity.Family;
import com.example.model.entity.Subfamily;
import com.example.model.repository.SubfamilyRepository;
import com.example.model.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubfamilyService extends BaseService<Subfamily, Long, SubfamilyRepository> {

    private final FamilyService familyService;

    public List<Subfamily> findAllOrderByName() {
        return this.repositorio.findAll(Sort.by("name"));
    }

    //REST
    public Page<Subfamily> findByName(String name, Pageable pageable){
        return repositorio.findByNameContainsIgnoreCase(name, pageable);
    }

    public Subfamily updateSubfamily(CreateUptateDTOSubfamily dto, Long id) {
        return this.repositorio.findById(id).map( s -> {
            s.setName(dto.getName()); //se podria comprobar si el nombre es nulo y lanzar exception si no permitimos nombres nulos
            if (dto.getFamilyid() == null) {
                throw new FamilyNotFoundException();
            } else {
                Family family = familyService.findById(dto.getFamilyid()).orElseThrow(() -> new FamilyNotFoundException(dto.getFamilyid()));
                s.setFamily(family);
            }

            return this.repositorio.save(s);
        }).orElseThrow(() -> new FamilyNotFoundException());
    }
}
