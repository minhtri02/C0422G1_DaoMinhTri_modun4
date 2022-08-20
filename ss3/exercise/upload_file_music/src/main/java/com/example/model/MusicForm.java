package com.example.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private int id;

    private String name;

    private String singer;

    private String kind;

    private String link;

    private MultipartFile music;

    public MusicForm() {
    }

    public MusicForm(String name, String singer, String kind, String link, MultipartFile music) {
        this.name = name;
        this.singer = singer;
        this.kind = kind;
        this.link = link;
        this.music = music;
    }

    public MusicForm(int id, String name, String singer, String kind, String link, MultipartFile music) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kind = kind;
        this.link = link;
        this.music = music;
    }

    public int getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public MultipartFile getMusic() {
        return music;
    }

    public void setMusic(MultipartFile music) {
        this.music = music;
    }
}
