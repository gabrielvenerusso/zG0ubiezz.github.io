package com.venerusso.pooii.jpa.service;

import com.venerusso.pooii.jpa.entity.Music;
import com.venerusso.pooii.jpa.entity.Playlist;
import com.venerusso.pooii.jpa.repository.MusicRepository;
import com.venerusso.pooii.jpa.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private MusicRepository musicRepository;

    public Playlist addPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public List<Playlist> findAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist addMusicToPlaylist(Long playlistId, Long musicId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        Music music = musicRepository.findById(musicId)
                .orElseThrow(() -> new RuntimeException("Music not found"));

        playlist.getMusics().add(music);
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylistName(Long playlistId, String newName) {
        return playlistRepository.findById(playlistId)
                .map(playlist -> {
                    playlist.setName(newName);
                    return playlistRepository.save(playlist);
                })
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
    }

    public void deletePlaylist(Long playlistId) {
        if (playlistRepository.existsById(playlistId)) {
            playlistRepository.deleteById(playlistId);
        } else {
            throw new RuntimeException("Playlist not found");
        }
    }
}
