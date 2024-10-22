package com.coremaxassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigInteger;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeBaseSubCategoryResponseDTO {
    private BigInteger id;
    private String subCategory;
    private String description;
    private KnowledgeBaseCategoryResponseDTO knowledgeBaseCategory;
}
