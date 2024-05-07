package lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestForWeb2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\chrome-win64\\chrome.exe");
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");

    }
}
