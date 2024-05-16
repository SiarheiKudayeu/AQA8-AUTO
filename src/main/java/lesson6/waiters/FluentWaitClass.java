package lesson6.waiters;

import driver_init.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Urls;

import java.time.Duration;

public class FluentWaitClass {
    public static void main(String[] args) {
        //Свободные ожидание
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.w3schoolAlert);
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchFrameException.class);


        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices"))).click();
    }
}
