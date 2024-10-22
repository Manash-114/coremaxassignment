package com.coremaxassignment.controller;

import com.coremaxassignment.dto.KnowledgeBaseCreateDTO;
import com.coremaxassignment.dto.KnowledgeBaseUpdateDTO;
import com.coremaxassignment.service.KnowledgeBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/knowledgeBase")
@RequiredArgsConstructor
public class KnowledgeBaseController {

    private final KnowledgeBaseService knowledgeBaseService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody KnowledgeBaseCreateDTO createDTO){
        return new ResponseEntity<>(knowledgeBaseService.create(createDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable BigInteger id, @RequestBody KnowledgeBaseUpdateDTO updateDTO){
        return new ResponseEntity<>(knowledgeBaseService.update(id,updateDTO),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(knowledgeBaseService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingle(@PathVariable BigInteger id){
        return new ResponseEntity<>(knowledgeBaseService.getSingle(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable BigInteger id){
        return new ResponseEntity<>(knowledgeBaseService.delete(id),HttpStatus.OK);
    }


}
