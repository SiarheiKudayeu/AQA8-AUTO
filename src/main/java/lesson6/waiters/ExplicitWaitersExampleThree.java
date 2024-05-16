package lesson6.waiters;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Urls;

import java.time.Duration;

public class ExplicitWaitersExampleThree {
    public static void main(String[] args) throws InterruptedException {
        //явные ожидания
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.accountPage);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //elementToBeClickable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all"))).click();

        //presenceOfElementLocated
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search"))).click();

        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-term")));
        wait.until(ExpectedConditions.titleIs("Search Results | Guinness World Records"));
        wait.until(ExpectedConditions.titleContains("Results | Guinness"));
        wait.until(ExpectedConditions.urlToBe("https://www.guinnessworldrecords.com/search?term=%2A"));
        driver.findElement(By.id("search-term")).sendKeys("Most handstand push ups male in one minute");
        driver.findElement(By.id("search-term")).sendKeys(Keys.ENTER);

        //driver.quit();
    }
}
