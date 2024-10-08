package com.venerusso.pooii.jpa.service;

import com.venerusso.pooii.jpa.entity.Genre;
import com.venerusso.pooii.jpa.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public Genre updateGenre(Long id, Genre updatedGenre) {
        return genreRepository.findById(id)
                .map(genre -> {
                    genre.setName(updatedGenre.getName());
                    return genreRepository.save(genre);
                })
                .orElseThrow(() -> new RuntimeException("Genre not found with id " + id));
    }

    public void deleteGenre(Long id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
        } else {
            throw new RuntimeException("Genre not found with id " + id);
        }
    }
}
