package com.coremaxassignment.dto;

import lombok.*;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KnowledgeBaseCategoryResponseDTO {
    private BigInteger id;
    private String name;
}
