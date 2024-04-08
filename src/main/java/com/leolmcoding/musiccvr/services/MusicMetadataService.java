package com.leolmcoding.musiccvr.services;

import com.leolmcoding.musiccvr.domain.dtos.MusicInfo;
import com.leolmcoding.musiccvr.exceptions.FailureToSetMp3MetadataException;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;

import java.io.File;

public class MusicMetadataService {

    public static void setMusicInfo(File mp3, byte[] coverAsBytes, MusicInfo musicInfo){
        try {
            MP3File musicFile = (MP3File) AudioFileIO.read(mp3);
            setMusicCover(musicFile,mp3, coverAsBytes);
            setMusicArtist(musicFile, musicInfo.getArtist());
            setMusicAlbum(musicFile, musicInfo.getAlbum());
        }catch (Exception e){
            e.printStackTrace();
            throw new FailureToSetMp3MetadataException("SOMETHING WENT WRONG WHEN SETTING THE COVER");
        }
        }

    private static void setMusicAlbum(MP3File musicFile, String album) throws Exception {
        Tag tag = musicFile.getTag();
        tag.setField(FieldKey.ALBUM,album);
        musicFile.commit();
    }

    private static void setMusicArtist(MP3File musicFile, String artist) throws Exception {
        Tag tag = musicFile.getTag();
        tag.setField(FieldKey.ARTIST,artist);
        musicFile.commit();
    }

    public static void setMusicCover(MP3File musicFile,File SourceFile, byte[] bytes) throws Exception{
            AbstractID3v2Tag tag = musicFile.getID3v2Tag();
            Artwork artwork = null;
            artwork = ArtworkFactory.createArtworkFromFile(SourceFile);
            if (artwork != null) {
                artwork.setBinaryData(bytes);
                tag.deleteArtworkField();
                tag.setField(artwork);
                musicFile.setTag(tag);
                musicFile.commit();
            }
    }

}
