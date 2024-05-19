package lesson7.grouping;

import driver_init.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Urls;

public class DependsOnGroups {
    static WebDriver driver;

    @BeforeClass(groups = {"smoke", "regression"})
    public void setUp(){
        driver = DriverInit.setUpDriver();
    }

    @AfterClass(groups = {"smoke", "regression"})
    public void stop(){
        driver.quit();
    }

    @Test(dependsOnGroups = {"smoke"})
    public void b1(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test(groups = {"regression"})
    public void b2(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test(groups = {"smoke"})
    public void b4(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void b8(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test(groups = {"smoke"})
    public void b9(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test(groups = {"regression"})
    public void b3(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }
    @Test(groups = {"smoke", "regression"})
    public void b6(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void b5(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test(groups = {"regression"})
    public void b7(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

}
