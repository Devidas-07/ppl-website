package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.PkrPlayers;

@Repository
public interface PkrRepository extends JpaRepository<PkrPlayers, Integer>{

}
