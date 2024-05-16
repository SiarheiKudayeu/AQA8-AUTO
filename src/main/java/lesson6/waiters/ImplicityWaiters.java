package lesson6.waiters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Urls;

import java.time.Duration;

public class ImplicityWaiters {
    public static void main(String[] args) {
        //неявные ожидания
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //ожидание загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //ожидание отработки JavaScript
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        //ожидание появления элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(Urls.dataPickerPage);
        driver.quit();

    }
}
