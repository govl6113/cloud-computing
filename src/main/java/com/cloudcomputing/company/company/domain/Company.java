package com.cloudcomputing.company.company.domain;

import org.hibernate.annotations.ColumnDefault;

import com.cloudcomputing.company.common.domain.Core;
import com.cloudcomputing.company.company.infra.http.response.CompanyResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends Core {
    @Column(nullable = false, length = 24)
    private String name;

    @Column(nullable = true, length = 36)
    private String homepage;

    @Column(nullable = false, length = 36)
    private String location;

    @Column(nullable = true)
    private Short foundation;

   @ColumnDefault("0.0")
    private Float star;

   public CompanyResponse toResponse(){
       return CompanyResponse.builder()
               .company(this)
               .build();
   }
}
