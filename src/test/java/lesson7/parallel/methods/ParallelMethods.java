package lesson7.parallel.methods;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Urls;

public class ParallelMethods {
    @Test
    public void test1(){
        WebDriver driver = DriverInit.setUpDriver();
        try {
            driver.get(Urls.searchPage);
            Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        }catch (Exception e){
        }
        finally {
            driver.quit();
        }
   }
    @Test
    public void test2(){
        WebDriver driver = DriverInit.setUpDriver();
        try {
            driver.get(Urls.searchPage);
            Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        }catch (Exception e){
        }
        finally {
            driver.quit();
        }
    }

    @Test
    public void test3(){
        WebDriver driver = DriverInit.setUpDriver();
        try {
            driver.get(Urls.searchPage);
            Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        }catch (Exception e){
        }
        finally {
            driver.quit();
        }
    }
    @Test
    public void test4(){
        WebDriver driver = DriverInit.setUpDriver();
        try {
            driver.get(Urls.searchPage);
            Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        }catch (Exception e){
        }
        finally {
            driver.quit();
        }
    }
    @Test
    public void test5(){
        WebDriver driver = DriverInit.setUpDriver();
        try {
            driver.get(Urls.searchPage);
            Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        }catch (Exception e){
        }
        finally {
            driver.quit();
        }
    }
    @Test
    public void test6(){
        WebDriver driver = DriverInit.setUpDriver();
        try {
            driver.get(Urls.searchPage);
            Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        }catch (Exception e){
        }
        finally {
            driver.quit();
        }
    }
}
