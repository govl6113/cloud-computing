package com.cloudcomputing.company.company.domain;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface CompanyRepository {

    List<Company> getList(Pageable pageable);

    Company getById(Long companyId);

    Company getByName(String companyName);
}
