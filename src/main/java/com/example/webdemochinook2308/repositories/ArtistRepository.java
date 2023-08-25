package com.example.webdemochinook2308.repositories;

import com.example.webdemochinook2308.data.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}