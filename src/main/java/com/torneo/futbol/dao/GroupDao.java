package com.torneo.futbol.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torneo.futbol.model.Group;

public interface GroupDao extends JpaRepository<Group, Long>{
    
}
