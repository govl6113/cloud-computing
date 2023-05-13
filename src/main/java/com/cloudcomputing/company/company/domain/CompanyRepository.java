package com.cloudcomputing.company.company.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

public interface CompanyRepository {

    List<Company> getList(Pageable pageable);

    Optional<Company> getById(Long companyId);
}
