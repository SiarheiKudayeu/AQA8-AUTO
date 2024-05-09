package lesson3.driver_methods;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Urls;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DriverMethodsPart1 {
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.searchPage);

        //driver.findElements
        List<WebElement> webElementList = driver.findElements(By.xpath("//a[@class='mob-menu-link uppercase']"));
        boolean firstCheck = webElementList.size() == 6;
        String[] labels = {"RECORDS", "SPOTLIGHT", "BOOKS", "BUSINESS SOLUTIONS", "NEWS", "ABOUT US"};
        boolean secondCheck = true;

        for (int i = 0; i < labels.length; i++) {
            if (!(webElementList.get(i).getText().equals(labels[i]))) {
                secondCheck = false;
                break;
            }
        }
        boolean result = firstCheck && secondCheck;
        System.out.println("Test is " + result);

        //manage
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie: cookies){
            System.out.println(cookie);
        }
        System.out.println("All amount of cookies is " + cookies.size());
        System.out.println("=======");
        System.out.println("Separate cookie file is " + cookies.toArray()[2]);
        driver.quit();

    }
}
