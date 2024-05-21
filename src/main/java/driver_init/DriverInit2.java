package driver_init;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverInit2 {
    private static WebDriver driver;
    private static WebDriver setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver getInstance(){
        if(driver == null){
            try {
                driver = setUpDriver();
            }catch (Exception e){}
        }
        return driver;
    }
    public static WebDriver startDriver(){
        driver = getInstance();
        return driver;
    }
}
