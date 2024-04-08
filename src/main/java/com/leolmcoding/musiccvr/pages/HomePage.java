package com.leolmcoding.musiccvr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void getHomePage(){
        driver.get("https://www.google.com/");
    }

    public void seach(String searchTerm){
        var input = driver.findElement(By.xpath("//textarea[@title='Pesquisar']"));
        input.sendKeys(searchTerm);
        var submitButton = driver.findElement(By.xpath("//input[@value='Pesquisa Google']"));
        submitButton.submit();
    }
}
