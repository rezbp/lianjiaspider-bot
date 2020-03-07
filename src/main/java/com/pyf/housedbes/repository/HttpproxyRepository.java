package com.pyf.housedbes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pyf.housedbes.entity.Httpproxy;

public interface HttpproxyRepository extends JpaRepository<Httpproxy, Integer>, JpaSpecificationExecutor<Httpproxy> {

}