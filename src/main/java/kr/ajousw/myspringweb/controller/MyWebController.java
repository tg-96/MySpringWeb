package kr.ajousw.myspringweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ajousw.myspringweb.dto.MusicList;
import kr.ajousw.myspringweb.entity.FavoriteMusic;
import kr.ajousw.myspringweb.repository.FavoriteRepository;

@RestController
public class MyWebController {
    @Autowired
    FavoriteRepository albumsRepo;

    @GetMapping("/musicSearch/{term}")
    public MusicList musicSearchByPath(@PathVariable String term) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate
                    .getForObject("https://itunes.apple.com/search?term=" + term + "&entity=album", String.class);
            ObjectMapper mapper = new ObjectMapper();
            MusicList list = mapper.readValue(response, MusicList.class);
            System.out.println(list.getResultCount());
            return list;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    @GetMapping("/musicSearch")
    public MusicList musicSearchByParam(@RequestParam String term) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate
                    .getForObject("https://itunes.apple.com/search?term=" + term + "&entity=album", String.class);
            ObjectMapper mapper = new ObjectMapper();
            MusicList list = mapper.readValue(response, MusicList.class);
            System.out.println(list.getResultCount());
            return list;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @GetMapping(value = "/likes")
    public List<FavoriteMusic> getLikes() {

        try {
            return albumsRepo.findAll();

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

}
