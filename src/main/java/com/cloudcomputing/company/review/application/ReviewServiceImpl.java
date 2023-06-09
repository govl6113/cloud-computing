package com.cloudcomputing.company.review.application;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcomputing.company.company.domain.Company;
import com.cloudcomputing.company.company.domain.CompanyRepository;
import com.cloudcomputing.company.review.domain.Review;
import com.cloudcomputing.company.review.domain.ReviewRepository;
import com.cloudcomputing.company.review.exception.NotMatchingCompanyException;
import com.cloudcomputing.company.review.exception.UnauthorizedAccessException;
import com.cloudcomputing.company.review.infra.http.request.ReviewCreateRequest;
import com.cloudcomputing.company.review.infra.http.request.ReviewUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;

    @Override
    public List<Review> getList(Long companyId, int page) {
        return reviewRepository.getListByCompanyId(companyId, PageRequest.of(page - 1, 15));
    }

    @Override
    @Transactional
    public Review create(ReviewCreateRequest request) {
        Company company = companyRepository.getById(request.getReviewCompanyId());
        if (!company.getName().equals(request.getUserCompanyName())) {
            throw new NotMatchingCompanyException();
        }

        company.updateReviewCount(true);
        company.updateStar(request.getReviewStar());

        return reviewRepository.save(
                Review.builder()
                      .writerId(request.getUserId())
                      .writerNickname(request.getUserNickname())
                      .company(company)
                      .title(request.getReviewTitle())
                      .content(request.getReviewContent())
                      .star(request.getReviewStar())
                      .build());
    }

    @Override
    @Transactional
    public Review update(Long reviewId, ReviewUpdateRequest request) {
        Review review = reviewRepository.getById(reviewId);
        if (!review.getWriterId().equals(request.getUserId())) {
            throw new UnauthorizedAccessException();
        }

        review.getCompany().updateStar(-review.getStar());
        review.getCompany().updateStar(request.getReviewStar());

        return review.update(request.getReviewTitle(), request.getReviewContent(), request.getReviewStar());
    }
}
