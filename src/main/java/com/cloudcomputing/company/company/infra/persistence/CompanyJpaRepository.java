package com.cloudcomputing.company.company.infra.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudcomputing.company.company.domain.Company;

public interface CompanyJpaRepository extends JpaRepository<Company,Long> {
    List<Company> getAll(Pageable pageable);

    Optional<Company> findById(Long id);

    Optional<Company> findByName(String name);
}
