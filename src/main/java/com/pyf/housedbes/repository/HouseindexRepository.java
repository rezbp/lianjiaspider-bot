package com.pyf.housedbes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pyf.housedbes.entity.Houseindex;

public interface HouseindexRepository extends JpaRepository<Houseindex, Long>, JpaSpecificationExecutor<Houseindex> {

}