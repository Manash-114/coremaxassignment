package com.coremaxassignment.service.impl;

import com.coremaxassignment.dao.KnowledgeBaseCategories;
import com.coremaxassignment.dao.KnowledgeBaseSubCategories;
import com.coremaxassignment.dto.KnowledgeBaseSubCategoryCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseSubCategoryResponseDTO;
import com.coremaxassignment.dto.KnowledgeBaseSubCategoryUpdateDTO;
import com.coremaxassignment.exceptions.ResourceNotFoundException;
import com.coremaxassignment.mapper.KnowledgeBaseSubCategoryMapper;
import com.coremaxassignment.repository.KnowledgeBaseCategoriesRepository;
import com.coremaxassignment.repository.KnowledgeBaseSubCategoriesRepository;
import com.coremaxassignment.service.KnowledgeBaseSubCategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class KnowledgeBaseSubCategoriesImpl implements KnowledgeBaseSubCategoriesService {

    private final KnowledgeBaseSubCategoriesRepository knowledgeBaseSubCategoriesRepository;
    private final KnowledgeBaseCategoriesRepository knowledgeBaseCategoriesRepository;
    private final KnowledgeBaseSubCategoryMapper mapper = KnowledgeBaseSubCategoryMapper.INSTANCE;

    @Override
    public KnowledgeBaseSubCategoryResponseDTO create(KnowledgeBaseSubCategoryCreateDTO request) {

        //find main category
        KnowledgeBaseCategories main = knowledgeBaseCategoriesRepository.findByIdAndActive(
                request.getKnowledgeBaseCategoryId(),true);
        if(main == null)
            throw new ResourceNotFoundException("KnowledgeBaseCategories not found with id = "+
                    request.getKnowledgeBaseCategoryId());

        KnowledgeBaseSubCategories entity = mapper.toEntity(request);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setKnowledgeBaseCategories(main);
        entity.setActive(true);
        KnowledgeBaseSubCategories save = knowledgeBaseSubCategoriesRepository.save(entity);
        return mapper.toResponseDTO(save);
    }

    @Override
    public KnowledgeBaseSubCategoryResponseDTO getSingle(BigInteger id) throws Exception{
        KnowledgeBaseSubCategories get = knowledgeBaseSubCategoriesRepository.findByIdAndActive(id, true);
        if(get == null)
            throw new ResourceNotFoundException("KnowledgeBaseSubCategory not found with id = "+id);

        return mapper.toResponseDTO(get);
    }

    @Override
    public List<KnowledgeBaseSubCategoryResponseDTO> getAll() {
        List<KnowledgeBaseSubCategories> all = knowledgeBaseSubCategoriesRepository.getAll();
        return mapper.toResponseDTOs(all);
    }

    @Override
    public List<KnowledgeBaseSubCategoryResponseDTO> getAllByMainCategoryId(BigInteger id) {
        //find main
        KnowledgeBaseCategories main = knowledgeBaseCategoriesRepository.findByIdAndActive(id,true);
        if(main == null)
            throw new ResourceNotFoundException("KnowledgeBaseCategories not found with id = "+id);

        //find according to main
        List<KnowledgeBaseSubCategories> byKnowledgeBaseCategories = knowledgeBaseSubCategoriesRepository.findByKnowledgeBaseCategories(main);
        return mapper.toResponseDTOs(byKnowledgeBaseCategories);
    }

    @Override
    public KnowledgeBaseSubCategoryResponseDTO update(BigInteger id, KnowledgeBaseSubCategoryUpdateDTO updateRequest) {

        //find main
        KnowledgeBaseCategories main = knowledgeBaseCategoriesRepository.findByIdAndActive(updateRequest.getKnowledgeBaseCategoryId(),true);
        if(main == null)
            throw new ResourceNotFoundException("KnowledgeBaseCategories not found with id = "+id);

        //find sub
        KnowledgeBaseSubCategories get = knowledgeBaseSubCategoriesRepository.findByIdAndActive(id, true);
        if(get == null)
            throw new ResourceNotFoundException("KnowledgeBaseSubCategory not found with id = "+id);


        if(!updateRequest.getDescription().isEmpty())
            get.setDescription(updateRequest.getDescription());
        if(!updateRequest.getSubCategory().isEmpty())
            get.setSubCategory(updateRequest.getSubCategory());

        if(updateRequest.getKnowledgeBaseCategoryId() != null){
            get.setKnowledgeBaseCategories(main);
        }


        get.setUpdatedAt(LocalDateTime.now());
        KnowledgeBaseSubCategories save = knowledgeBaseSubCategoriesRepository.save(get);
        return mapper.toResponseDTO(save);

    }


    @Override
    public KnowledgeBaseSubCategoryResponseDTO delete(BigInteger id) {
        KnowledgeBaseSubCategories get = knowledgeBaseSubCategoriesRepository.findByIdAndActive(id, true);
        if(get == null)
            throw new ResourceNotFoundException("KnowledgeBaseSubCategory not found with id = "+id);

        get.setActive(false);
        KnowledgeBaseSubCategories save = knowledgeBaseSubCategoriesRepository.save(get);
        return mapper.toResponseDTO(save);
    }



}
