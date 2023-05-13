package com.cloudcomputing.company.review.infra.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.cloudcomputing.company.review.domain.Review;
import com.cloudcomputing.company.review.domain.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

    private final ReviewJpaRepository reviewRepository;

    @Override
    public List<Review> getListByCompanyId(Long companyId, Pageable pageable){
        return reviewRepository.findByCompanyId(companyId, pageable);
    }
}
