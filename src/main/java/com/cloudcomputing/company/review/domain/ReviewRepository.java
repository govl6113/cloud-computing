package com.cloudcomputing.company.review.domain;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface ReviewRepository {
    List<Review> getListByCompanyId(Long companyId, Pageable pageable);

    Review save(Review review);

    Review findById(Long reviewId);
}
