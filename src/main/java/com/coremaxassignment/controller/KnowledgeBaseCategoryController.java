package com.coremaxassignment.controller;

import com.coremaxassignment.dto.KnowledgeBaseCategoryCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseCategoryUpdateDTO;
import com.coremaxassignment.service.KnowledgeBaseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/knowledgeBaseCategory")
public class KnowledgeBaseCategoryController {

    private final KnowledgeBaseCategoryService knowledgeBaseCategoryService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody KnowledgeBaseCategoryCreateDTO request){
        return new ResponseEntity<>(knowledgeBaseCategoryService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(knowledgeBaseCategoryService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable BigInteger id, @RequestBody KnowledgeBaseCategoryUpdateDTO updateRequest) throws Exception{
        return new ResponseEntity<>(knowledgeBaseCategoryService.update(id,updateRequest),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingle(@PathVariable BigInteger id) throws Exception{
        return new ResponseEntity<>(knowledgeBaseCategoryService.getSingle(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable BigInteger id) throws Exception{
        return new ResponseEntity<>(knowledgeBaseCategoryService.delete(id),HttpStatus.OK);
    }


}
