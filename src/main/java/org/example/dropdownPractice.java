package org.example;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class dropdownPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Static Dropdown
//        WebElement dropdownElement= driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
//        Select dropdown= new Select(dropdownElement);
//
//        dropdown.selectByIndex(3);
//
//
//        String selectedCurrency=dropdown.getFirstSelectedOption().getText();
//        System.out.println("selectedCurrency: "+selectedCurrency);
//
//        dropdown.selectByValue("AED");
//
//
//        String selectedCurrency2=dropdown.getFirstSelectedOption().getText();
//        System.out.println("selectedCurrency: "+selectedCurrency2);
//


//        WebElement passangersDropdown= driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
//        passangersDropdown.click();
//        WebElement addButton= driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));
//
//        int i=1;
//        while(i<5){
//            Thread.sleep(2000);
//            addButton.click();
//            i++;
//        }
//
//        Assert.assertTrue(passangersDropdown.getText().contains("5"));


        //Dynamic Dropdown

//        WebElement departureDropdown= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
//        departureDropdown.click();
//        WebElement departureLocation= driver.findElement(By.xpath("//a[@value='MAA']"));
//        departureLocation.click();
//
//        WebElement arrivalDropdown= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
//        Thread.sleep(2000);
//        WebElement arrivalLocation= driver.findElement(By.xpath("(//a[@value='BLR'])[2]"));
//
//        arrivalLocation.click();



        //auto suggest dropdown

        WebElement search= driver.findElement(By.xpath("//div[@id='header']//input[@id='autosuggest']"));
        search.sendKeys("ind");
        Thread.sleep(2000);

            List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@id='ui-id-1']//a"));
            for(WebElement suggestion:suggestions){
                if(suggestion.getText().equals("India")){
                    suggestion.click();
                    break;
                }
            }


        Thread.sleep(2000);
        driver.quit();
    }
}
