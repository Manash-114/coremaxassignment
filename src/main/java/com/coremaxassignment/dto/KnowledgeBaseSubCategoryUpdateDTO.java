package com.coremaxassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeBaseSubCategoryUpdateDTO {
    private String subCategory;
    private String description;
    private BigInteger knowledgeBaseCategoryId;
}
