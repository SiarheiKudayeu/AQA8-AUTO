package lesson2;

import driver_init.DriverInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestForWeb3 {
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
    }
}
