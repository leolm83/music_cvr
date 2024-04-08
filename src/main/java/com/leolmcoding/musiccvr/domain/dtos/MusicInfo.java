package com.leolmcoding.musiccvr.domain.dtos;

public class MusicInfo {
    private String artist;
    private String album;
    private String fileName;
    private String coverUrl;
    public MusicInfo(String artist, String album, String fileName) {
        this.artist = artist;
        this.album = album;
        this.fileName = fileName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }



}
