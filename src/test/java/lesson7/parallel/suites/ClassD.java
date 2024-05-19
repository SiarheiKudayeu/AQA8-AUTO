package lesson7.parallel.suites;

import driver_init.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Urls;

public class ClassD {
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
    public void a1(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void a2(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void a4(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void a3(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }
    @Test
    public void a6(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void a5(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

}
