package com.example.spotifyplaylistapp.service.style;

import com.example.spotifyplaylistapp.init.DatabaseInitialization;
import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.Style;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleService implements DatabaseInitialization {

    private final StyleRepository styleRepository;

    @Autowired
    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @PostConstruct
    @Override
    public void dbInit() {
        if (!isDbInit()) {
            List<StyleEntity> styles = (List.of(

                    StyleEntity.builder().name(Style.POP).description("The most popular music style ever").build(),
                    StyleEntity.builder().name(Style.ROCK).description("The favourite style of boomers and genX").build(),
                    StyleEntity.builder().name(Style.JAZZ).description("The style of clever people").build()
            )
            );
            this.styleRepository.saveAllAndFlush(styles);

        }
    }

    @Override
    public boolean isDbInit() {
        return this.styleRepository.count() > 0;
    }
}
