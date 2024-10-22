package com.coremaxassignment.mapper;
import com.coremaxassignment.dao.KnowledgeBaseCategories;
import com.coremaxassignment.dto.KnowledgeBaseCategoryCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseCategoryResponseDTO;
import com.coremaxassignment.dto.KnowledgeBaseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper
public interface KnowledgeBaseCategoryMapper {
    KnowledgeBaseCategoryMapper INSTANCE = Mappers.getMapper(KnowledgeBaseCategoryMapper.class);
    KnowledgeBaseCategories toEntity(KnowledgeBaseCategoryCreateDTO knowledgeBaseCategoryDto);
    KnowledgeBaseCategoryResponseDTO toResponseDTO(KnowledgeBaseCategories entity);
    List<KnowledgeBaseCategoryResponseDTO> toResponseDTOs(List<KnowledgeBaseCategories> entities);

}
