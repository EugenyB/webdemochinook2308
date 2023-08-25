package com.example.webdemochinook2308.controllers;

import com.example.webdemochinook2308.data.Artist;
import com.example.webdemochinook2308.services.ArtistService;
import com.example.webdemochinook2308.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class ChinookController {

    private EmployeeService es;
    private ArtistService as;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", es.getEmployees());
        return "index";
    }

    @GetMapping("info")
    public String info(Model model) {
        model.addAttribute("employees", es.getInfo());
        return "info";
    }

    @GetMapping("artists")
    public String artists(Model model) {
        model.addAttribute("artists", as.getArtists());
        return "artists";
    }

    @PostMapping("add_artist")
    public String addArtist(@RequestParam String artist) {
        as.addArtist(artist);
        return "redirect:/artists";
    }

    @GetMapping("delete_artist")
    public String deleteArtist(@RequestParam int id) {
        as.deleteArtist(id);
        return "redirect:/artists";
    }

    @GetMapping("edit_artist")
    public String editArtist(@RequestParam int id, Model model) {
        Optional<Artist> a = as.findById(id);
        if (a.isPresent()) {
            model.addAttribute("artist", a.get());
            return "edit_artist";
        }
        return "redirect:/artists";
    }

    @PostMapping("update_artist")
    public String updateArtist(@RequestParam int artist_id, @RequestParam String artist) {
        as.updateArtist(artist_id, artist);
        return "redirect:/artists";
    }

    @GetMapping("show_albums")
    public String showAlbumsByArtist(@RequestParam int id, Model model) {
        Optional<Artist> a = as.findById(id);
        if (a.isPresent()) {
            model.addAttribute("artist", a.get());
            return "albums_by_artist";
        }
        return "redirect:/artists";
    }
}
