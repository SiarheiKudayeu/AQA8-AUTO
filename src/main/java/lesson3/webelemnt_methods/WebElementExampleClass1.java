package lesson3.webelemnt_methods;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Urls;

public class WebElementExampleClass1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.uhomki);

        WebElement searchField = driver.findElement(By.id("search_term"));
        //sendKeys
        searchField.sendKeys("Cat");
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //clear
        driver.findElement(By.id("search_term")).clear();
        driver.findElement(By.id("search_term")).sendKeys("Cat");
        //click
        WebElement searchButton = driver.findElement(By.cssSelector(".b-search__button"));
        searchButton.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
