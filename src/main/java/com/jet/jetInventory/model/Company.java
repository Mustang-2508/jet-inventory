package com.jet.jetInventory.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Company Name can't be null..!")
    private String companyName;
    private Date foundedOn;

    @Version
    private int version;

    @OneToMany(mappedBy = "manufacturedBy")
    private List<FighterJet> fighterJets;

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
