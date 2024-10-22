package com.coremaxassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeBaseCreateDTO {
    private String name;
    private String description;
    private String fileLink;
    private BigInteger knowledgeBaseSubCategoryId;

}
