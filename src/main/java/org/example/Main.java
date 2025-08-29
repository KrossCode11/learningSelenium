package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverService;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

//        DriverService service = driver.
//        System.out.println("Resolved ChromeDriver path: " + service.getUrl());
//        System.out.println("Process: " + service.getProcess().info().command().orElse("Unknown"));



        driver.get("https://www.google.com/");
//        Thread.sleep(Duration.ofSeconds(5).toMillis());
        String title = driver.getTitle();
      System.out.println("title: " + title);
      String URL=driver.getCurrentUrl();
        System.out.println("URL: "+ URL);
        driver.quit();

    }
}