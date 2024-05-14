package lesson5.iframe;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Urls;

public class IframeExampleV1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.demoQAIframe);
        Thread.sleep(1500);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().frame("frame1");
        System.out.println("===========");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@srcdoc,'Child')]"));
        driver.switchTo().frame(iframe);
        System.out.println("===========");
        System.out.println(driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText());
        driver.switchTo().parentFrame();
        System.out.println("===========parentFrame()");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().frame(iframe);
        driver.switchTo().defaultContent();
        System.out.println("===========defaultContent()");
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }
}
