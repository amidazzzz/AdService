package ru.amida.advertservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.amida.advertservice.model.Advert;
import ru.amida.advertservice.repository.AdvertRepository;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class AdvertController {
    private final AdvertRepository advertRepository;


    public AdvertController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping()
    public String mainPage(Model model){
        List<Advert> adverts = advertRepository.findAll();
        model.addAttribute("adverts", adverts);

        return "main";
    }

    @PostMapping("/deleteAdvert/{id}")
    public String deleteAdvert(@PathVariable Long id, Authentication authentication){
        String currentUsername = authentication.getName();
        Optional<Advert> optionalAdvert = advertRepository.findById(id);

        if (optionalAdvert.isPresent()){
            Advert advert = optionalAdvert.get();

            if (advert.getUser().getUsername().equals(currentUsername)){
                advertRepository.deleteById(id);
            }else{
                return "redirect:/";
            }

        }else {
            return "redirect:/";
        }

        return "redirect:/main";
    }

    @GetMapping("/addAdvert")
    public String showAdvertForm(){
        return "advertForm";
    }

    @PostMapping("/addAdvert")
    public String createAdvert(@ModelAttribute Advert advert){
        advertRepository.save(advert);
        return "redirect:/";
    }
}
