package com.sagar.memoryvault;

import com.sagar.memoryvault.controller.MemoryController;
import com.sagar.memoryvault.service.MemoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
public class MemoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MemoryService memoryService;

    @InjectMocks
    private MemoryController memoryController;


    private void mockAuthentication(String username) {
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn(username);

        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(userDetails);

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    public void testAddMemory() throws Exception {

        mockAuthentication("testUser");


        String memoryJson = "{ \"title\": \"Test Memory\", \"description\": \"Testing memory addition\", \"mood\": \"happy\", \"tags\": [\"test\"] }";


        mockMvc.perform(post("/api/memories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(memoryJson))
                .andExpect(status().isOk());


        verify(memoryService, times(1)).addMemory(any(org.openapitools.model.MemoryDTO.class), eq("testUser"));
    }

    @Test
    public void testDeleteMemory() throws Exception {

        mockAuthentication("testUser");


        mockMvc.perform(delete("/api/memories/{memoryId}", "memory123"))
                .andExpect(status().isOk());

        // Verify that the service method was called
        verify(memoryService, times(1)).deleteMemory(eq("memory123"), eq("testUser"));
    }

    @Test
    public void testGetMemories() throws Exception {

        mockAuthentication("testUser");


        mockMvc.perform(get("/api/memories"))
                .andExpect(status().isOk());



        verify(memoryService, times(1)).getAllMemory("testUser");
    }

    @Test
    public void testUpdateMemory() throws Exception {

        mockAuthentication("testUser");


        String memoryJson = "{ \"title\": \"Updated Memory\", \"description\": \"Updated description\", \"mood\": \"happy\", \"tags\": [\"update\"] }";

        mockMvc.perform(put("/api/memories/{memoryId}", "memory123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(memoryJson))
                .andExpect(status().isOk());


        verify(memoryService, times(1)).updateMemory(any(org.openapitools.model.MemoryDTO.class), eq("testUser"), eq("memory123"));
    }
}

