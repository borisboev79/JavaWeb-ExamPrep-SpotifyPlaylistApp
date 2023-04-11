package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.SongAddModel;
import com.example.spotifyplaylistapp.service.song.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }


    @ModelAttribute(name = "songAddModel")
    private SongAddModel songAddModel(){
        return new SongAddModel();
    }

    @GetMapping("/add")
    public String getAddSong(){
        return "song-add";
    }

    @PostMapping("/add")
    public String addSong(@Valid @ModelAttribute(name = "songAddModel") SongAddModel songAddModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("songAddModel", songAddModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.songAddModel", bindingResult);

            return "redirect:/songs/add";
        }

        this.songService.addSong(songAddModel);

        return "redirect:/home";
    }

}
