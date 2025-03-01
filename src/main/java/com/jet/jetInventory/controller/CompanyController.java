package com.jet.jetInventory.controller;

import com.jet.jetInventory.dto.CompanyDto;
import com.jet.jetInventory.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDto> saveCompany(@RequestBody CompanyDto companyDto) {
        try {
            CompanyDto savedComapny = companyService.saveCompany(companyDto);
            return new ResponseEntity<>(savedComapny, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllComapanies() {
        try {
            List<CompanyDto> allInterceptor = companyService.getAllCompanies();
            return new ResponseEntity<>(allInterceptor, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyDto companyDto) {
        try {
            CompanyDto savedComapny = companyService.updateCompany(companyDto);
            return new ResponseEntity<>(savedComapny, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping
    public ResponseEntity<CompanyDto> deleteCompany(@RequestBody CompanyDto companyDto) {
            companyService.deleteCompany(companyDto);
            return ResponseEntity.noContent().build();

    }

}
