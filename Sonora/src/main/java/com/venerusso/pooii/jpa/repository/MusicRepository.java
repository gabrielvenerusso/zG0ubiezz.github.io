package com.venerusso.pooii.jpa.repository;

import com.venerusso.pooii.jpa.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findByName(String name);
    List<Music> findByAlbum_Name(String albumName);
}
