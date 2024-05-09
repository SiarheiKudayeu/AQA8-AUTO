package lesson3.driver_methods;

import driver_init.DriverInit;
import org.openqa.selenium.WebDriver;
import utils.Urls;

public class DriverMethodsPart3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        //navigate
        driver.get(Urls.searchPage);
        System.out.println(driver.getTitle());
        System.out.println("===============");
        Thread.sleep(1500);

        driver.navigate().to(Urls.automationPractice);
        System.out.println(driver.getTitle());
        System.out.println("===============");
        Thread.sleep(1500);

        driver.navigate().back();
        System.out.println(driver.getTitle());
        System.out.println("===============");
        Thread.sleep(1500);

        driver.navigate().forward();
        System.out.println(driver.getTitle());
        System.out.println("===============");
        Thread.sleep(1500);

        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.quit();

    }
}
