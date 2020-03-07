package com.pyf.housedbes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pyf.housedbes.entity.Process;

public interface ProcessRepository extends JpaRepository<Process, Integer>, JpaSpecificationExecutor<Process> {

}