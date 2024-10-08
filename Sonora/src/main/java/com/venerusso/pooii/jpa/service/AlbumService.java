package com.venerusso.pooii.jpa.service;

import com.venerusso.pooii.jpa.entity.Album;
import com.venerusso.pooii.jpa.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public Album addAlbum(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }

    public Album updateAlbum(Long id, Album updatedAlbum) {
        return albumRepository.findById(id)
                .map(album -> {
                    album.setName(updatedAlbum.getName());
                    album.setArtist(updatedAlbum.getArtist());
                    album.setGenre(updatedAlbum.getGenre());
                    return albumRepository.save(album);
                })
                .orElseThrow(() -> new RuntimeException("Album not found with id " + id));
    }

    public void deleteAlbum(Long id) {
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
        } else {
            throw new RuntimeException("Album not found with id " + id);
        }
    }
}
