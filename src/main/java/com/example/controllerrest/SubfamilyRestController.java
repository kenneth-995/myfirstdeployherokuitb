package com.example.controllerrest;

import com.example.error.Family.FamilyNotFoundException;
import com.example.error.subfamily.SubfamilyNotFoundException;
import com.example.model.dto.converter.SubfamilyDTOConverter;
import com.example.model.dto.subfamily.CreateUptateDTOSubfamily;
import com.example.model.entity.Family;
import com.example.model.entity.Subfamily;
import com.example.model.service.FamilyService;
import com.example.model.service.SubfamilyService;
import com.example.utils.pagination.PaginationLinksUtil;
import lombok.AllArgsConstructor;
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
@RequestMapping("/api/subfamily")
@RequiredArgsConstructor
public class SubfamilyRestController {

    private final SubfamilyService subfamilyService;
    private final FamilyService familyService;

    private final SubfamilyDTOConverter subfamilyDTOConverter;

    private final PaginationLinksUtil paginationLinksUtil;

    @GetMapping("/")
    public ResponseEntity<?> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable,
                                    HttpServletRequest request) {
        Page<Subfamily> result = subfamilyService.findAll(pageable);

        if (result.isEmpty()) {
            throw new SubfamilyNotFoundException();
        } else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            return ResponseEntity.ok().header(
                    "link",
                    paginationLinksUtil.createLinkHeader(result, uriBuilder))
                    .body(result);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CreateUptateDTOSubfamily dto){
        Subfamily subfamily = subfamilyDTOConverter.convertDtoToEntity(dto);
        System.out.println(subfamily.toString());
        subfamilyService.save(subfamily);
        return ResponseEntity.status(HttpStatus.CREATED).body(subfamily);
    }


    //TODO get by name, by id, by id family, by family name

    @PutMapping("/{id}")
    public Subfamily edit(@RequestBody CreateUptateDTOSubfamily dto,
                                  @PathVariable("id") Long id) {
        return subfamilyService.updateSubfamily(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Subfamily s = subfamilyService.findById(id).orElseThrow(() -> new SubfamilyNotFoundException(id));
        subfamilyService.delete(s);
        return ResponseEntity.noContent().build();
    }
}
