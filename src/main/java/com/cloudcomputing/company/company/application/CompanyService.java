package com.cloudcomputing.company.company.application;

import java.util.List;

import com.cloudcomputing.company.company.domain.Company;

public interface CompanyService {
    List<Company> getList(int page);

    Company getById(Long companyId);

    Company getByName(String companyName);
}
