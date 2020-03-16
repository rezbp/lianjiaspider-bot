package com.pyf.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pyf.house.entity.Houseindex;

public interface HouseindexRepository extends JpaRepository<Houseindex, Long>, JpaSpecificationExecutor<Houseindex> {

}