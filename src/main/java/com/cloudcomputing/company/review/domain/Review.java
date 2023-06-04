package com.cloudcomputing.company.review.domain;

import com.cloudcomputing.company.common.domain.Core;
import com.cloudcomputing.company.company.domain.Company;
import com.cloudcomputing.company.review.infra.http.response.ReviewResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends Core {

    @ManyToOne(targetEntity = Company.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false, length = 36)
    private String title;

    @Column(nullable = false, length = 300)
    private String content;

    @Column(nullable = false)
    private Float star;

    @Column(nullable = false)
    private Long writerId;

    @Column(nullable = false)
    private String writerEmail;

    @Builder
    public Review(
            Company company,
            String title,
            String content,
            Float star,
            Long writerId,
            String writerEmail
    ) {
        this.company = company;
        this.title = title;
        this.content = content;
        this.star = star;
        this.writerId = writerId;
        this.writerEmail = writerEmail;
    }

    public Review update(
            String title,
            String content,
            Float star
    ) {
        this.title = title;
        this.content = content;
        this.star = star;
        return this;
    }

    public ReviewResponse toResponse() {
        return ReviewResponse.builder()
                             .review(this)
                             .build();
    }
}
