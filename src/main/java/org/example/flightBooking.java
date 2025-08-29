package org.example;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flightBooking {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
                WebElement departureDropdown= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
        departureDropdown.click();
        WebElement departureLocation= driver.findElement(By.xpath("//a[@value='MAA']"));
        departureLocation.click();

        WebElement arrivalDropdown= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
        Thread.sleep(2000);
        WebElement arrivalLocation= driver.findElement(By.xpath("(//a[@value='BLR'])[2]"));

        arrivalLocation.click();


//        WebElement date= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
//
//
//        date.click();

        Thread.sleep(2000);
        WebElement currentDate= driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']"));
        System.out.println("current Date: "+currentDate.getText());

            currentDate.click();


                WebElement passangersDropdown= driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
        passangersDropdown.click();
        WebElement addButton= driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));

        int i=1;
        while(i<5){
            Thread.sleep(2000);
            addButton.click();
            i++;
        }

        WebElement searchFlight= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
        searchFlight.click();


        Alert alert= driver.switchTo().alert();
        alert.dismiss();

        driver.quit();
    }
}
