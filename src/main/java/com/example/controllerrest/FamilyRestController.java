package com.example.controllerrest;

import com.example.error.Family.FamilyNameNotFoundException;
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
    //return list
    /*@GetMapping("/list")
    public ResponseEntity<?> list() {
        List<Family> result = familyService.findAll();
        if (result.isEmpty()) {
            throw new FamilyNotFoundException();
        } else {
            return ResponseEntity.ok(result);
        }
    }*/

    @GetMapping("/{id}")
    public Family getOne(@PathVariable Long id) {
        return familyService.findById(id)
                .orElseThrow(()-> new FamilyNotFoundException(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CreateUpdateDTOFamily dtoFamily) {
        if (dtoFamily.getName() == null)
            throw new FamilyNameNotFoundException();

        Family f = familyDTOConverter.convertDtoToEntity(dtoFamily);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(familyService.save(f));
    }
}
