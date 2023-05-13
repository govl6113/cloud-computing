package com.cloudcomputing.company.review.application;

import java.util.List;

import com.cloudcomputing.company.review.domain.Review;

public interface ReviewService {
    List<Review> getList(Long companyId, int page);
}
