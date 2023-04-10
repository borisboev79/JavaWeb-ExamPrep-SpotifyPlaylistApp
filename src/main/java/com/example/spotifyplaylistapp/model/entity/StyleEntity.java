package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.Style;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "styles")
public class StyleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Style name;

    @Column(columnDefinition = "TEXT")
    private String description;

}
