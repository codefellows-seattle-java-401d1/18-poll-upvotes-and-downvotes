package com.example.demo.repositories;

import com.example.demo.model.Votify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotifyRepository extends JpaRepository<Votify, Long> {
}
