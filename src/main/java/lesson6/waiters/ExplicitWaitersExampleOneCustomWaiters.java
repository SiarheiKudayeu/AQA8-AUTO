package lesson6.waiters;

import driver_init.DriverInit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Urls;
import waiters.CustomWaiters;

import java.time.Duration;

public class ExplicitWaitersExampleOneCustomWaiters {
    public static void main(String[] args) {
        //кастомные ожидания
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.w3schoolAlert);
        CustomWaiters waiters = new CustomWaiters(driver);

        //visibilityOfElementLocated
        waiters.waitForVisibility(By.id("accept-choices")).click();

        //frameToBeAvailableAndSwitchToIt
        waiters.switchToFrame(By.id("iframeResult"));
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

        //alertIsPresent
        Alert alert = waiters.switchToAlert();
        System.out.println(alert.getText());
        alert.accept();
        driver.quit();
    }
}
