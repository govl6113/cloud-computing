package com.cloudcomputing.company.review.infra.http.response;

import java.time.LocalDateTime;

import com.cloudcomputing.company.review.domain.Review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponse {

    String id;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    String title;

    String content;

    Float star;

    String writerNickname;

    @Builder
    public ReviewResponse(Review review){
        this.id = review.getId().toString();
        this.createdAt = review.getCreatedAt();
        this.updatedAt = review.getUpdatedAt();
        this.title = review.getTitle();
        this.content = review.getContent();
        this.star = review.getStar();
        this.writerNickname = review.getWriterNickname();
    }
}
