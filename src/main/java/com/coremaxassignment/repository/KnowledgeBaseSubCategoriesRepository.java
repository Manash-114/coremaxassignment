package com.coremaxassignment.repository;

import com.coremaxassignment.dao.KnowledgeBaseCategories;
import com.coremaxassignment.dao.KnowledgeBaseSubCategories;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface KnowledgeBaseSubCategoriesRepository extends JpaRepository<KnowledgeBaseSubCategories, BigInteger> {
    List<KnowledgeBaseSubCategories> findByKnowledgeBaseCategories(KnowledgeBaseCategories knowledgeBaseCategories);
    KnowledgeBaseSubCategories findByIdAndActive(BigInteger id,Boolean active);
    @Query("select a from KnowledgeBaseSubCategories a where a.active=true ")
    List<KnowledgeBaseSubCategories> getAll();

    @Transactional
    @Modifying
    @Query("UPDATE KnowledgeBaseSubCategories ksc SET ksc.active = false WHERE ksc.knowledgeBaseCategories = :knowledgeBaseCategories")
    void deactivateAllSubCategoriesByCategory(@Param("knowledgeBaseCategories") KnowledgeBaseCategories knowledgeBaseCategories);
}
