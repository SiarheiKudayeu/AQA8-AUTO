package lesson5.iframe;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Urls;

public class IframeExampleV2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.w3schoolIframe);

        Thread.sleep(3000);
        try {
            driver.findElement(By.id("accept-choices")).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        driver.switchTo().frame("iframeResult");

        for (int i = 0; i < 20; i++){
            new Actions(driver)
                    .sendKeys(Keys.ARROW_DOWN);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']")));

        try {
            driver.findElement(By.id("accept-choices")).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        driver.findElement(By.id("tnb-google-search-mobile-show")).click();
        driver.findElement(By.id("tnb-google-search-input")).sendKeys("QA");
        driver.findElement(By.id("tnb-google-search-input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.quit();

    }
}
