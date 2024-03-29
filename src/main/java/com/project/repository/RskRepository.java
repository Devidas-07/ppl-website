package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.RskPlayers;

@Repository
public interface RskRepository extends JpaRepository<RskPlayers, Integer>{

}
