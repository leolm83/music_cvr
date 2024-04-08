package com.leolmcoding.musiccvr.pages;

import com.leolmcoding.musiccvr.domain.dtos.MusicInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends BasePage{

    public ResultPage(WebDriver driver) {
        super(driver);
    }
    public MusicInfo getMusicInfo(){
        var albumNameElement = driver.findElement(By.xpath("/html/body//text()[   contains(     translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'Álbum') ]/parent::span/following-sibling::span/span/a"));
        String albumName = albumNameElement.getText();
        System.out.println(albumName);
        var artistNameElement = driver.findElement(By.xpath("/html/body//text()[   contains(     translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'artista') ]/parent::span/following-sibling::span/span/a"));
        String artist = artistNameElement.getText();
        System.out.println(artist);
        String fileName = albumName+"_COVER.jpg";
        return new MusicInfo(artist,albumName,fileName);
    }
    public void getNextPage(){
        var albumNameElement = driver.findElement(By.xpath("/html/body//text()[   contains(     translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'Álbum') ]/parent::span/following-sibling::span/span/a"));
        albumNameElement.click();
    }
}
