package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ActionClass {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com/ref=nav_logo");
        driver.manage().window().maximize();
        WebElement signInButton= driver.findElement(By.xpath("//div[@id='nav-link-accountList']//a"));
        Actions action = new Actions(driver);
            action.moveToElement(signInButton).build().perform();



        WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("toys").build().perform();

        //right click
        action.moveToElement(searchBox).contextClick().build().perform();


        Thread.sleep(2000);


            driver.quit();
    }






}
