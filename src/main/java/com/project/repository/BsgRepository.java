package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.BsgPlayers;

@Repository
public interface BsgRepository extends JpaRepository<BsgPlayers, Integer>{

}
