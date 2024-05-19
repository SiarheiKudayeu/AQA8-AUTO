package lesson7.priority;

import driver_init.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Urls;

public class PriorityTest {
    static WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = DriverInit.setUpDriver();
    }

    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    public void f(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void a(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void d(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void c(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }
    @Test(priority = 2)
    public void b(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test(priority = 1)
    public void e(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

}
