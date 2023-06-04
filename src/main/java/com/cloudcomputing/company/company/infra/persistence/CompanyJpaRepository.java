package com.cloudcomputing.company.company.infra.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudcomputing.company.company.domain.Company;

public interface CompanyJpaRepository extends JpaRepository<Company, Long> {

    Optional<Company> findById(Long id);
}
