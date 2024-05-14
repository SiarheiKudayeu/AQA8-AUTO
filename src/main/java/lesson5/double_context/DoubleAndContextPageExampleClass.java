package lesson5.double_context;

import driver_init.DriverInit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Urls;

public class DoubleAndContextPageExampleClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.clickActionExPage);
        Thread.sleep(2000);
        try {
            driver.switchTo().frame("gdpr-consent-notice");
            driver.findElement(By.id("save")).click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        driver.switchTo().defaultContent();
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.cssSelector(".context-menu-one"))).perform();
        Thread.sleep(300);
        driver.findElement(By.xpath("//span[text()='Quit']")).click();
        Thread.sleep(300);
        Alert alert = driver.switchTo().alert();
        String textFromFrame = alert.getText();
        alert.accept();

        if(textFromFrame.contains("quit")){
            System.out.println("TEST_1 PASSED!!!");
        }else {
            System.out.println("TEST_1 FAILED!!!");
        }
        Thread.sleep(2000);

        actions.doubleClick(driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"))).perform();
        alert = driver.switchTo().alert();
        textFromFrame = alert.getText();
        alert.accept();

        if(textFromFrame.equals("You double clicked me.. Thank You..")){
            System.out.println("TEST_2 PASSED!!!");
        }else {
            System.out.println("TEST_2 FAILED!!!");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
