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

public class ExplicitWaitersExampleTwo {
    public static void main(String[] args) throws InterruptedException {
        //явные ожидания
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.accountPage);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //elementToBeClickable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all"))).click();

        //elementToBeSelected
        wait.until(ExpectedConditions.elementToBeSelected(By.id("RememberMe")));
        driver.findElement(By.id("Password")).sendKeys("Password");

        //elementSelectionStateToBe
        wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("RememberMe"), false));
        driver.findElement(By.id("Password")).clear();

        //textToBePresentInElementValue
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("Username"), "AQA8"));
        driver.get(Urls.rozetka);
        //invisibilityOfElementLocated
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("Username")));
        driver.get(Urls.w3schoolAlert);
        driver.quit();
    }
}
