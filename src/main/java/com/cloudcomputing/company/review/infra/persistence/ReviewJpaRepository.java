package com.cloudcomputing.company.review.infra.persistence;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudcomputing.company.review.domain.Review;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId, Pageable pageable);
}
