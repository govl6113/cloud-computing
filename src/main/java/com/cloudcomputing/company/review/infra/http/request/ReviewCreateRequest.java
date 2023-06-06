package com.cloudcomputing.company.review.infra.http.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewCreateRequest {
    Long userId;

    String userCompanyName;

    String userNickname;

    Long reviewCompanyId;

    String reviewTitle;

    String reviewContent;

    Float reviewStar;

}
