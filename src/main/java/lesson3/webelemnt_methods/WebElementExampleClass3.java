package lesson3.webelemnt_methods;

import driver_init.DriverInit;
import org.openqa.selenium.*;
import utils.Urls;

public class WebElementExampleClass3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.accountPage);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        }catch (NoSuchElementException e){
            System.out.println("No cookies button");
        }

        System.out.println("=======BEFORE CLICK=======");
        System.out.println("isDisplayed: " + driver.findElement(By.id("RememberMe")).isDisplayed());
        System.out.println("isSelected: " + driver.findElement(By.id("RememberMe")).isSelected());

        driver.findElement(By.id("RememberMe")).click();

        System.out.println("=======AFTER CLICK=======");
        System.out.println("isDisplayed: " + driver.findElement(By.id("RememberMe")).isDisplayed());
        System.out.println("isSelected: " + driver.findElement(By.id("RememberMe")).isSelected());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("file:///C:\\Users\\anduser\\Desktop\\additional\\Enabled\\Enabled.html");

        Thread.sleep(1000);
        System.out.println("======BEFORE ENABLE======");
        System.out.println("isEnabled: " +driver.findElement(By.id("button")).isEnabled());

        driver.findElement(By.id("enableButton")).click();
        System.out.println("======AFTER ENABLE======");
        System.out.println("isEnabled: " +driver.findElement(By.id("button")).isEnabled());
        System.out.println(driver.findElement(By.id("result")).getText());

/*        WebElement element;
        element.findElement(By.xpath("dd"));*/

        driver.quit();

    }
}
