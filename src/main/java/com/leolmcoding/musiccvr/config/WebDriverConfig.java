package com.leolmcoding.musiccvr.config;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriverConfig {
    public static FirefoxDriver getFirefoxDriver(){
        FirefoxDriver driver = new FirefoxDriver(firefoxConfig());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
        return driver;
    }
    private static FirefoxOptions firefoxConfig(){
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("general.useragent.override", "Mozilla/5.0 (X11; Linux x86_64; rv:124.0) Gecko/20100101 Firefox/124.0");
        options.addPreference("intl.accept_languages",
                "pt-BR,pt;q=0.8,en-US;q=0.5,en;q=0.3");
        return options;

    }
}
