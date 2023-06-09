package com.cloudcomputing.company.company.domain;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cloudcomputing.company.company.infra.http.response.CompanyResponse;

public interface CompanyRepository {

    List<CompanyResponse> getList(Pageable pageable);

    Company getById(Long companyId);

    Company getByName(String companyName);
}
