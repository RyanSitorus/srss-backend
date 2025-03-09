package com.srss.backend.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srss.backend.transaction.entity.Outpatient;

@Repository
public interface OutpatientRepository extends JpaRepository<Outpatient, Long> {

}
