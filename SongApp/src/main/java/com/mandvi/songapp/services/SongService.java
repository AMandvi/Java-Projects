package com.mandvi.songapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mandvi.songapp.models.Song;
import com.mandvi.songapp.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository songRepo;

	// ======FULL CRUD ======

	// READ ALL
	public List<Song> allSongs() {
		return songRepo.findAll();
	}

	// CREATE
	public Song createSong(Song song, BindingResult result) {
		Optional<Song> toCreateSong = songRepo.findByTitle(song.getTitle());
		if (toCreateSong.isPresent()) {
			result.rejectValue("title", "create song error", "Song title already exists");
		}
		if (result.hasErrors()) {
			return null;
		}
		return songRepo.save(song);
	}

	// READ ONE
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);

		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Song updateSong(Song s) {
		Song updateSong = songRepo.save(s);
		return updateSong;
	}

	// DELETE //deleteById returns void thats why void method
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}

}
