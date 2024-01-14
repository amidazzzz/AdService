package ru.amida.advertservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.amida.advertservice.model.Advert;
import ru.amida.advertservice.repository.AdvertRepository;

import java.util.List;

@Controller
public class AdvertController {
    private final AdvertRepository advertRepository;


    public AdvertController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping("/main")
    public String mainPage(Model model){
        List<Advert> adverts = advertRepository.findAll();
        model.addAttribute("adverts", adverts);

        return "test";
    }
}
