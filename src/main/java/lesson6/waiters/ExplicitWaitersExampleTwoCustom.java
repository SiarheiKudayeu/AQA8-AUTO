package lesson6.waiters;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Urls;
import waiters.CustomWaiters;

import java.time.Duration;

public class ExplicitWaitersExampleTwoCustom {

    private final WebDriver driver;
    private CustomWaiters customWaiters;

    public ExplicitWaitersExampleTwoCustom(WebDriver driver) {
        this.driver = driver;
        this.customWaiters = new CustomWaiters(driver);
    }

    public void click(By locator){
        customWaiters.clickableStateOfElement(locator).click();
    }

    public static void main(String[] args) throws InterruptedException {
        //явные ожидания
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.accountPage);

        ExplicitWaitersExampleTwoCustom classOne = new ExplicitWaitersExampleTwoCustom(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        CustomWaiters waiters = new CustomWaiters(driver);

        //elementToBeClickable
        //waiters.clickableStateOfElement((By.id("ez-accept-all"))).click();
        classOne.click(By.id("ez-accept-all"));


        //elementToBeSelected
        waiters.waitForElementSelection(By.id("RememberMe"));
        driver.findElement(By.id("Password")).sendKeys("Password");

        //elementSelectionStateToBe
        waiters.waitForElementDeSelection(By.id("RememberMe"));
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
