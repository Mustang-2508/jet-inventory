package com.jet.jetInventory.controller;

import com.jet.jetInventory.dto.FighterJetDto;
import com.jet.jetInventory.dto.InterceptorDto;
import com.jet.jetInventory.dto.MultiroleFighterDto;
import com.jet.jetInventory.service.FighterJetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fighter-jet")
public class FighterJetController {

    private final FighterJetService fighterJetService;

    @Autowired
    public FighterJetController(FighterJetService fighterJetService){
        this.fighterJetService = fighterJetService;
    }


    @PostMapping("/multirole")
    public ResponseEntity<MultiroleFighterDto> saveMultiroleFighter(@RequestBody MultiroleFighterDto multiroleFighterDto) {
        try {
            MultiroleFighterDto saveMultiRoleFighter = fighterJetService.saveMultiRoleFighter(multiroleFighterDto);
            return new ResponseEntity<>(saveMultiRoleFighter, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/interceptor")
    public ResponseEntity<InterceptorDto> saveInterceptor(@RequestBody InterceptorDto interceptorDto) {
        try {
            InterceptorDto saveInterceptor = fighterJetService.saveInterceptor(interceptorDto);
            return new ResponseEntity<>(saveInterceptor, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/multirole")
    public ResponseEntity<List<MultiroleFighterDto>> getMultiroleFighters() {
        try {
            List<MultiroleFighterDto> allMultiroleFighters = fighterJetService.getAllMultiroleFighters();
            return new ResponseEntity<>(allMultiroleFighters, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/interceptor")
    public ResponseEntity<List<InterceptorDto>> getIneterceptors() {
        try {
            List<InterceptorDto> allInterceptor = fighterJetService.getAllInterceptor();
            return new ResponseEntity<>(allInterceptor, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @PutMapping
    public ResponseEntity<FighterJetDto> updateCompany(@RequestParam("fighterJetId") Long fighterJetId, @RequestParam("companyId") Long companyId){

        try{
            FighterJetDto fighterJetDto = fighterJetService.updateCompany(fighterJetId, companyId);
            return new ResponseEntity<>(fighterJetDto, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<FighterJetDto> deleteJetById(@PathVariable Long id){
        try{
            fighterJetService.deleteFighter(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
