package com.cloudcomputing.company.review.infra.http;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcomputing.company.review.application.ReviewService;
import com.cloudcomputing.company.review.domain.Review;
import com.cloudcomputing.company.review.infra.http.request.ReviewCreateRequest;
import com.cloudcomputing.company.review.infra.http.request.ReviewUpdateRequest;
import com.cloudcomputing.company.review.infra.http.response.ReviewResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{companyId}")
    public ResponseEntity<List<ReviewResponse>> getList(
            @PathVariable("companyId") @Valid @NotBlank Long companyId,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page
    ) {
        return ResponseEntity.ok().body(reviewService.getList(companyId, page).stream()
                                                     .map(Review::toResponse)
                                                     .collect(Collectors.toList()));
    }

    @PostMapping("/new")
    public ResponseEntity<ReviewResponse> create(
            @RequestBody @Valid ReviewCreateRequest request
    ) {
        return ResponseEntity.ok().body(reviewService.create(request).toResponse());
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewResponse> update(
            @PathVariable("reviewId") @Valid @NotBlank Long reviewId,
            @RequestBody @Valid ReviewUpdateRequest request
    ) {
        return ResponseEntity.ok().body(reviewService.update(reviewId, request).toResponse());
    }

}
