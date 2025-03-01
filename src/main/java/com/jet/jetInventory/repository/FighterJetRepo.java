package com.jet.jetInventory.repository;

import com.jet.jetInventory.model.FighterJet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FighterJetRepo extends JpaRepository<FighterJet, Long> {
}
