package com.venerusso.pooii.jpa.controller;

import com.venerusso.pooii.jpa.entity.Playlist;
import com.venerusso.pooii.jpa.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Playlist> addPlaylist(@RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.addPlaylist(playlist));
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.findAllPlaylists());
    }

    @PostMapping("/{playlistId}/addMusic/{musicId}")
    public ResponseEntity<Playlist> addMusicToPlaylist(@PathVariable Long playlistId, @PathVariable Long musicId) {
        Playlist updatedPlaylist = playlistService.addMusicToPlaylist(playlistId, musicId);
        return ResponseEntity.ok(updatedPlaylist);
    }

    @PutMapping("/{playlistId}/name")
    public ResponseEntity<Playlist> updatePlaylistName(@PathVariable Long playlistId, @RequestBody String newName) {
        Playlist updatedPlaylist = playlistService.updatePlaylistName(playlistId, newName);
        return ResponseEntity.ok(updatedPlaylist);
    }

    @DeleteMapping("/{playlistId}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long playlistId) {
        playlistService.deletePlaylist(playlistId);
        return ResponseEntity.noContent().build();
    }
}
