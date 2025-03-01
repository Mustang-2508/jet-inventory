package com.jet.jetInventory.service;

import com.jet.jetInventory.dto.CompanyDto;
import com.jet.jetInventory.dto.MultiroleFighterDto;
import com.jet.jetInventory.model.Company;
import com.jet.jetInventory.repository.CompanyRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CompanyService {

    private static  final ModelMapper modelMapper = new ModelMapper();
    private  final CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo){
        this.companyRepo = companyRepo;
    }


    public CompanyDto saveCompany(CompanyDto dto){

        if (dto == null){
            throw new IllegalArgumentException("Company cannot be null..!");
        }

        Company company = toEntity(dto);
        Company savedCompany = companyRepo.save(company);

        return toDto(savedCompany);
    }


    public List<CompanyDto> getAllCompanies(){
        return companyRepo.findAll().stream().map(CompanyService::toDto).collect(Collectors.toList());
    }


    public CompanyDto updateCompany(CompanyDto dto){

        if (dto.getId() == null){
            throw new IllegalArgumentException("Update operation requires an existing ID. ID is not present..!");
        }
        Company existingCompany = companyRepo.findById(dto.getId()).orElseThrow(() -> new EntityNotFoundException("Entity With Id " + dto.getId() + " Not Found..!"));

        Company company = toEntity(dto);
        company.setId(existingCompany.getId());
        company.setCompanyName(existingCompany.getCompanyName());  //Will not allow to update Company Name;

        Company updatedCompany = companyRepo.save(company);

        return toDto(updatedCompany);
    }


    public void deleteCompany(CompanyDto dto){
        if(dto.getId() == null)
            throw new IllegalArgumentException("ID cannot be null for delete operation..!");

        if(!companyRepo.existsById(dto.getId()))
            throw new EntityNotFoundException("Product with ID " + dto.getId() + " does not exist.");

        companyRepo.deleteById(dto.getId());

    }




    public static CompanyDto toDto(Company entity){
        return modelMapper.map(entity, CompanyDto.class);
    }

    public static Company toEntity(CompanyDto dto){
        return modelMapper.map(dto, Company.class);
    }
}
