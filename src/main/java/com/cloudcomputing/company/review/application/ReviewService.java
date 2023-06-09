package com.cloudcomputing.company.review.application;

import java.util.List;

import com.cloudcomputing.company.review.domain.Review;
import com.cloudcomputing.company.review.infra.http.request.ReviewCreateRequest;
import com.cloudcomputing.company.review.infra.http.request.ReviewUpdateRequest;

public interface ReviewService {
    List<Review> getList(Long companyId, int page);

    Review create(ReviewCreateRequest request);

    Review update(Long reviewId, ReviewUpdateRequest request);
}
