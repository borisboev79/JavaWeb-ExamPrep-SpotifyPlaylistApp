package com.example.spotifyplaylistapp.controller;


import com.example.spotifyplaylistapp.helper.LoggedUser;
import com.example.spotifyplaylistapp.model.SongViewModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.service.song.SongService;
import com.example.spotifyplaylistapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class HomeController {
    private final LoggedUser loggedUser;
    private final SongService songService;
    private final UserService userService;


    @Autowired
    public HomeController(LoggedUser loggedUser,
                          SongService songService, UserService userService) {

        this.loggedUser = loggedUser;
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView model) {

        if(loggedUser.getId() == null) {
            model.setViewName("index");
            return model;
        }

        List<SongViewModel> songs = this.songService.getAllSongs();
        Set<Song> playlist = this.userService.getPlaylist(this.loggedUser.getId());

        model.addObject("songs", songs);
        model.addObject("playlist", playlist);
        model.addObject("totalMin", playlist.stream().mapToInt(Song::getDuration).sum());

        model.setViewName("home");

        return model;
    }

    @GetMapping("/user/add/{id}")
    public String buyOffer(@PathVariable Long id) {

        this.userService.addSongToPlaylist(id);

        return "redirect:/home";
    }

}
