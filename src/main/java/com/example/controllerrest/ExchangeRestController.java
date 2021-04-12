package com.example.controllerrest;

import com.example.error.exchange.ExchangeNotFoundException;
import com.example.error.subfamily.SubfamilyNotFoundException;
import com.example.model.dto.exchange.CreateExchangeDTO;
import com.example.model.dto.subfamily.CreateUptateDTOSubfamily;
import com.example.model.entity.Exchange;
import com.example.model.entity.Subfamily;
import com.example.model.service.ExchangeService;
import com.example.utils.pagination.PaginationLinksUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api/exchange")
@RequiredArgsConstructor
public class ExchangeRestController {

    private final ExchangeService exchangeService;

    private final PaginationLinksUtil paginationLinksUtil;

    @GetMapping("/")
    public ResponseEntity<?> getAll(@PageableDefault Pageable pageable,
                                    HttpServletRequest request) {
        Page<Exchange> result = exchangeService.findAll(pageable);
        if (result.isEmpty())
            throw new ExchangeNotFoundException();
        else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            return ResponseEntity.ok().header(
                    "link",
                    paginationLinksUtil.createLinkHeader(result, uriBuilder))
                    .body(result);
        }
    }

    @GetMapping("/{id}")
    public Exchange getOne(@PathVariable("id") Long id){
        return exchangeService.findById(id).orElseThrow(() ->new ExchangeNotFoundException(id));

    }


    @GetMapping("/subfamily/{id}")
    public ResponseEntity<?> getBySubfamilyId(@PageableDefault Pageable pageable,
                                           @PathVariable("id") Long id,
                                           HttpServletRequest request) {
        Page<Exchange> result = exchangeService.findBySubfamilyId(id, pageable);
        if (result.isEmpty())
            throw new ExchangeNotFoundException();
        else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            return ResponseEntity.ok().header(
                    "link",
                    paginationLinksUtil.createLinkHeader(result, uriBuilder))
                    .body(result);
        }
    }

    @GetMapping("/subfamily")
    public ResponseEntity<?> getBySubfamilyName(@PageableDefault Pageable pageable,
                                              @RequestParam("name") String name,
                                              HttpServletRequest request) {
        Page<Exchange> result = exchangeService.findBySubfamilyNameQuery(name, pageable);
        if (result.isEmpty())
            throw new ExchangeNotFoundException();
        else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            return ResponseEntity.ok().header(
                    "link",
                    paginationLinksUtil.createLinkHeader(result, uriBuilder))
                    .body(result);
        }
    }


    @GetMapping("/current/{id}")
    public ResponseEntity<?> getByCurrendDrugId (@PageableDefault Pageable pageable,
                                                 @PathVariable("id") Long id,
                                                 HttpServletRequest request) {
        Page<Exchange> result = exchangeService.findByCurrentDrugId(id, pageable);
        if (result.isEmpty())
            throw new ExchangeNotFoundException();
        else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            return ResponseEntity.ok().header(
                    "link",
                    paginationLinksUtil.createLinkHeader(result, uriBuilder))
                    .body(result);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CreateExchangeDTO dto) {
        return ResponseEntity.ok().body(exchangeService.create(dto));
    }

    @PutMapping("/{id}")
    public Exchange edit(@RequestBody CreateExchangeDTO dto,
                          @PathVariable("id") Long id) {
        return exchangeService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Exchange e = exchangeService.findById(id).orElseThrow(() -> new SubfamilyNotFoundException(id));
        exchangeService.delete(e);
        return ResponseEntity.noContent().build();
    }
}
