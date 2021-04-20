package com.example.model.repository;

import com.example.model.entity.Exchange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Long>,
        JpaSpecificationExecutor<Exchange> {

    // REST //
    Page<Exchange> findByCurrentDrug_Id(Long id, Pageable pageable);

    Page<Exchange> findByAlternativeDrug_Id(Long id, Pageable pageable);

    Page<Exchange> findBySubfamily_Id(Long id, Pageable pageable);

    Page<Exchange> findBySubfamily_Name(String name, Pageable pageable);

    //TODO findBySubfamily_Name() no busca bien
    @Query(value =
            //"SELECT e FROM exchange ex JOIN ex.subfamilyid sf JOIN sf.name WHERE sf.name = %a%"
            //"SELECT e FROM exchange e INNER JOIN subfamily s ON e.subfamilyid = s.id WHERE s.name LIKE '%a%' ORDER BY s.name ASC;"
            "SELECT e.id, e.currentdrugid, e.alternativedrugid, e.subfamilyid from exchange e where e.currentdrugid = 12"
            , nativeQuery = true)

    Page<Exchange> findBySubfamilyNameQuery(@Param("name")String name, Pageable pageable);


    @Query( value = "SELECT * FROM exchange",
            nativeQuery = true,
            countQuery ="SELECT count(*) FROM exchange")
    Page<Exchange>  findByQuery(Pageable pageable);
}
