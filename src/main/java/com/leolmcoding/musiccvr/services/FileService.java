package com.leolmcoding.musiccvr.services;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class FileService {

    public File[] findAllfilesWithExtension(Path path, String extension){
        File baseDir = new File(path.toUri());
        File[] files = baseDir.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
        return files;
    }
    public void createDirIfNotExists(File file){
        if(!file.exists()){
            file.mkdir();
        }
    }
}
