package com.srss_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srss_backend.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
