package com.jet.jetInventory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Interceptor extends FighterJet{

    private double climbRate;
    private int missileCount;

}
