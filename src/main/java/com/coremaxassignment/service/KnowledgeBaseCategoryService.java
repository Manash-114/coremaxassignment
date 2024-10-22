package com.coremaxassignment.service;

import com.coremaxassignment.dto.KnowledgeBaseCategoryCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseCategoryResponseDTO;
import com.coremaxassignment.dto.KnowledgeBaseCategoryUpdateDTO;

import java.math.BigInteger;
import java.util.List;

public interface KnowledgeBaseCategoryService {
    KnowledgeBaseCategoryResponseDTO create(KnowledgeBaseCategoryCreateDTO request);
    KnowledgeBaseCategoryResponseDTO getSingle(BigInteger id) throws Exception;
    List<KnowledgeBaseCategoryResponseDTO> getAll();

    KnowledgeBaseCategoryResponseDTO update(BigInteger id, KnowledgeBaseCategoryUpdateDTO updateData) throws Exception;
    KnowledgeBaseCategoryResponseDTO delete(BigInteger id) throws Exception;


}
