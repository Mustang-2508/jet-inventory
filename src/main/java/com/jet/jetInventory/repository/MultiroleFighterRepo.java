package com.jet.jetInventory.repository;


import com.jet.jetInventory.model.MultiroleFighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiroleFighterRepo extends JpaRepository<MultiroleFighter, Long> {
}
