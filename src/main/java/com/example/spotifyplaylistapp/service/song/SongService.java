package com.example.spotifyplaylistapp.service.song;

import com.example.spotifyplaylistapp.helper.LoggedUser;
import com.example.spotifyplaylistapp.model.SongAddModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public SongService(SongRepository songRepository, LoggedUser loggedUser, UserRepository userRepository, ModelMapper mapper) {
        this.songRepository = songRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    public void addSong(SongAddModel songAddModel) {
        Song song = this.mapper.map(songAddModel, Song.class);

        this.songRepository.saveAndFlush(song);



    }
}
