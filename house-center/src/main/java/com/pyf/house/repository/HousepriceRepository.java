package com.pyf.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pyf.house.entity.Houseprice;

public interface HousepriceRepository extends JpaRepository<Houseprice, Long>, JpaSpecificationExecutor<Houseprice> {

}