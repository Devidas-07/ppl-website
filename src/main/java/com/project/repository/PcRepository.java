package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.PcPlayers;

@Repository
public interface PcRepository extends JpaRepository<PcPlayers, Integer>{

}
