package com.coremaxassignment.dto;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KnowledgeBaseSubCategoryCreateDTO {
    private String subCategory;
    private String description;
    private BigInteger knowledgeBaseCategoryId;

}
