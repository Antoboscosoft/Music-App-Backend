package com.example.music_player.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String artists;
	private String duration;
	private String songName;
	private String songUpload; // URL or path to the uploaded file
	private String songImg; // URL or path to the uploaded image
	private String imageUrl;
	private String audioUrl;
	
}
