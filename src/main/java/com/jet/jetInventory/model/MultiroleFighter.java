package com.jet.jetInventory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class MultiroleFighter extends FighterJet {
    private boolean stealthCapacity;
    private int generation;
}
