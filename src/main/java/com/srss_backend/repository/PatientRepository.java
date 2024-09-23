package com.srss_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srss_backend.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}