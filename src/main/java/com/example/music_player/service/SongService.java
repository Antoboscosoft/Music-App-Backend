package com.example.music_player.service;

import java.util.List;
import java.util.Optional;

import com.example.music_player.model.Song;

public interface SongService {

	List<Song> getAllSongs();

	Optional<Song> getSongById(Long id);

	void deleteSong(Long id);

	Song addOrUpdateSong(Song song);

	Song addSong(Song song);
	Song updateSong(Song song);
	
}
