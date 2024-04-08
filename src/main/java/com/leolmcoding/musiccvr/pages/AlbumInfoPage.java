package com.leolmcoding.musiccvr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlbumInfoPage extends BasePage{

    public AlbumInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getCoverUrl(){
        var albumCoverElement = driver.findElement(By.xpath("//div[@role='button' and contains(@aria-label,'Imagem em miniatura')]"));
        albumCoverElement.click();
        String FILE_URL = driver.findElement(By.xpath("//h1/text()[   contains(     translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'https://upload') ]/parent::h1")).getText();
        System.out.println(FILE_URL);
        return FILE_URL;
    }
}
