package com.torneo.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.torneo.futbol.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long>{
    
}
