package com.cloudcomputing.company.company.domain;

import org.hibernate.annotations.ColumnDefault;

import com.cloudcomputing.company.common.domain.Core;
import com.cloudcomputing.company.company.infra.http.response.CompanyResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends Core {
    @Column(nullable = false, length = 24)
    private String name;

    @Column(nullable = true, length = 36)
    private String homepage;

    @Column(nullable = false, length = 36)
    private String location;

    @Column(nullable = true)
    private Short foundation;

    @ColumnDefault("0")
    private Integer reviewCount = 0;

    @ColumnDefault("0.0")
    private Float star;

    @Column(nullable = true)
    private String image;

    public void updateReviewCount(Boolean reviewCountIncrease) {
        if (reviewCountIncrease) {
            this.reviewCount += 1;
        } else {
            this.reviewCount -= 1;
        }
    }

    public void updateStar(Float star) {
        this.star = (this.star * (this.reviewCount - 1) + star) / this.reviewCount;
    }

    public CompanyResponse toResponse() {
        return CompanyResponse.builder()
                              .company(this)
                              .build();
    }
}
