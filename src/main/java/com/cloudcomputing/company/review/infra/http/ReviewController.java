package com.cloudcomputing.company.review.infra.http;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcomputing.company.review.application.ReviewService;
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
    public List<ReviewResponse> getList(
            @PathVariable("companyId") @Valid @NotBlank Long companyId,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page
    ) {
        return reviewService.getList(companyId, page).stream()
                            .map(it -> it.toResponse())
                            .collect(Collectors.toList());
    }

    // todo: c u d는 filter -> writer 확인 ->  star 업데이트

}
