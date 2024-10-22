package com.coremaxassignment.controller;

import com.coremaxassignment.dto.KnowledgeBaseSubCategoryCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseSubCategoryUpdateDTO;
import com.coremaxassignment.service.KnowledgeBaseSubCategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/knowledgeBaseSubCategory")
public class KnowledgeBaseSubCategoryController {

    private final KnowledgeBaseSubCategoriesService knowledgeBaseSubCategoriesService;

    @PostMapping
    public ResponseEntity<?> addHandler(@RequestBody KnowledgeBaseSubCategoryCreateDTO request){
        return new ResponseEntity<>(knowledgeBaseSubCategoriesService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(knowledgeBaseSubCategoriesService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingle(@PathVariable BigInteger id) throws Exception{
        return new ResponseEntity<>(knowledgeBaseSubCategoriesService.getSingle(id),HttpStatus.OK);
    }

    @GetMapping("/mainCategory/{id}")
    public ResponseEntity<?> getAllByMain(@PathVariable BigInteger id) throws Exception{
        return new ResponseEntity<>(knowledgeBaseSubCategoriesService
                .getAllByMainCategoryId(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable BigInteger id , @RequestBody KnowledgeBaseSubCategoryUpdateDTO updateReq) throws Exception{
        return new ResponseEntity<>(knowledgeBaseSubCategoriesService
                .update(id,updateReq),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable BigInteger id) throws Exception{
        return new ResponseEntity<>(knowledgeBaseSubCategoriesService.delete(id),HttpStatus.OK);
    }

}
