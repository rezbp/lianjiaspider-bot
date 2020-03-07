package com.pyf.housedbes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pyf.housedbes.entity.Area;

public interface AreaRepository extends JpaRepository<Area, Integer>, JpaSpecificationExecutor<Area> {

}