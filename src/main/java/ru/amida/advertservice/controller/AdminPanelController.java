package ru.amida.advertservice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.amida.advertservice.model.Advert;
import ru.amida.advertservice.repository.AdvertRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private final AdvertRepository advertRepository;

    public AdminPanelController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping("/adverts")
    public String showAdverts(Model model){
        List<Advert> advertList = advertRepository.findAll();
        model.addAttribute("adverts", advertList);
        return "advertList";
    }

    @PostMapping("/deleteAdvert/{id}")
    public String deleteAdvert(@PathVariable Long id){
        advertRepository.deleteById(id);
        return "redirect:/admin/adverts";
    }
}
