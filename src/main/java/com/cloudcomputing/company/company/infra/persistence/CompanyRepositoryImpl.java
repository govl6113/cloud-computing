package com.cloudcomputing.company.company.infra.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.cloudcomputing.company.company.domain.Company;
import com.cloudcomputing.company.company.domain.CompanyRepository;
import com.cloudcomputing.company.company.exception.NotFoundCompanyException;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {

    private final JPAQueryFactory queryFactory;
    private final CompanyJpaRepository companyRepository;

    @Override
    public List<Company> getList(Pageable pageable) {
        return companyRepository.getAll(pageable);
    }

    @Override
    public Company getById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(NotFoundCompanyException::new);
    }

    @Override
    public Company getByName(String companyName) {
        return companyRepository.findByName(companyName).orElseThrow(NotFoundCompanyException::new);
    }
}
