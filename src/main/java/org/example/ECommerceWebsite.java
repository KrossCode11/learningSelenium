package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ECommerceWebsite {
    public static void main(String[] args) throws InterruptedException {
        //my solution
        //if I need to add multiple vegetables then use array

        String expectedVegetableNames[] = {"Cucumber","Brocolli","Tomato"};

        List<String> expectedVegetableNamesList = Arrays.asList(expectedVegetableNames);

        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        for(String x: expectedVegetableNamesList) {

            String vegetableName = "Cucumber";
            String addCartXpath = "//h4[contains(text(),'" + x + "')]/..//button[text()='ADD TO CART']";

            WebElement addCartButton = driver.findElement(By.xpath(addCartXpath));
            addCartButton.click();

        }

        WebElement cartIconXpath= driver.findElement(By.xpath("//a[@class='cart-icon']"));
        cartIconXpath.click();

        WebElement proceedToCheckoutButton= driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
        proceedToCheckoutButton.click();


        WebElement enterPromoCode= driver.findElement(By.xpath("//input[@class='promoCode']"));
        enterPromoCode.sendKeys("rahulshettyacademy");

        WebElement applyPromoCodeButton= driver.findElement(By.xpath("//button[@class='promoBtn']"));
        applyPromoCodeButton.click();

        WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));

        WebElement successMessage= driver.findElement(By.xpath("//span[@class='promoInfo']"));
        System.out.println(successMessage.getText());


        Thread.sleep(5000);
        driver.quit();
    }
        //now using for loop to add multiple vegetables

        //convert array to list

//        List<String> expectedVegetableNamesList = Arrays.asList(expectedVegetableNames);


        //code given by tutorial

//        String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
//
//
//
//
//
//        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//
//        Thread.sleep(3000);
//
//        addItems(driver,itemsNeeded);
//
//        Thread.sleep(5000);
//        driver.quit();
//
//
//    }
//
//
//
//    public static  void addItems(WebDriver driver,String[] itemsNeeded) {
//        int j = 0;
//        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
//        for (int i = 0; i < products.size(); i++) {
////Brocolli - 1 Kg
////Brocolli,    1 kg
//            String[] name = products.get(i).getText().split("-");
//            String formattedName = name[0].trim();
////format it to get actual vegetable name
////convert array into array list for easy search
////  check whether name you extracted is present in arrayList or not-
//            List itemsNeededList = Arrays.asList(itemsNeeded);
//            if (itemsNeededList.contains(formattedName)) {
//                j++;
////click on Add to cart
//                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
//                if (j == itemsNeeded.length) {
//                    break;
//                }
//            }
//        }
//    }


}
