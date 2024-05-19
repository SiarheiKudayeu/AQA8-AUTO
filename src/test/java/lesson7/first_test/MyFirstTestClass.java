package lesson7.first_test;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Urls;
import waiters.CustomWaiters;

public class MyFirstTestClass {

    static WebDriver driver;
    static CustomWaiters waiters;

    @BeforeClass
    public void setUp(){
        driver = DriverInit.setUpDriver();
        waiters = new CustomWaiters(driver);
    }

    @AfterClass
    public void stopDriver(){
        driver.quit();
    }
    @Test
    public void myFirstTest(){
        driver.get(Urls.searchPage);
        String textToSend = "Handstand";
        waiters.waitForVisibility(By.id("search-term")).sendKeys(textToSend);
        driver.findElement(By.id("search-term")).sendKeys(Keys.ENTER);
        waiters.waitForVisibility(By.tagName("h2"));
        //System.out.println(12/0);
        Assert.assertTrue(driver.findElement(By.id("search-term")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains(textToSend)
        , "In element with text '" + driver.findElement(By.tagName("h2")).getText() + "', there is no " +
                        "text '" + textToSend + "'.");
        Assert.assertFalse(driver.findElement(By.tagName("h2")).getText().contains("airplane"));
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        Assert.assertNotEquals(driver.getTitle(), "Search Results | Guinness World Records2");
    }

    @Test
    public void myFirstTest2(){
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
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        Assert.assertNotEquals(driver.getTitle(), "Search Results | Guinness World Records2");
    }

    @Test
    public void myFirstTest3(){
     Assert.assertTrue(false);
    }
}
