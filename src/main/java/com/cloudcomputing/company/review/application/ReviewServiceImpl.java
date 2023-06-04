package com.cloudcomputing.company.review.application;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcomputing.company.common.domain.User;
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
    public Review create(User user, ReviewCreateRequest request) {
        Company company = companyRepository.getById(request.getCompanyId());
        if (!company.getName().equals(user.getCompanyName())) {
            throw new NotMatchingCompanyException();
        }

        company.updateReviewCount(true);
        company.updateStar(request.getStar());

        return reviewRepository.save(
                Review.builder()
                      .writerId(user.getId())
                      .writerEmail(user.getEmail())
                      .company(company)
                      .title(request.getTitle())
                      .content(request.getContent())
                      .star(request.getStar())
                      .build());
    }

    @Override
    public Review update(Long reviewId, User user, ReviewUpdateRequest request) {
        Review review = reviewRepository.findById(reviewId);
        if (!review.getWriterId().equals(user.getId())) {
            throw new UnauthorizedAccessException();
        }

        review.getCompany().updateStar(-review.getStar());
        review.getCompany().updateStar(request.getStar());

        return review.update(request.getTitle(), request.getContent(), request.getStar());
    }
}
