package com.cloudcomputing.company.company.infra.http;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloudcomputing.company.company.application.CompanyService;
import com.cloudcomputing.company.company.infra.http.response.CompanyResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/list")
    public List<CompanyResponse> getList(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page
    ){
        return companyService.getList(page).stream()
                .map(it -> it.toResponse())
                .collect(Collectors.toList());
    }


    @GetMapping("/{companyId}")
    public CompanyResponse get (
            @PathVariable("companyId") @Valid @NotBlank Long companyId
    ){
        return companyService.get(companyId).toResponse();
    }
}
