package com.jet.jetInventory.dto;

import lombok.Data;

@Data
public class MultiroleFighterDto extends FighterJetDto {

    private boolean stealthCapacity;
    private int generation;
}
