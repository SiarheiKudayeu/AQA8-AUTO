package lesson7.data_provider;

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

public class DataProvider {
    static WebDriver driver;
    static CustomWaiters waiters;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waiters = new CustomWaiters(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test(dataProvider = "loginPassAndMailValue")
    public void negativeLoginTest(String mail, int password) {
        driver.get(Urls.automationPracticeLoginPage);
        waiters.waitForVisibility(By.id("passwd"));
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("passwd")).sendKeys(String.valueOf(password));
        driver.findElement(By.id("SubmitLogin")).click();
        waiters.waitForVisibility(By.cssSelector(".alert.alert-danger p"));
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-danger p")).getText(),
                "There is 1 error");
    }

    @org.testng.annotations.DataProvider(name = "loginPassAndMailValue")
    public Object[][] createData(){
        return new Object[][]{
                {"invalid mail1", 1213123},
                {"invalid mail2", 312312313},
                {"invalid mail3", 23423234},
                {"invalid mail4", 24323424},
                {"invalid mail5", 234234}
        };
    }

}
