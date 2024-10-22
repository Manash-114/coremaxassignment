package com.coremaxassignment.service.impl;


import com.coremaxassignment.dao.KnowledgeBase;
import com.coremaxassignment.dao.KnowledgeBaseCategories;
import com.coremaxassignment.dao.KnowledgeBaseSubCategories;
import com.coremaxassignment.dto.KnowledgeBaseCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseResponseDTO;
import com.coremaxassignment.dto.KnowledgeBaseUpdateDTO;
import com.coremaxassignment.exceptions.ResourceNotFoundException;
import com.coremaxassignment.mapper.KnowledgeBaseCategoryMapper;
import com.coremaxassignment.mapper.KnowledgeBaseMapper;
import com.coremaxassignment.repository.KnowledgeBaseCategoriesRepository;
import com.coremaxassignment.repository.KnowledgeBaseRepository;
import com.coremaxassignment.repository.KnowledgeBaseSubCategoriesRepository;
import com.coremaxassignment.service.KnowledgeBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KnowledgeBaseImpl implements KnowledgeBaseService {

    private final KnowledgeBaseRepository knowledgeBaseRepository;
    private final KnowledgeBaseCategoriesRepository knowledgeBaseCategoriesRepo;
    private final KnowledgeBaseSubCategoriesRepository knowledgeBaseSubCategoriesRepo;
    private final KnowledgeBaseMapper mapper = KnowledgeBaseMapper.INSTANCE;
    @Override
    public KnowledgeBaseResponseDTO create(KnowledgeBaseCreateDTO request) {

        //find sub
        KnowledgeBaseSubCategories sub = knowledgeBaseSubCategoriesRepo.findByIdAndActive(request.getKnowledgeBaseSubCategoryId(), true);
        if(sub == null)
            throw new ResourceNotFoundException("KnowledgeBaseSubCategory not found with id = "+request.getKnowledgeBaseSubCategoryId());


        //to entity
        KnowledgeBase entity = mapper.toEntity(request);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setActive(true);
        entity.setKnowledgeBaseSubCategories(sub);
        KnowledgeBase save = knowledgeBaseRepository.save(entity);
        return mapper.toResponseDTO(save);
    }

    @Override
    public List<KnowledgeBaseResponseDTO> getAll() {
        List<KnowledgeBase> all = knowledgeBaseRepository.getAll();
        return mapper.toResponseDTOs(all);
    }

    @Override
    public KnowledgeBaseResponseDTO getSingle(BigInteger id) {

        KnowledgeBase get = knowledgeBaseRepository.findByIdAndActive(id,true);
        if(get == null)
            throw new ResourceNotFoundException("KnowledgeBase not found with id = "+id);

        return mapper.toResponseDTO(get);
    }

    @Override
    public KnowledgeBaseResponseDTO update(BigInteger id, KnowledgeBaseUpdateDTO updateReq) {
        KnowledgeBase get = knowledgeBaseRepository.findByIdAndActive(id,true);
        if(get == null)
            throw new ResourceNotFoundException("KnowledgeBase not found with id = "+id);

        if(!updateReq.getName().isEmpty()){
            get.setName(updateReq.getName());
        }
        if(!updateReq.getDescription().isEmpty()){
            get.setDescription(updateReq.getDescription());
        }

        if(!updateReq.getFileLink().isEmpty()){
            get.setFileLink(updateReq.getFileLink());
        }

        KnowledgeBase save = knowledgeBaseRepository.save(get);
        return mapper.toResponseDTO(save);

    }

    @Override
    public KnowledgeBaseResponseDTO delete(BigInteger id) {
        KnowledgeBase get = knowledgeBaseRepository.findByIdAndActive(id,true);
        if(get == null)
            throw new ResourceNotFoundException("KnowledgeBase not found with id = "+id);
        get.setActive(false);
        knowledgeBaseRepository.save(get);
        return mapper.toResponseDTO(get);
    }
}
