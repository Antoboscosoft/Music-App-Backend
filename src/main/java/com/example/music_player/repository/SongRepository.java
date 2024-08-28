package com.example.music_player.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.music_player.model.Song;

public interface SongRepository extends JpaRepository<Song, Long>{

}
