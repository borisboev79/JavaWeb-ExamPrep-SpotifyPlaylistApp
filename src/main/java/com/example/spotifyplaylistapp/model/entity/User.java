package com.example.spotifyplaylistapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

   /* @OneToMany
    (mappedBy = "seller", targetEntity = Offer.class)
    @Fetch(FetchMode.JOIN)
    private List<Offer> offers;

    @OneToMany
    (mappedBy = "buyer", targetEntity = Offer.class)
    @Fetch(FetchMode.JOIN)
    private List<Offer> boughtOffers;*/


}
