package com.coremaxassignment.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KnowledgeBaseSubCategories")
public class KnowledgeBaseSubCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",columnDefinition = "BIGINT(20)")
    private BigInteger id;

    @Column(name = "CreatedAt", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", columnDefinition = "DATETIME")
    private LocalDateTime updatedAt;

    @Column(name = "SubCategory",length = 256)
    private String subCategory;

    @Column(name = "Description",length = 512)
    private String description;

    @Column(name = "Active" ,  columnDefinition = "TINYINT(1)")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "KnowledgeBaseCategoryId" , referencedColumnName = "id" , columnDefinition = "BIGINT(20)")

    private KnowledgeBaseCategories knowledgeBaseCategories;
}
