package com.example.spotifyplaylistapp.controller;


import com.example.spotifyplaylistapp.helper.LoggedUser;
import com.example.spotifyplaylistapp.service.song.SongService;
import com.example.spotifyplaylistapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    private final LoggedUser loggedUser;
    private final SongService offerService;
    private final UserService userService;


    @Autowired
    public HomeController(LoggedUser loggedUser,
                          SongService offerService, UserService userService) {

        this.loggedUser = loggedUser;
        this.offerService = offerService;
        this.userService = userService;
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView model) {

      //  List<OfferViewModel> loggedUserOffers = this.userService.allOwn();
      //  List<OfferViewModel> otherOffers = this.offerService.getAllNonLoggedUserOffers();
      //  List<OfferViewModel> boughtOffers = this.userService.allBought();

        model.setViewName("home");

      //  model.addObject("loggedUserOffers", loggedUserOffers);
      //  model.addObject("otherOffers", otherOffers);
      //  model.addObject("boughtOffers", boughtOffers);

        model.addObject("loggedUserId", this.loggedUser.getId());

        return model;
    }

    @GetMapping("/offers/buy/{id}")
    public String buyOffer(@PathVariable Long id) {

     //   this.offerService.buyOfferById(id);

        return "redirect:/home";
    }

    @GetMapping("/offers/remove/{id}")
    public String buyAllProducts(@PathVariable Long id) {

   //     this.offerService.deleteOfferById(id);
        return "redirect:/home";
    }
}
