package lesson6.is_displayed;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Urls;

import java.util.List;

public class IsNotDisplayedExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.automationPractice);
        WebElement element = driver.findElement(By.xpath("//a[text()='Popular']"));
        System.out.println(element.isDisplayed());
        //System.out.println(driver.findElement(By.id("contact")).isDisplayed());
        driver.findElement(By.id("contact-link")).click();
        Thread.sleep(2000);
        //System.out.println(element.isDisplayed());
        List<WebElement> elementList = driver.findElements(By.xpath("//a[text()='Popular']"));
        if(elementList.size() > 0) {
            System.out.println("Element with locator //a[text()='Popular'] is DISPLAYED!!!" );
        } else {
            System.out.println("Element with locator //a[text()='Popular'] is NOT DISPLAYED!!!" );
        }
        driver.quit();

    }
}
