package com.example.music_player.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music_player.model.Song;
import com.example.music_player.repository.SongRepository;
import com.example.music_player.service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private SongRepository songRepository;

	@Override
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}

	@Override
	public Optional<Song> getSongById(Long id) {
		return songRepository.findById(id);
	}

	@Override
	public Song addOrUpdateSong(Song song) {
		return songRepository.saveAndFlush(song);
	}
	
	@Override
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}

	@Override
	public Song addSong(Song song) {
		// TODO Auto-generated method stub
		return songRepository.save(song);
	}

	@Override
	public Song updateSong(Song song) {
		// TODO Auto-generated method stub
		return songRepository.saveAndFlush(song);
	}
}
