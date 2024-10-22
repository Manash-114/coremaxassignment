package com.coremaxassignment.service.impl;

import com.coremaxassignment.dao.KnowledgeBaseCategories;
import com.coremaxassignment.dto.KnowledgeBaseCategoryCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseCategoryResponseDTO;
import com.coremaxassignment.dto.KnowledgeBaseCategoryUpdateDTO;
import com.coremaxassignment.exceptions.ResourceNotFoundException;
import com.coremaxassignment.mapper.KnowledgeBaseCategoryMapper;
import com.coremaxassignment.repository.KnowledgeBaseCategoriesRepository;
import com.coremaxassignment.repository.KnowledgeBaseSubCategoriesRepository;
import com.coremaxassignment.service.KnowledgeBaseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KnowledgeBaseCategoryImpl implements KnowledgeBaseCategoryService {

    private final KnowledgeBaseCategoriesRepository knowledgeBaseCategoriesRepo;
    private final KnowledgeBaseSubCategoriesRepository knowledgeBaseSubCategoriesRepository;
    private final KnowledgeBaseCategoryMapper mapper = KnowledgeBaseCategoryMapper.INSTANCE;
    @Override
    public KnowledgeBaseCategoryResponseDTO create(KnowledgeBaseCategoryCreateDTO request) {
        //convert to Entity
        KnowledgeBaseCategories entity = mapper.toEntity(request);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setActive(true);

        KnowledgeBaseCategories save = knowledgeBaseCategoriesRepo.save(entity);
        return mapper.toResponseDTO(save);
    }

    @Override
    public KnowledgeBaseCategoryResponseDTO getSingle(BigInteger id) throws Exception{
        KnowledgeBaseCategories get = knowledgeBaseCategoriesRepo.findByIdAndActive(id,true);
        if(get == null)
            throw new ResourceNotFoundException("KnowledgeBaseCategories not found with id = "+id);
        return mapper.toResponseDTO(get);
    }

    @Override
    public List<KnowledgeBaseCategoryResponseDTO> getAll() {
        List<KnowledgeBaseCategories> all = knowledgeBaseCategoriesRepo.getAll();
        return mapper.toResponseDTOs(all);
    }

    @Override
    public KnowledgeBaseCategoryResponseDTO update(BigInteger id, KnowledgeBaseCategoryUpdateDTO updateData) throws Exception{
        KnowledgeBaseCategories get = knowledgeBaseCategoriesRepo.findByIdAndActive(id,true);
        if(get == null)
            throw new ResourceNotFoundException("KnowledgeBaseCategories not found with id = "+id);

        if(!updateData.getName().isEmpty()){
            get.setName(updateData.getName());
        }

        get.setUpdatedAt(LocalDateTime.now());
        KnowledgeBaseCategories save = knowledgeBaseCategoriesRepo.save(get);
        return mapper.toResponseDTO(save);

    }

    @Override
    public KnowledgeBaseCategoryResponseDTO delete(BigInteger id) throws Exception {
        KnowledgeBaseCategories get = knowledgeBaseCategoriesRepo.findByIdAndActive(id,true);
        if(get == null)
            throw new ResourceNotFoundException("KnowledgeBaseCategories not found with id = "+id);

        get.setActive(false);
        //set all related subCategories to false
        knowledgeBaseSubCategoriesRepository.deactivateAllSubCategoriesByCategory(get);
        KnowledgeBaseCategories save = knowledgeBaseCategoriesRepo.save(get);
        return mapper.toResponseDTO(save);
    }
}
