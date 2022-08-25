package com.music_app.service;

import com.music_app.model.Music;

import java.util.List;

public interface IMusicService {
    void add(Music music);
    void save(Music music);
    List<Music> findAll();
    Music findById(Integer id);
}
