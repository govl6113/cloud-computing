package com.cloudcomputing.company.company.application;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcomputing.company.company.domain.Company;
import com.cloudcomputing.company.company.domain.CompanyRepository;
import com.cloudcomputing.company.company.infra.http.response.CompanyResponse;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyResponse> getList(int page) {
        return companyRepository.getList(PageRequest.of(page - 1, 15));
    }

    @Override
    public Company getById(Long companyId) {
        return companyRepository.getById(companyId);
    }

    @Override
    public Company getByName(String companyName) {
        return companyRepository.getByName(companyName);
    }
}
