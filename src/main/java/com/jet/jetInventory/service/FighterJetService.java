package com.jet.jetInventory.service;

import com.jet.jetInventory.dto.FighterJetDto;
import com.jet.jetInventory.dto.InterceptorDto;
import com.jet.jetInventory.dto.MultiroleFighterDto;
import com.jet.jetInventory.model.*;
import com.jet.jetInventory.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FighterJetService {

    private static final ModelMapper modelMapper = new ModelMapper();
    private final FighterJetRepo fighterJetRepo;
    private final CompanyRepo companyRepo;

    private final MultiroleFighterRepo multiroleFighterRepo;
    private final InterceptorRepo interceptorRepo;

    @Autowired
    public FighterJetService(FighterJetRepo fighterJetRepo, MultiroleFighterRepo multiroleFighterRepo,InterceptorRepo interceptorRepo,CompanyRepo companyRepo ){
        this.fighterJetRepo = fighterJetRepo;
        this.multiroleFighterRepo = multiroleFighterRepo;
        this.interceptorRepo = interceptorRepo;
        this.companyRepo = companyRepo;

    }


    public MultiroleFighterDto saveMultiRoleFighter(MultiroleFighterDto dto){
        if (dto == null){
            throw new IllegalArgumentException("Multi role Fighter cannot be null..!");
        }
        MultiroleFighter multiroleFighter = toEntity(dto);
        MultiroleFighter savedMultiroleFighter = multiroleFighterRepo.save(multiroleFighter);
        return toDto(savedMultiroleFighter);
    }

    public InterceptorDto saveInterceptor(InterceptorDto dto){
        if (dto == null){
            throw new IllegalArgumentException("Interceptor cannot be null..!");
        }
        Interceptor interceptor = toEntity(dto);
        Interceptor savedinterceptor = interceptorRepo.save(interceptor);
        return toDto(savedinterceptor);
    }


    public List<MultiroleFighterDto> getAllMultiroleFighters(){
        return multiroleFighterRepo.findAll().stream().map(FighterJetService::toDto).collect(Collectors.toList());
    }

    public List<InterceptorDto> getAllInterceptor(){
        return interceptorRepo.findAll().stream().map(FighterJetService::toDto).collect(Collectors.toList());
    }


    public FighterJetDto updateCompany(Long fighterJetId, Long companyId){
        if(fighterJetId == null || companyId ==null){
            throw new IllegalArgumentException("Update operation requires an existing ID. ID is not present..!");
        }

        FighterJet existingFighterJet = fighterJetRepo.findById(fighterJetId).orElseThrow(()-> new EntityNotFoundException("Entity with id "+fighterJetId+" not present..!"));
        Company existingCompany = companyRepo.findById(companyId).orElseThrow(()-> new EntityNotFoundException("Entity with id "+companyId+" not present..!"));

        existingFighterJet.setManufacturedBy(existingCompany);
        FighterJet save = fighterJetRepo.save(existingFighterJet);
        return toDto(save);
    }


    public void deleteFighter(Long id){
        if (id == null){
            throw new IllegalArgumentException("Empty id received..!");
        }
        FighterJet fighterJet = fighterJetRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Specified entity not found..!"));

        fighterJetRepo.deleteById(fighterJet.getId());

    }



    public static FighterJetDto toDto(FighterJet entity){
        return modelMapper.map(entity, FighterJetDto.class);
    }
    public static MultiroleFighterDto toDto(MultiroleFighter entity){
        return modelMapper.map(entity, MultiroleFighterDto.class);
    }
    public static InterceptorDto toDto(Interceptor entity){
        return modelMapper.map(entity, InterceptorDto.class);
    }


    public static FighterJet toEntity(FighterJetDto dto){
        return modelMapper.map(dto, FighterJet.class);
    }
    public static MultiroleFighter toEntity(MultiroleFighterDto dto){
        return modelMapper.map(dto, MultiroleFighter.class);
    }
    public static Interceptor toEntity(InterceptorDto dto){
        return modelMapper.map(dto, Interceptor.class);
    }


}
