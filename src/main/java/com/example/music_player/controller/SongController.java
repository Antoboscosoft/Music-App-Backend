package com.example.music_player.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.music_player.model.Song;
import com.example.music_player.service.SongService;

@RestController
@RequestMapping("/music")
public class SongController {

	@Autowired
	private SongService songService;
	
	@GetMapping
	public List<Song> getAllSongs() {
		return songService.getAllSongs();
	}
	
	@GetMapping("/getSongs")
	public String getSongs() {
		return "Song got successfully...";
	}
	
	
	@GetMapping("/{id}")
	public Optional<Song> getSongById(@PathVariable Long id){
		return songService.getSongById(id);
	}
	
	@PostMapping
	public Song addOrUpdateSong(@RequestBody Song song) {
		return songService.addOrUpdateSong(song);
	}
	
	@PostMapping("/addSong")
	public Song addSong(@RequestParam("songName") String songName, @RequestParam("songUpload") MultipartFile songUpload, @RequestParam("songImg") MultipartFile songImg, 
			@RequestParam(value = "title", required = false) String title, @RequestParam(value = "artist", required = false) String artist,
			@RequestParam(value = "duration", required = false) String duration) throws IOException {
		
		String songUploadPath = saveFile(songUpload);
		String songImgPath = saveFile(songImg);
		
		Song song = new Song();
		song.setSongName(songName);
		song.setSongUpload(songUploadPath);
		song.setSongImg(songImgPath);
		song.setTitle(title);
		song.setArtists(artist);
		song.setDuration(duration);
		
		return songService.addSong(song);
	}
	
	
	public Song updateSong(@RequestParam("id") Long id, @RequestParam("songName") String songName, @RequestParam("songUpload") MultipartFile songUpload,
            @RequestParam("songImg") MultipartFile songImg, @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "artist", required = false) String artist, @RequestParam(value = "duration", required = false) String duration) throws IOException {
		
		String songUploadPath = saveFile(songUpload); // Implement file saving logic
        String songImgPath = saveFile(songImg);
		
        Song song = songService.getAllSongs().stream().filter(s -> s.getId().equals(id)).findFirst().orElseThrow();
        song.setSongName(songName);
		song.setSongUpload(songUploadPath);
		song.setSongImg(songImgPath);
		song.setTitle(title);
		song.setArtists(artist);
		song.setDuration(duration);
        
		return songService.updateSong(song);
	}
	
	
	
	@DeleteMapping("/{id}")
	public void delteSong(@PathVariable Long id) {
		songService.deleteSong(id);
	}
	
	private String saveFile(MultipartFile file) throws IOException {
		return "";
	}
	
}
