package com.github.crmepham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.crmepham.model.Privilege;

@Repository
public interface IPrivilegeRepository extends JpaRepository<Privilege, Long> {}
