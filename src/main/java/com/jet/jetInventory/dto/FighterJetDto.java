package com.jet.jetInventory.dto;

import lombok.Data;


@Data
public class FighterJetDto {

    private Long id;
    private String model;
    private double maxSpeed;
    private int version;
    private CompanyDto manufacturedBy;


}
