package com.example.model.service;

import com.example.error.Family.FamilyConstraintViolationException;
import com.example.error.Family.FamilyNotFoundException;
import com.example.error.subfamily.SubfamilyNotFoundException;
import com.example.model.dto.drug.CreateUpdateDTODrug;
import com.example.model.entity.Drug;
import com.example.model.repository.DrugRepository;
import com.example.model.service.base.BaseService;
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
public class DrugService extends BaseService<Drug, Long, DrugRepository> {

    public List<Drug> findByName(String name) {
        return this.repositorio.findByNameContainsIgnoreCase(name);
    }

    public List<Drug> findAllOrderByName() {
        return this.repositorio.findAll(Sort.by("name").descending());
    }

    // REST //
    public Page<Drug> findByName(String name, Pageable pageable) {
        return this.repositorio.findByNameContainsIgnoreCase(name, pageable);
    }

    public Page<Drug> findByArgs(final Optional<String> name, final Optional<String> dose, Pageable pageable) {
        Specification<Drug> drugSpecificationName = new Specification<Drug>() {
            @Override
            public Predicate toPredicate(Root<Drug> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (name.isPresent())
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.get() + "%");
                 else
                     return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
        };
        Specification<Drug> drugSpecificationDose = new Specification<Drug>() {
            @Override
            public Predicate toPredicate(Root<Drug> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (dose.isPresent())
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get("dose")), "%" + dose.get() + "%");
                else
                    return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
        };

        Specification<Drug> allSpecifications = drugSpecificationName.and(drugSpecificationDose);

        return this.repositorio.findAll(allSpecifications, pageable);
    }

    public Drug updateDrug(CreateUpdateDTODrug dtoDrug, Long id) {
        return this.repositorio.findById(id).map( d -> {
            d.setName(dtoDrug.getName());
            d.setDose(dtoDrug.getDose());
            return this.repositorio.save(d);
        }).orElseThrow(() -> new SubfamilyNotFoundException(id));
    }

    public void deleteDrug(Long id) {
        Drug drug = this.repositorio.findById(id).orElseThrow(() -> new FamilyNotFoundException(id));//TODO

        try {
            this.repositorio.delete(drug);
        } catch (Exception e) { //catch (ConstraintViolationException e)
            System.out.println(e.getMessage());
            throw new FamilyConstraintViolationException();
        }
    }
}
