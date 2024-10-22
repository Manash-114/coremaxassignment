package com.coremaxassignment.dao;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "KnowledgeBaseCategories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeBaseCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",columnDefinition = "BIGINT(20)")
    private BigInteger id;


    @Column(name = "CreatedAt",columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt",columnDefinition = "DATETIME")
    private LocalDateTime updatedAt;

    @Column(name = "Name",length = 256)
    private String name;

    @Column(name = "Active", columnDefinition = "TINYINT(1)")
    private Boolean active;

    @OneToMany(mappedBy = "knowledgeBaseCategories"
    ,cascade = CascadeType.ALL)
    private List<KnowledgeBaseSubCategories> knowledgeBaseSubCategoriesList;
}
