package com.example.controllerrest;

import com.example.error.Family.FamilyConstraintViolationException;
import com.example.error.Family.FamilyInsertNameNotFoundException;
import com.example.error.Family.FamilyNotFoundException;
import com.example.model.dto.converter.FamilyDTOConverter;
import com.example.model.dto.family.CreateUpdateDTOFamily;
import com.example.model.entity.Family;
import com.example.model.service.FamilyService;
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

@RestController
@RequestMapping("/api/family")
@RequiredArgsConstructor
public class FamilyRestController {
    // con @RequiredArgsConstructor y el servicio final, no hace falta @Autowired
    private final FamilyService familyService;

    private final FamilyDTOConverter familyDTOConverter;

    private final PaginationLinksUtil paginationLinksUtil;

    //get page
    @GetMapping("/")
    public ResponseEntity<?> list(@PageableDefault(size = 10, page = 0) Pageable pageable, HttpServletRequest request) {
        Page<Family> result = familyService.findAll(pageable);
        if (result.isEmpty()) {
            throw new FamilyNotFoundException();
       } else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            return ResponseEntity.ok().header(
                    "link",
                    paginationLinksUtil.createLinkHeader(result, uriBuilder))
                    .body(result);
        }
    }
    //get list
    /*@GetMapping("/list")
    public ResponseEntity<?> list() {
        List<Family> result = familyService.findAll();
        if (result.isEmpty()) {
            throw new FamilyNotFoundException();
        } else {
            return ResponseEntity.ok(result);
        }
    }*/

    @GetMapping("/orderbyname") //TODO: return pageable ordered
    public ResponseEntity<?> listOrderByname(@PageableDefault(size = 10, page = 0) Pageable pageable, HttpServletRequest request) {
        Page<Family> result = familyService.findAll(pageable);
        if (result.isEmpty()) {
            throw new FamilyNotFoundException();
        } else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            return ResponseEntity.ok().header(
                    "link",
                    paginationLinksUtil.createLinkHeader(result, uriBuilder))
                    .body(result);
        }
    }

    @GetMapping("/findbyname")
    public ResponseEntity<?> findByName(@PageableDefault(size = 10, page = 0) Pageable pageable,
                                        @RequestParam("name") String name,
                                        HttpServletRequest request) {
        Page<Family> result = familyService.findByName(name, pageable);

        if (result.isEmpty()) {
            throw new FamilyNotFoundException(name);
        } else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            return ResponseEntity.ok().header( "link", paginationLinksUtil.createLinkHeader(result, uriBuilder))
                    .body(result);
        }
    }

    @GetMapping("/{id}")
    public Family getOne(@PathVariable Long id) {
        return familyService.findById(id)
                .orElseThrow(()-> new FamilyNotFoundException(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CreateUpdateDTOFamily dtoFamily) {
        if (dtoFamily.getName() == null)
            throw new FamilyInsertNameNotFoundException();

        Family f = familyDTOConverter.convertDtoToEntity(dtoFamily);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(familyService.save(f));
    }

    @PutMapping("/{id}")
    public Family edit(@RequestBody Family family, @PathVariable Long id){
        return familyService.findById(id).map(f-> {
            f.setName(family.getName());
            return familyService.save(f);
        }).orElseThrow(() -> new FamilyNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Long id) {
        Family f = familyService.findById(id).orElseThrow(() -> new FamilyNotFoundException(id));
        try {
            familyService.delete(f);
        } catch (Exception e) { //catch (ConstraintViolationException e)
            System.out.println(e.getMessage());
            throw new FamilyConstraintViolationException();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAll() {
        try {
            familyService.deleteAll();
        } catch (Exception e) { //catch (ConstraintViolationException e)
            System.out.println(e.getMessage());
            throw new FamilyConstraintViolationException();
        }

        return ResponseEntity.noContent().build();
    }
}
