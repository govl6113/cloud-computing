package com.cloudcomputing.company.company.application;

import java.util.List;

import com.cloudcomputing.company.company.domain.Company;
import com.cloudcomputing.company.company.infra.http.response.CompanyResponse;

public interface CompanyService {
    List<CompanyResponse> getList(int page);

    Company get(Long companyId);
}
