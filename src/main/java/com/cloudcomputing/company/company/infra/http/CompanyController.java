package com.cloudcomputing.company.company.infra.http;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcomputing.company.company.application.CompanyService;
import com.cloudcomputing.company.company.infra.http.response.CompanyResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/list")
    public ResponseEntity<List<CompanyResponse>> getList(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page
    ) {
        return ResponseEntity.ok().body(companyService.getList(page));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> get(
            @PathVariable("companyId") @Valid @NotBlank Long companyId
    ) {
        return ResponseEntity.ok().body(companyService.getById(companyId).toResponse());
    }

    @GetMapping("/{companyName}")
    public ResponseEntity<CompanyResponse> getByName(
            @PathVariable("companyName") @Valid @NotBlank String companyName
    ) {
        return ResponseEntity.ok().body(companyService.getByName(companyName).toResponse());
    }
}
