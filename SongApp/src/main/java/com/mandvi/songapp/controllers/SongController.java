package com.mandvi.songapp.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mandvi.songapp.models.Song;
import com.mandvi.songapp.models.User;
import com.mandvi.songapp.services.SongService;
import com.mandvi.songapp.services.UserService;

@Controller
public class SongController {
	@Autowired
	private UserService userServ;
	@Autowired
	private SongService songServ;

	@GetMapping("/home")
	public String index(Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		// get the songs
		List<Song> allDaSongs = songServ.allSongs();
		model.addAttribute("allDaSongs", allDaSongs);
		User thisLoggedInUser = userServ.findOne(userId);
		model.addAttribute("thisLoggedInUser", thisLoggedInUser);

		return "dashboard.jsp";
	}

	// CREATE PAGE
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		User thisUser = userServ.findOne(userId);
		model.addAttribute("thisUser", thisUser);
		return "createSong.jsp";
	}

	// CREATE METHOD - REDIRECT
	@PostMapping("/songs")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result, RedirectAttributes flash,
			Model model, HttpSession session) {
		songServ.createSong(song,result);
		if (result.hasErrors()) {
			return "createSong.jsp";
		} else {
          
			return "redirect:/home";
		}

	}

	// RENDER EDIT PAGE
	@GetMapping("songs/{id}/edit")
	public String updatePage(@PathVariable("id") Long id, Model model,HttpSession session) {
//			System.out.println(id);
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		User thisUser = userServ.findOne(userId);
		model.addAttribute("thisUser", thisUser);
		Song song = songServ.findSong(id);
		String songLyrics = song.getLyrics();
		song.setLyrics("");
		model.addAttribute("song", song);
		model.addAttribute("songLyrics", songLyrics);
		return "editSong.jsp";
	}

	// FORM EDIT METHOD
	// must provide {id} as variable name
	@RequestMapping(value = "/songs/{id}/edit", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("song") Song song, BindingResult result,
			@PathVariable("id") Long songId, HttpSession session, Model model) {
		if (result.hasErrors()) {
			Long userId = (Long) session.getAttribute("user_id");
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			Song thisSong = songServ.findSong(songId);
			String songLyrics = thisSong.getLyrics();
//			thisSong.setLyrics("");
//			model.addAttribute("song",thisSong);
			model.addAttribute("songLyrics", songLyrics);
			return "editSong.jsp";
		} else {
			//1. grab the current user logged in from session
			 Long userId = (Long)session.getAttribute("user_id");
			 //2. find the user from the db using the id
			 User thisLoggedInUser = userServ.findOne(userId);
			 Song thisSong = songServ.findSong(songId);
			 List<User> collabs = thisSong.getCollabs();
			 if (!collabs.contains(thisLoggedInUser))  {
				 collabs.add(thisLoggedInUser);
			 }
			 String newUpdatedLyrics = thisSong.getLyrics() + song.getLyrics();
			 song.setLyrics(newUpdatedLyrics);
			 song.setCollabs(collabs);
			
			songServ.updateSong(song);
			return "redirect:/home";
		}
	}

	// DELETE using form in index.jsp
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		songServ.deleteSong(id);
		return "redirect:/home";
	}

	// SHOW ONE
	@GetMapping("/songs/{id}")
	public String showOne(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		 
		Song thisSong = songServ.findSong(id);
		model.addAttribute("thisSong", thisSong);
		return "showOne.jsp";
	}

}
