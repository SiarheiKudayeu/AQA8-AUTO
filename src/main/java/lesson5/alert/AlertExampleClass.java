package lesson5.alert;

import driver_init.DriverInit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Urls;

public class AlertExampleClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.alertExamplePage);

        By jsAlert = By.xpath("//button[@onclick='jsAlert()']");
        By jsConfirm = By.xpath("//button[@onclick='jsConfirm()']");
        By jsPrompt = By.xpath("//button[@onclick='jsPrompt()']");
        By result = By.id("result");

        String resultJsAlertAccept = "You successfully clicked an alert";
        String resultJsAlertDismiss = "You clicked: Cancel";
        String resultJsAlertSendKeys = "You entered: ";

        Thread.sleep(300);
        driver.findElement(jsAlert).click();

        System.out.println("=======jsAlert test1=======");
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(300);
        boolean resultOfTest = driver.findElement(result).getText().equals(resultJsAlertAccept);
        if(resultOfTest){
            System.out.println("jsAlert test1 PASSED!!!");
        } else {
            System.out.println("jsAlert test1 FAILED!!!");
        }

        System.out.println("=======jsConfirm test2=======");
        driver.findElement(jsConfirm).click();
        Thread.sleep(300);
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        resultOfTest = driver.findElement(result).getText().equals(resultJsAlertDismiss);
        if(resultOfTest){
            System.out.println("jsConfirm test2 PASSED!!!");
        } else {
            System.out.println("jsConfirm test2 FAILED!!!");
        }

        System.out.println("=======jsPrompt test3=======");
        driver.findElement(jsPrompt).click();
        Thread.sleep(300);
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        String textToEnter = "TEST FOR AQA8";
        alert.sendKeys(textToEnter);
        alert.accept();
        Thread.sleep(300);
        resultOfTest = driver.findElement(result).getText().equals(resultJsAlertSendKeys + textToEnter);
        if(resultOfTest){
            System.out.println("jsPrompt test3 PASSED!!!");
        } else {
            System.out.println("jsPrompt test3 FAILED!!!");
        }
        driver.quit();


    }
}
