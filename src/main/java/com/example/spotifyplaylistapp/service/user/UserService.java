package com.example.spotifyplaylistapp.service.user;


import com.example.spotifyplaylistapp.helper.LoggedUser;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }


    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }


    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }


    /*public List<OfferViewModel> allBought() {
        User user = this.userRepository.findById(this.loggedUser.getId()).orElseThrow();
        return user.getBoughtOffers().stream().map(offer -> offerViewModelBuilder(offer, offer.getBuyer()
                        .getUsername()))
                .collect(Collectors.toList());
    }


    public List<OfferViewModel> allOwn() {
        User user = this.userRepository.findById(this.loggedUser.getId()).orElseThrow();
        return user.getOffers().stream().map(offer -> offerViewModelBuilder(offer, offer.getSeller()
                        .getUsername()))
                .collect(Collectors.toList());
    }

    private OfferViewModel offerViewModelBuilder(Offer offer, String username) {
        return OfferViewModel.builder()
                .id(offer.getId())
                .description(offer.getDescription())
                .condition(offer.getCondition().getName().getLabel())
                .price(offer.getPrice())
                .username(username)
                .build();
    }*/
}
