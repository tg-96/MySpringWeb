package kr.ajousw.myspringweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import kr.ajousw.myspringweb.dto.FavoriteMusicRequestDto;
import kr.ajousw.myspringweb.dto.MusicList;
import kr.ajousw.myspringweb.entity.FavoriteMusic;
import kr.ajousw.myspringweb.repository.FavoriteRepository;
import kr.ajousw.myspringweb.service.MusicService;

@RestController
public class MyWebController {
    @Autowired
    MusicService service;

    @GetMapping("/musicSearch/{name}")
    public MusicList musicSearchByPath(@PathVariable String name) {
        return service.searchMusic(name);

    }

    @GetMapping("/musicSearch")
    public MusicList musicSearchByParam(@RequestParam String name) {
        return service.searchMusic(name);
       
    }

    @GetMapping(value = "/likes")
    public List<FavoriteMusic> getLikes() {
        return service.getLikes();
    }

    @PostMapping(value = "/likes")
    @Transactional
    public int postLikes(@RequestBody FavoriteMusicRequestDto favorite) {
        return service.saveFavorite(favorite);
    }

    @DeleteMapping("/likes/{id}")
    @Transactional
    public void deleteFavorite(@PathVariable String id){
        service.deleteFavorite(id);
    }
}
