package com.pyf.housedbes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pyf.housedbes.entity.House;

public interface HouseRepository extends JpaRepository<House, Long>, JpaSpecificationExecutor<House> {



}