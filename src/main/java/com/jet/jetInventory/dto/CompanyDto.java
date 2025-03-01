package com.jet.jetInventory.dto;

import com.jet.jetInventory.model.FighterJet;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CompanyDto {

    private Long id;
    private String companyName;
    private Date foundedOn;
    private int version;
    private List<FighterJet> fighterJets;
}
