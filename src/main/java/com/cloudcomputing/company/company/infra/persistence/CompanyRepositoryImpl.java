package com.cloudcomputing.company.company.infra.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.cloudcomputing.company.company.domain.Company;
import com.cloudcomputing.company.company.domain.CompanyRepository;
import com.cloudcomputing.company.company.domain.QCompany;
import com.cloudcomputing.company.company.exception.NotFoundCompanyException;
import com.cloudcomputing.company.company.infra.http.response.CompanyResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {

    private final JPAQueryFactory queryFactory;
    private final CompanyJpaRepository companyRepository;
    private final QCompany company = QCompany.company;

    @Override
    public List<CompanyResponse> getList(Pageable pageable) {
        return queryFactory.select(Projections.fields(CompanyResponse.class,
                                                      company.id,
                                                      company.name,
                                                      company.homepage,
                                                      company.location,
                                                      company.foundation,
                                                      company.reviewCount,
                                                      company.star,
                                                      company.image))
                           .from(company)
                           .offset(pageable.getOffset())
                           .limit(pageable.getPageSize())
                           .orderBy()
                           .fetch();
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
