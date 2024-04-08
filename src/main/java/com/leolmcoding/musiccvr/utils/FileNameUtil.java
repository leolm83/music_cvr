package com.leolmcoding.musiccvr.utils;

import org.apache.commons.io.FilenameUtils;

public class FileNameUtil {

    public static String getFileNameWithoutExtension(String fileName){
        return FilenameUtils.removeExtension(fileName);

    }
}
