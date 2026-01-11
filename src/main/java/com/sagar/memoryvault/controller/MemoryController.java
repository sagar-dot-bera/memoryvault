package com.sagar.memoryvault.controller;

import com.sagar.memoryvault.entity.Memory;
import com.sagar.memoryvault.exception.MemoryException;
import com.sagar.memoryvault.service.MemoryService;
import org.openapitools.api.MemoryApi;

import org.openapitools.model.MemoryDTO;
import org.openapitools.model.Mood;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Controller
public class MemoryController implements org.openapitools.api.MemoryApi {

    public final MemoryService memoryService;

    public MemoryController(MemoryService memoryService) {
        this.memoryService = memoryService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return MemoryApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> addMemory(MemoryDTO memoryDTO) {

        memoryService.addMemory(memoryDTO,getUser().getUsername());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMemories(String memoryId) {
        memoryService.deleteMemory(memoryId,getUser().getUsername());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<MemoryDTO>> getMemories() {
        List<MemoryDTO> memoryDTOS = memoryService.getAllMemory(getUser().getUsername());
        return ResponseEntity.ok(memoryDTOS);
    }

    @Override
    public ResponseEntity<Void> updateMemory(String memoryId, MemoryDTO memoryDTO) {
        memoryService.updateMemory(memoryDTO,getUser().getUsername(),memoryId);

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(MemoryException.class)
    public ResponseEntity<org.openapitools.model.ErrorResponse> handleMemoryNotFound(MemoryException ex) {
        org.openapitools.model.ErrorResponse error = new org.openapitools.model.ErrorResponse(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    public UserDetails getUser() {
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();
        assert auth != null;
        return (UserDetails) auth.getPrincipal();
    }
}
