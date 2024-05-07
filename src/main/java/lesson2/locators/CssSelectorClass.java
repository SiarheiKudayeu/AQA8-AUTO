package lesson2.locators;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CssSelectorClass {
    public static void main(String[] args) throws InterruptedException {
       /* WebDriver driver = DriverInit.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        Thread.sleep(2000);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        }catch (NoSuchElementException e){
            System.out.println("No cookies button");
        }
        //по id cssSelector
        driver.findElement(By.cssSelector("#search")).click();*/

        //по названию тега атрибуту и значению -> input[placeholder='Search']
        //по буквосочетанию ->[placeholder*='earc']
        //по начальному буквосочетанию ->[placeholder^='Sea']
        //по конечному буквосочетанию ->[placeholder$='ch']
        WebDriver driver = DriverInit.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("Tester");
        driver.findElement(By.cssSelector("button[id=search-button].btn.search-form-btn#search-button")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("h2")).getText());

        //движение внутрь вложенности
        // .container section form .control-group .controls input#Username
    }
}
