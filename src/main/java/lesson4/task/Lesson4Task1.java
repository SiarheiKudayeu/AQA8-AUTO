package lesson4.task;

import driver_init.DriverInit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.Urls;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lesson4Task1 {
        /*  Открыть в браузере три различные вкладки.
    На каждой вкладке открыть отдельно различные любые страницы,
    вывести в консоль названия открытых страниц. Закрыть браузер.*/

    public static String openLinkInNewTabAndReturnNewWindowHandle(WebDriver driver, String url) {
        Set<String> winHan1 = driver.getWindowHandles();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> winHan2 = driver.getWindowHandles();
        winHan2.removeAll(winHan1);
        String windowHandle2 = winHan2.iterator().next();
        driver.switchTo().window(windowHandle2);
        driver.get(url);
        return windowHandle2;
    }

    public static void openLinkInNewTab(WebDriver driver, Set<String> urls) {
        for (String url: urls){
            Set<String> winHan1 = driver.getWindowHandles();
            ((JavascriptExecutor) driver).executeScript("window.open()");
            Set<String> winHan2 = driver.getWindowHandles();
            winHan2.removeAll(winHan1);
            String windowHandle2 = winHan2.iterator().next();
            driver.switchTo().window(windowHandle2);
            driver.get(url);
        }
    }

    public static void printAllNamesOfTabs(WebDriver driver, Set<String> windowHandles){
        for(String handle: windowHandles){
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
        }
    }

    public static void printAllNamesOfTabs(WebDriver driver){
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle: windowHandles){
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //вариант1
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.rozetka);
        String windowHandle1 = driver.getWindowHandle();
        String windowHandle2 = openLinkInNewTabAndReturnNewWindowHandle(driver, Urls.automationPractice);
        String windowHandle3 = openLinkInNewTabAndReturnNewWindowHandle(driver, Urls.uhomki);

        Set<String> windowHandles = new HashSet<>();
        windowHandles.add(windowHandle1);
        windowHandles.add(windowHandle2);
        windowHandles.add(windowHandle3);

        printAllNamesOfTabs(driver,windowHandles);
        driver.quit();

        driver = DriverInit.setUpDriver();
        driver.get(Urls.rozetka);
        Set<String> urls = new HashSet<>(Arrays.asList(Urls.accountPage,Urls.automationPractice, Urls.uhomki));
        openLinkInNewTab(driver, urls);
        printAllNamesOfTabs(driver);
        driver.quit();
    }
}
