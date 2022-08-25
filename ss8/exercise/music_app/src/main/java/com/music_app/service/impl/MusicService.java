package com.music_app.service.impl;

import com.music_app.model.Music;
import com.music_app.repository.IMusicRepository;
import com.music_app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public void add(Music music) {
        this.iMusicRepository.save(music);
    }

    @Override
    public void save(Music music) {
        this.iMusicRepository.save(music);
    }

    @Override
    public List<Music> findAll() {
        return this.iMusicRepository.findAll();
    }

    @Override
    public Music findById(Integer id) {
        return this.iMusicRepository.findById(id).orElse(null);
    }
}
