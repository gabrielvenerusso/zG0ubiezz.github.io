package com.venerusso.pooii.jpa.controller;

import com.venerusso.pooii.jpa.entity.Music;
import com.venerusso.pooii.jpa.service.MusicService;
import com.venerusso.pooii.jpa.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musics")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Music> addMusic(@RequestBody Music music) {
        return ResponseEntity.ok(musicService.addMusic(music));
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<Music>> searchMusicByName(@PathVariable String name) {
        return ResponseEntity.ok(musicService.findByName(name));
    }

    @GetMapping("/search/album/{albumName}")
    public ResponseEntity<List<Music>> searchMusicByAlbum(@PathVariable String albumName) {
        return ResponseEntity.ok(musicService.findByAlbumName(albumName));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable Long id, @RequestBody Music updatedMusic) {
        return ResponseEntity.ok(musicService.updateMusic(id, updatedMusic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusic(@PathVariable Long id) {
        musicService.deleteMusic(id);
        return ResponseEntity.noContent().build();
    }
}
