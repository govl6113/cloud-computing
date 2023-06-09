package com.cloudcomputing.company.review.infra.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudcomputing.company.review.domain.Review;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId, Pageable pageable);

    Review save(Review review);

    Optional<Review> findById(Long id);
}
