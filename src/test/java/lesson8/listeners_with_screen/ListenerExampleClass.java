package lesson8.listeners_with_screen;

import driver_init.DriverInit2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners;
import utils.MyTestListeners2;
import utils.Urls;
import waiters.CustomWaiters;

@Listeners({MyTestListeners2.class})
public class ListenerExampleClass {
    static WebDriver driver;
    static CustomWaiters waiters;

    @BeforeClass
    public void setUp() {
        driver = DriverInit2.startDriver();
        waiters = new CustomWaiters(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test
    public void negativeLoginTest() {
        driver.get(Urls.automationPracticeLoginPage);
        waiters.waitForVisibility(By.id("passwd"));
        driver.findElement(By.id("email")).sendKeys("senkey@keys.keys");
        driver.findElement(By.id("passwd")).sendKeys("someText");
        driver.findElement(By.id("SubmitLogin")).click();
        waiters.waitForVisibility(By.cssSelector(".alert.alert-danger p"));
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-danger p")).getText(),
                "There is 1 error");
    }

    @Test
    public void searchFieldPositiveCase() {
        driver.get(Urls.searchPage);
        String textToSend = "Handstand";
        waiters.waitForVisibility(By.id("search-term")).sendKeys(textToSend);
        driver.findElement(By.id("search-term")).sendKeys(Keys.ENTER);
        waiters.waitForVisibility(By.tagName("h2"));
        Assert.assertTrue(driver.findElement(By.id("search-term")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains(textToSend)
                , "In element with text '" + driver.findElement(By.tagName("h2")).getText() + "', there is no " +
                        "text '" + textToSend + "'.");
        Assert.assertFalse(driver.findElement(By.tagName("h2")).getText().contains("airplane"));
        Assert.assertEquals(driver.getTitle(), "Search Resuoooolts | Guinness World Records");
        Assert.assertNotEquals(driver.getTitle(), "Search Results | Guinness World Records2");
    }

}
