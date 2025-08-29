package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class locatorsPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

       String newPassword= getPassword(driver);
       System.out.println("newPassword: "+newPassword);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String userName="//input[@id='inputUsername']";
        driver.findElement(By.xpath(userName)).sendKeys("Rahul");

        String password="//input[@name='inputPassword']";
        driver.findElement(By.xpath(password)).sendKeys("newPassword");

        String button="submit";
        driver.findElement(By.className(button)).click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);


        String errorXpath="//p[@class='error']";
        String errorText=driver.findElement(By.xpath(errorXpath)).getText();
        System.out.println("errorText: "+errorText);


        String forgotPasswordXpath="//a[contains(text(),'Forgot your password')]";
        driver.findElement(By.xpath(forgotPasswordXpath)).click();

        Thread.sleep(1000);//

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(newPassword);

        driver.findElement(By.id("chkboxOne")).click();

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Thread.sleep(2000);

        String successMessageXpath="//p[contains(text(),'You are successfully logged in')]";

        String successMessageText=driver.findElement(By.xpath(successMessageXpath)).getText();

        System.out.println("successMessage: "+successMessageText);

        Assert.assertEquals(successMessageText,"You are successfully logged in.");

        driver.quit();


    }


    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String forgotPasswordXpath="//a[contains(text(),'Forgot your password')]";
        driver.findElement(By.xpath(forgotPasswordXpath)).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

       String passwordText=driver.findElement(By.cssSelector("form p")).getText();

        passwordText=passwordText.split("'")[1];

        System.out.println(passwordText);

        return passwordText;
    }

}
