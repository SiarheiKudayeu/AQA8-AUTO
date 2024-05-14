package lesson5.offset_click;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Urls;

public class OffSetClickExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.clickActionExPage);
        Thread.sleep(2000);
        try {
            driver.switchTo().frame("gdpr-consent-notice");
            driver.findElement(By.id("save")).click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[contains(text(), 'Selenium')])[1]")).click();
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='Flash Movie Demo']")), 0, 52)
                .click()
                .build()
                .perform();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
    }
}
