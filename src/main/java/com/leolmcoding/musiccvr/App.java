package com.leolmcoding.musiccvr;
import com.leolmcoding.musiccvr.services.AlbumCoverService;
import com.leolmcoding.musiccvr.services.FileService;

import java.io.File;
import java.nio.file.Path;


public class App 
{
    public static void main( String[] args ){
        Path mp3DirPath = Path.of("./mp3");
        File mp3Dir = new File(mp3DirPath.toUri());

        FileService fileService = new FileService();
        fileService.createDirIfNotExists(mp3Dir);
        File coversDir = new File(Path.of("./covers").toUri());
        fileService.createDirIfNotExists(coversDir);
        File[] files = fileService.findAllfilesWithExtension(mp3DirPath,"mp3");
        System.out.println("ARQUIVOS ENCONTRADOS "+files.length);
        for(File f: files){
            System.out.println(f.getAbsolutePath());
            AlbumCoverService albumCoverService = new AlbumCoverService();
            albumCoverService.getCover(f);
        }
      }
    }
