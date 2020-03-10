package com.pyf.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pyf.house.entity.House;

public interface HouseRepository extends JpaRepository<House, Long>, JpaSpecificationExecutor<House> {



}