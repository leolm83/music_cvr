package com.leolmcoding.musiccvr.services;

import com.leolmcoding.musiccvr.config.WebDriverConfig;
import com.leolmcoding.musiccvr.pages.ResultPage;
import com.leolmcoding.musiccvr.domain.dtos.MusicInfo;
import com.leolmcoding.musiccvr.pages.AlbumInfoPage;
import com.leolmcoding.musiccvr.pages.HomePage;
import com.leolmcoding.musiccvr.utils.FileNameUtil;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class AlbumCoverService {

    public void getCover(File file){
        WebDriver driver = null;
        try {
            // page 1 home page
            driver = WebDriverConfig.getFirefoxDriver();
            //driver = new ChromeDriver();
            HomePage homePage = new HomePage(driver);
            homePage.getHomePage();
            homePage.seach(FileNameUtil.getFileNameWithoutExtension(file.getName()));
            //System.out.println("Page Source is : " + driver.getPageSource());
            // page 2 results page
            ResultPage resultPage = new ResultPage(driver);
            MusicInfo musicInfo = resultPage.getMusicInfo();
            resultPage.getNextPage();
            // page 3
            AlbumInfoPage albumInfoPage = new AlbumInfoPage(driver);
            String url =  albumInfoPage.getCoverUrl();
            musicInfo.setCoverUrl(url);
            // download file
            Path path = Paths.get("./covers",musicInfo.getFileName());
            try(InputStream in = new URL(musicInfo.getCoverUrl()).openStream()) {
                Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
            }
            //change music cover
            byte[] coverAsBytes = Files.readAllBytes(path);
            MusicMetadataService.setMusicInfo(file,coverAsBytes,musicInfo);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(Objects.nonNull(driver)){
                driver.quit();
            }
        }
    }
}
