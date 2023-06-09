package com.cloudcomputing.company.review.infra.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.cloudcomputing.company.review.domain.Review;
import com.cloudcomputing.company.review.domain.ReviewRepository;
import com.cloudcomputing.company.review.exception.NotFoundReviewException;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

    private final ReviewJpaRepository reviewRepository;

    @Override
    public List<Review> getListByCompanyId(Long companyId, Pageable pageable) {
        return reviewRepository.findByCompanyId(companyId, pageable);
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(NotFoundReviewException::new);
    }
}
