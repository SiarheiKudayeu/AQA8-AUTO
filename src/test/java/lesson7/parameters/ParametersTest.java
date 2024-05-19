package lesson7.parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Urls;
import waiters.CustomWaiters;

public class ParametersTest {
    static WebDriver driver;
    static CustomWaiters waiters;
    @BeforeClass
    @Parameters({"browser_type"})
    public void setUp(String browser){
        switch (browser){
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                waiters = new CustomWaiters(driver);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                waiters = new CustomWaiters(driver);
            }
        }

    }
    @AfterClass
    public void close(){
        driver.quit();
    }
    @Test
    public void negativeLoginTest(){
        driver.get(Urls.automationPracticeLoginPage);
        waiters.waitForVisibility(By.id("passwd"));
        driver.findElement(By.id("email")).sendKeys("senkey@keys.keys");
        driver.findElement(By.id("passwd")).sendKeys("someText");
        driver.findElement(By.id("SubmitLogin")).click();
        waiters.waitForVisibility(By.cssSelector(".alert.alert-danger p"));
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-danger p")).getText(),
                "There is 1 error");
    }
}
