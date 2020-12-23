package com.pyf.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pyf.house.entity.House;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long>, JpaSpecificationExecutor<House> {


    @Query(nativeQuery = true,value = " select * from house order by id limit ?1 offset ?2 ")
    List<House> findList(Long limit, Long offset);



}