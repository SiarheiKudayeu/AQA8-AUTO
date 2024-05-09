package lesson3.driver_methods;

import driver_init.DriverInit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utils.Urls;

import java.util.Set;

public class WindowHandlesExample1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.uhomki);

        //первый вариан открытия новой вкладки
        Set<String> windowHandle1 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> windowHandle2 = driver.getWindowHandles();
        windowHandle2.removeAll(windowHandle1);
        String descriptorOfSecondWindow = windowHandle2.iterator().next();
        driver.switchTo().window(descriptorOfSecondWindow);
        driver.get(Urls.automationPractice);

        //второй вариан открытия новой вкладки
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(Urls.searchPage);

        //вариан открытия нового окна
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(Urls.automationPractice);
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);
        driver.switchTo().window(descriptorOfSecondWindow);
        driver.get(Urls.uhomki);
        Thread.sleep(3000);
        driver.quit();
    }
}
