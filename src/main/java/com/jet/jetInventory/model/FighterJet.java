package com.jet.jetInventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class FighterJet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Fighter Jet Model can't be null..!")
    private String model;

    private double maxSpeed;

    @Version
    private int version;

    @ManyToOne
    @JsonIgnore
    private Company manufacturedBy;

    private Date createdOn;

    private Date modifiedOn;

    @PrePersist
    protected void prePersist(){
        setCreatedOn(new Date());
    }

    @PreUpdate
    protected  void preUpdate(){
        setModifiedOn(new Date());
    }


}
