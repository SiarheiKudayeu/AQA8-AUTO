package lesson3.driver_methods;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Urls;

public class RefreshExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.uhomki);
        WebElement searchField = driver.findElement(By.id("search_term"));
        searchField.sendKeys("Cat");
        WebElement searchButton = driver.findElement(By.cssSelector(".b-search__button"));
        searchButton.click();
        Thread.sleep(3000);
        driver.findElement(By.id("search_term")).sendKeys("Cat");
        searchButton = driver.findElement(By.cssSelector(".b-search__button"));
        searchButton.click();
    }
}
