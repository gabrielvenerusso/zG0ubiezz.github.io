package com.venerusso.pooii.jpa.service;

import com.venerusso.pooii.jpa.entity.Music;
import com.venerusso.pooii.jpa.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

    public Music addMusic(Music music) {
        return musicRepository.save(music);
    }

    public List<Music> findByName(String name) {
        return musicRepository.findByName(name);
    }

    public List<Music> findByAlbumName(String albumName) {
        return musicRepository.findByAlbum_Name(albumName);
    }

    public Music updateMusic(Long id, Music updatedMusic) {
        return musicRepository.findById(id)
                .map(music -> {
                    music.setName(updatedMusic.getName());
                    music.setAlbum(updatedMusic.getAlbum());
                    return musicRepository.save(music);
                })
                .orElseThrow(() -> new RuntimeException("Music not found with id " + id));
    }

    public void deleteMusic(Long id) {
        if (musicRepository.existsById(id)) {
            musicRepository.deleteById(id);
        } else {
            throw new RuntimeException("Music not found with id " + id);
        }
    }
}
