package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

public class windowHandleAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement windowHandleLink = driver.findElement(By.xpath("//a[text()='Multiple Windows']"));
        windowHandleLink.click();


        WebElement newWindowLink = driver.findElement(By.xpath("//a[text()='Click Here']"));
        newWindowLink.click();

        Set<String> windowHandles=driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//h3")).getText());


        driver.quit();
    }
}
