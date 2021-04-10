package com.example.controllerrest;

import com.example.error.subfamily.SubfamilyNotFoundException;
import com.example.model.dto.converter.DrugDTOConverter;
import com.example.model.dto.drug.CreateUpdateDTODrug;
import com.example.model.entity.Drug;
import com.example.model.entity.Family;
import com.example.model.service.DrugService;
import com.example.utils.pagination.PaginationLinksUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api/drug")
@RequiredArgsConstructor
public class DrugRestController {

    private final DrugService drugService;

    private final PaginationLinksUtil paginationLinksUtil;

    private final DrugDTOConverter drugDTOConverter;

    @GetMapping("/")
    public ResponseEntity<?> getAllByArgs (@PageableDefault() Pageable pageable,
                                           HttpServletRequest request,
                                           @RequestParam("name")Optional<String> name,
                                           @RequestParam("dose")Optional<String> dose) {
        Page<Drug> result = drugService.findByArgs(name, dose, pageable);
        if (result.isEmpty())
            throw new SubfamilyNotFoundException();
        else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            return ResponseEntity.ok().header(
                    "link",
                    paginationLinksUtil.createLinkHeader(result, uriBuilder))
                    .body(result);
        }

    }

    @GetMapping("/{id}")
    public Drug getOne(@PathVariable("id") Long id) {
        return drugService.findById(id).orElseThrow(() -> new SubfamilyNotFoundException(id));
    }

    @PostMapping("/")
    ResponseEntity<?> create(@RequestBody CreateUpdateDTODrug dtoDrug) {
        Drug drug = drugDTOConverter.convertDtoToEntity(dtoDrug);
        return ResponseEntity.status(HttpStatus.CREATED).body(drugService.save(drug));
    }

    @PutMapping("/{id}")
    public Drug edit(@RequestBody CreateUpdateDTODrug dtoDrug,
                     @PathVariable("id") Long id) {
        return drugService.updateDrug(dtoDrug, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOne (@PathVariable("id") Long id) {
        drugService.deleteDrug(id);
        return ResponseEntity.noContent().build();
    }

}
