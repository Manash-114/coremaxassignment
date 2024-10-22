package com.coremaxassignment.repository;

import com.coremaxassignment.dao.KnowledgeBaseCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface KnowledgeBaseCategoriesRepository extends JpaRepository<KnowledgeBaseCategories, BigInteger> {


    KnowledgeBaseCategories findByIdAndActive(BigInteger id,Boolean active);

    @Query("SELECT k FROM KnowledgeBaseCategories k where k.active=true ")
    List<KnowledgeBaseCategories> getAll();
}
