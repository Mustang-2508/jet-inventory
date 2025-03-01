package com.jet.jetInventory.dto;

import lombok.Data;

@Data
public class InterceptorDto extends FighterJetDto{

    private double climbRate;
    private int missileCount;

}
