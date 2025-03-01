package com.jet.jetInventory.service;

import com.jet.jetInventory.dto.CompanyDto;
import com.jet.jetInventory.dto.MultiroleFighterDto;
import com.jet.jetInventory.model.Company;
import com.jet.jetInventory.model.MultiroleFighter;
import com.jet.jetInventory.repository.CompanyRepo;
import com.jet.jetInventory.repository.FighterJetRepo;
import com.jet.jetInventory.repository.MultiroleFighterRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import javax.validation.ConstraintViolationException;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FighterJetServiceTest {

    @Mock
    private FighterJetRepo fighterJetRepo;

    @Mock
    private CompanyRepo companyRepo;

    @Mock
    private MultiroleFighterRepo multiroleFighterRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private FighterJetService fighterJetService;


    private MultiroleFighterDto multiroleFighterDto;
    private MultiroleFighter multiroleFighter;
    private CompanyDto companyDto;
    private Company company;


    @BeforeEach
    public void setUp() {
        companyDto = new CompanyDto();
        companyDto.setId(1L);
        companyDto.setCompanyName("Lockheed Martin");
        company = new Company();
        company.setId(1L);
        company.setCompanyName("Lockheed Martin");

        multiroleFighterDto = new MultiroleFighterDto();
        multiroleFighterDto.setId(1L);
        multiroleFighterDto.setModel("F-22 Raptor");
        multiroleFighterDto.setManufacturedBy(companyDto);
        multiroleFighter = new MultiroleFighter();
        multiroleFighter.setId(1L);
        multiroleFighter.setModel("F-22 Raptor");
        multiroleFighter.setManufacturedBy(company);
    }

    @Test
    void testSaveMultiroleFighter() {

        Mockito.when(multiroleFighterRepo.save(multiroleFighter)).thenReturn(multiroleFighter);

        MultiroleFighterDto result = fighterJetService.saveMultiRoleFighter(multiroleFighterDto);

        assertNotNull(result);
        assertEquals("F-22 Raptor", result.getModel());
    }

    @Test
    void testDtoNotNullCheck() {
        multiroleFighterDto = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fighterJetService.saveMultiRoleFighter(multiroleFighterDto);
        });

    }

}
