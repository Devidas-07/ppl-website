package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.HkPlayers;

@Repository
public interface HkRepository extends JpaRepository<HkPlayers, Integer>{

}
