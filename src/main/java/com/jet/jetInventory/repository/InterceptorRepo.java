package com.jet.jetInventory.repository;

import com.jet.jetInventory.model.Interceptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterceptorRepo extends JpaRepository<Interceptor, Long> {
}
