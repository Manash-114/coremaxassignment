package com.coremaxassignment.service;

import com.coremaxassignment.dto.KnowledgeBaseSubCategoryCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseSubCategoryResponseDTO;
import com.coremaxassignment.dto.KnowledgeBaseSubCategoryUpdateDTO;

import java.math.BigInteger;
import java.util.List;

public interface KnowledgeBaseSubCategoriesService {

    KnowledgeBaseSubCategoryResponseDTO create(KnowledgeBaseSubCategoryCreateDTO request);
    KnowledgeBaseSubCategoryResponseDTO getSingle(BigInteger id) throws Exception;
    List<KnowledgeBaseSubCategoryResponseDTO> getAll();
    List<KnowledgeBaseSubCategoryResponseDTO> getAllByMainCategoryId(BigInteger id) throws Exception;

    KnowledgeBaseSubCategoryResponseDTO update(BigInteger id, KnowledgeBaseSubCategoryUpdateDTO updateRequest) throws Exception;

    KnowledgeBaseSubCategoryResponseDTO delete(BigInteger id) throws Exception;
}
