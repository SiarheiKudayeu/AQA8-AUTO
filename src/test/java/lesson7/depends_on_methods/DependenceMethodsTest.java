package lesson7.depends_on_methods;

import driver_init.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utils.Urls;

public class DependenceMethodsTest {
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

    @Test(dependsOnMethods = {"a6", "a3"})
    public void a4(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test(enabled = false)
    public void check_function_of_login_button(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    @Ignore
    public void a9(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void a3(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        Assert.assertTrue(false);
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

    @Test(dependsOnMethods = {"a3"}, alwaysRun = true)
    public void a7(){
        driver.get(Urls.searchPage);
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

}
