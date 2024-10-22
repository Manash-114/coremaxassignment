package com.coremaxassignment.repository;

import com.coremaxassignment.dao.KnowledgeBase;
import com.coremaxassignment.dao.KnowledgeBaseCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface KnowledgeBaseRepository extends JpaRepository<KnowledgeBase, BigInteger> {


    KnowledgeBase findByIdAndActive(BigInteger id, Boolean active);

    @Query("SELECT k FROM KnowledgeBase k where k.active=true ")
    List<KnowledgeBase> getAll();
}
