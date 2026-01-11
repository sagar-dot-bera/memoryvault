package com.sagar.memoryvault.service;

import com.sagar.memoryvault.entity.Image;
import com.sagar.memoryvault.entity.Memory;
import com.sagar.memoryvault.entity.User;
import com.sagar.memoryvault.exception.MemoryException;
import com.sagar.memoryvault.repository.MemoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class MemoryService {
    private final MemoryRepository memoryRepository;
    private final UserService userService;

    public MemoryService(MemoryRepository memoryRepository, UserService userService) {
        this.memoryRepository = memoryRepository;
        this.userService = userService;
    }

    public  Memory addMemory(org.openapitools.model.MemoryDTO memory, String userId){
        Memory memoryEntity = new Memory();
        memoryEntity.setDescription(memory.getDescription());
        memoryEntity.setTitle(memory.getTitle());
        memoryEntity.setUser(userService.getUserById(userId));
        memoryEntity.setTags(memory.getTags());
        return memoryRepository.save(memoryEntity);
    }

    public void updateMemory(org.openapitools.model.MemoryDTO updatedMemory, String memoryId, String userId){
        Memory memoryToUpdate = getMemory(memoryId);

        if(memoryToUpdate.getUser().getId().equals(userId)){
            memoryToUpdate.setTitle(updatedMemory.getTitle());
            memoryToUpdate.setDescription(updatedMemory.getDescription());
            memoryToUpdate.setTags(updatedMemory.getTags());
            memoryRepository.save(memoryToUpdate);
        } else {
            throw new MemoryException(403, HttpStatus.UNAUTHORIZED,"Memory with id: "+memoryId+" does not belong to this User");
        }

    }

    public void deleteMemory(String memoryId, String userId){
        Memory memoryToUpdate = getMemory(memoryId);

        if(memoryToUpdate.getUser().getId().toString().equals(userId)){
            memoryRepository.delete(memoryToUpdate);
        } else {
            throw  new MemoryException(403,HttpStatus.UNAUTHORIZED,"Memory with id: "+memoryId+" does not belong to this User");
        }
    }

    public Memory getMemory(String memoryId){
        return memoryRepository.findMemoryById(UUID.fromString(memoryId)).orElseThrow(
                () -> new MemoryException(404, HttpStatus.NOT_FOUND,"Memory with id: "+memoryId+" not found")
        );
    }

    public List<org.openapitools.model.MemoryDTO> getAllMemory(String userId){
        User user = userService.getUserById(userId);
        List<Memory> memories = memoryRepository.findAllByUser(user);
        List<org.openapitools.model.MemoryDTO> memoryDTOs = new ArrayList<>();
        for(Memory memory : memories){
            memoryDTOs.add(createMemoryDTO(memory));
        }

        return memoryDTOs;

    }


    public org.openapitools.model.MemoryDTO createMemoryDTO(Memory  memory) {
        org.openapitools.model.MemoryDTO memoryDTO  = new org.openapitools.model.MemoryDTO();
        memoryDTO.setTags(memory.getTags());
        memoryDTO.setTitle(memory.getTitle());
        memoryDTO.setDescription(memory.getDescription());
        memoryDTO.setMood(Memory.moodMapper(memory.getMood()));
        return memoryDTO;
    }


}
