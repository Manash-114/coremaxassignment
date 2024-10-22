package com.coremaxassignment.mapper;

import com.coremaxassignment.dao.KnowledgeBase;
import com.coremaxassignment.dto.KnowledgeBaseCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface KnowledgeBaseMapper {

    KnowledgeBaseMapper INSTANCE = Mappers.getMapper(KnowledgeBaseMapper.class);
    KnowledgeBase toEntity(KnowledgeBaseCreateDTO createDTO);
    @Mapping(source = "knowledgeBaseSubCategories.id",target = "knowledgeBaseSubCategoryId")
    KnowledgeBaseResponseDTO toResponseDTO(KnowledgeBase entity);
    List<KnowledgeBaseResponseDTO> toResponseDTOs(List<KnowledgeBase> entities);

}
