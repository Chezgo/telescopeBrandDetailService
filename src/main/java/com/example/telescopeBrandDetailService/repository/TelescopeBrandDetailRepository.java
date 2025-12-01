package com.example.telescopeBrandDetailService.repository;

import com.example.telescopeBrandDetailService.model.TelescopeBrandDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelescopeBrandDetailRepository extends JpaRepository<TelescopeBrandDetail, Long> {
    boolean existsByName(String name);
}
