package com.cloudcomputing.company.review.application;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcomputing.company.review.domain.Review;
import com.cloudcomputing.company.review.domain.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getList(Long companyId, int page) {
        return reviewRepository.getListByCompanyId(companyId, PageRequest.of(page-1,15));
    }
}
