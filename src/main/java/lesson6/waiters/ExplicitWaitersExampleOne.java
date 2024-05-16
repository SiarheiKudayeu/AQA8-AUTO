package lesson6.waiters;

import driver_init.DriverInit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Urls;

import java.time.Duration;

public class ExplicitWaitersExampleOne {
    public static void main(String[] args) {
        //явные ожидания
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.w3schoolAlert);
        //accept-choices
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //visibilityOfElementLocated
        WebElement acceptCookies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices")));
        acceptCookies.click();

        //frameToBeAvailableAndSwitchToIt
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
        driver.quit();
    }
}
