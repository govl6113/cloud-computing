package com.cloudcomputing.company.company.infra.http.response;

import com.cloudcomputing.company.company.domain.Company;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompanyResponse {

    Long id;

    String name;

    String homepage;

    String location;

    Short foundation;

    Integer reviewCount;

    Float star;

    String image;

    @Builder
    public CompanyResponse(
            Company company
    ) {
        this.id = company.getId();
        this.name = company.getName();
        this.homepage = company.getHomepage();
        this.location = company.getLocation();
        this.foundation = company.getFoundation();
        this.reviewCount = company.getReviewCount();
        this.star = company.getStar();
        this.image = company.getImage();
    }
}
