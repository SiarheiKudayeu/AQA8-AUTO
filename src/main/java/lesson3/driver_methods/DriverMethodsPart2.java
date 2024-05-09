package lesson3.driver_methods;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Urls;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DriverMethodsPart2 {
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        //get methods
        driver.get(Urls.searchPage);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("===============");

        driver.get(Urls.automationPractice);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("===============");

        driver.get(Urls.uhomki);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("===============");
        System.out.println(driver.getPageSource());
        driver.quit();

    }
}
