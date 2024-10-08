package com.venerusso.pooii.jpa.service;

import com.venerusso.pooii.jpa.entity.Artist;
import com.venerusso.pooii.jpa.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> findAllArtists() {
        return artistRepository.findAll();
    }

    public Artist updateArtist(Long id, Artist updatedArtist) {
        return artistRepository.findById(id)
                .map(artist -> {
                    artist.setName(updatedArtist.getName());
                    artist.setNationality(updatedArtist.getNationality());
                    return artistRepository.save(artist);
                })
                .orElseThrow(() -> new RuntimeException("Artist not found with id " + id));
    }

    public void deleteArtist(Long id) {
        if (artistRepository.existsById(id)) {
            artistRepository.deleteById(id);
        } else {
            throw new RuntimeException("Artist not found with id " + id);
        }
    }
}
