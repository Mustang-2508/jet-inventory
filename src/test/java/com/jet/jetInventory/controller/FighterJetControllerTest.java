package com.jet.jetInventory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jet.jetInventory.dto.CompanyDto;

import com.jet.jetInventory.dto.InterceptorDto;
import com.jet.jetInventory.service.FighterJetService;
import com.jet.jetInventory.service.FighterJetServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FighterJetController.class)
public class FighterJetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FighterJetService fighterJetService;

    @InjectMocks
    private FighterJetController fighterJetController;

    private InterceptorDto interceptorDto;
    private CompanyDto companyDto;

    @BeforeEach
    public void setUp() {
        companyDto = new CompanyDto();
        companyDto.setId(1L);
        companyDto.setCompanyName("Lockheed Martin");

        interceptorDto = new InterceptorDto();
        interceptorDto.setId(1L);
        interceptorDto.setModel("F-22 Raptor");
        interceptorDto.setManufacturedBy(companyDto);
    }

    @Test
    public void testSaveInterceptor() throws Exception{
        Mockito.when(fighterJetService.saveInterceptor(Mockito.any(InterceptorDto.class)))
                .thenReturn(interceptorDto);

        mockMvc.perform(post("/fighter-jet/interceptor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(interceptorDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.model").value("F-22 Raptor"));;

    }

}
