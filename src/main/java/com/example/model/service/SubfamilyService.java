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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubfamilyService extends BaseService<Subfamily, Long, SubfamilyRepository> {

    private final FamilyService familyService;

    public List<Subfamily> findAllOrderByName() {
        return this.repositorio.findAll(Sort.by("name"));
    }

    public List<Subfamily> findByName(String name) {
        return this.repositorio.findByNameContainsIgnoreCase(name);
    }


    //REST//
    //substituida por findByArgs
    public Page<Subfamily> findByName(String name, Pageable pageable){
        return repositorio.findByNameContainsIgnoreCase(name, pageable);
    }
    public Page<Subfamily> findByArgs(final Optional<String> name, final Optional<Long> familyid, Pageable pageable) {

        //CLASES ANONIMAS SPECIFICATION
        Specification<Subfamily> subfamilySpecificationName = new Specification<Subfamily>() {
            @Override
            public Predicate toPredicate(Root<Subfamily> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (name.isPresent())
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.get() + "%");
                else
                    return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            }
        };


        //TODO: BUSCAR POR EL ID DE LA FAMILIA
        Specification<Subfamily> subfamilySpecificationFamilyId = new Specification<Subfamily>() {
            @Override
            public Predicate toPredicate(Root<Subfamily> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                if (familyid.isPresent())
                    //return criteriaBuilder.like(criteriaBuilder.lower(root.get("familyid")), "%" + familyid.get() + "%");
                    return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
                else
                    return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            }
        };

        Specification<Subfamily> allSpecifications = subfamilySpecificationName.and(subfamilySpecificationFamilyId);

        return this.repositorio.findAll(allSpecifications, pageable);

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


    public Page<Subfamily> findByFamilyId(Long id, Pageable pageable) {
        return this.repositorio.findByFamily_Id(id, pageable);
    }
}
