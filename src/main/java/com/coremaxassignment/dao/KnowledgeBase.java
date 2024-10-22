package com.coremaxassignment.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KnowledgeBase")
public class KnowledgeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "Id", columnDefinition = "BIGINT(20)")
    private BigInteger id;

    @Column(name = "CreatedAt", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt",columnDefinition = "DATETIME")
    private LocalDateTime updatedAt;

    @Column(name = "Name",length = 256)
    private String name;

    @Column(name = "Description",length = 512)
    private String description;

    @Column(name = "FileLink",length = 512)
    private String fileLink;

    @Column(name = "Active",columnDefinition = "TINYINT(1)")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "KnowledgeBaseSubCategoryId" , referencedColumnName = "id")
    private KnowledgeBaseSubCategories knowledgeBaseSubCategories;
}
