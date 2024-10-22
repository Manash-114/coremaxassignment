package com.coremaxassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeBaseUpdateDTO {
    private String name;
    private String description;
    private String fileLink;
}
