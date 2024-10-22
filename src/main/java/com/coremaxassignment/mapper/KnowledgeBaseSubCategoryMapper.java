package com.coremaxassignment.mapper;
import com.coremaxassignment.dao.KnowledgeBaseSubCategories;
import com.coremaxassignment.dto.KnowledgeBaseResponseDTO;
import com.coremaxassignment.dto.KnowledgeBaseSubCategoryCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseSubCategoryResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface KnowledgeBaseSubCategoryMapper {
    KnowledgeBaseSubCategoryMapper INSTANCE = Mappers.getMapper(KnowledgeBaseSubCategoryMapper.class);
    @Mapping(source = "knowledgeBaseCategories",target = "knowledgeBaseCategory")
    KnowledgeBaseSubCategoryResponseDTO toResponseDTO(KnowledgeBaseSubCategories knowledgeBaseSubCategories);
    KnowledgeBaseSubCategories toEntity(KnowledgeBaseSubCategoryCreateDTO dto);

    List<KnowledgeBaseSubCategoryResponseDTO> toResponseDTOs(List<KnowledgeBaseSubCategories> entities);



}
