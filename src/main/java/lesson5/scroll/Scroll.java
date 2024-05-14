package lesson5.scroll;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Urls;

public class Scroll {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.rozetka);
        Thread.sleep(2000);

        for (int i = 0; i < 100; i++) {
            new Actions(driver)
                    .sendKeys(Keys.ARROW_DOWN).perform();
        }


        driver.findElement(By.name("search")).sendKeys("iphone");
        Thread.sleep(2000);


        for (int i = 0; i < 3; i++) {
            new Actions(driver)
                    .sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(2000);
        }

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(3000);



        Thread.sleep(3000);

        driver.quit();
    }
}
