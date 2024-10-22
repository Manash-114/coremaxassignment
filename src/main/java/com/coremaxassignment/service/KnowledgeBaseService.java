package com.coremaxassignment.service;

import com.coremaxassignment.dto.KnowledgeBaseCategoryResponseDTO;
import com.coremaxassignment.dto.KnowledgeBaseCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseResponseDTO;
import com.coremaxassignment.dto.KnowledgeBaseUpdateDTO;

import java.math.BigInteger;
import java.util.List;

public interface KnowledgeBaseService {
    KnowledgeBaseResponseDTO create(KnowledgeBaseCreateDTO request);
    List<KnowledgeBaseResponseDTO> getAll();
    KnowledgeBaseResponseDTO getSingle(BigInteger id);

    KnowledgeBaseResponseDTO update(BigInteger id , KnowledgeBaseUpdateDTO updateReq);
    KnowledgeBaseResponseDTO delete(BigInteger id);
}
