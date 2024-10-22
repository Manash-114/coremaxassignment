package com.coremaxassignment.dto;

import com.coremaxassignment.dao.KnowledgeBaseCategories;
import com.coremaxassignment.dao.KnowledgeBaseSubCategories;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeBaseResponseDTO {
    private BigInteger id;
    private String name;
    private String description;
    private String fileLink;
    private BigInteger knowledgeBaseSubCategoryId;
}
