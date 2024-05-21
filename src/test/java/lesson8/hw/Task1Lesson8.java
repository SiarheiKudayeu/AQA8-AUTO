package lesson8.hw;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import waiters.CustomWaiters;

public class Task1Lesson8 {
    /*1) http://only-testing-blog.blogspot.com/2014/01/textbox.html?

    Написатb програму, яка реалізує дію, показану на "видео1.mp4".
     Після виконання програми на консолі має виводитись інформація в наступному вигляді:
    Автомобілі доступні для вибору:
    Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
    Країни з першої таблиці:
    USA, Russia, Japan, Mexico, India, Malaysia, Greece.
    Країни з другої таблиці:
//    France, Germany, Italy, Spain.

Renault
        */

    @Test
    public void selectPageTest(){
        WebDriver driver = DriverInit.setUpDriver();
        CustomWaiters waiters = new CustomWaiters(driver);
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        Select carList = new Select(driver.findElement(By.id("Carlist")));
        Select leftTable = new Select(driver.findElement(By.name("FromLB")));
        WebElement button = driver.findElement(By.xpath("//input[@onclick='move(this.form.FromLB,this.form.ToLB)']"));
        carList.selectByVisibleText("Renault");
        System.out.println("Автомобілі доступні для вибору:");
        for(WebElement element: carList.getOptions()){
            System.out.print(element.getText() + " ");
        }
        leftTable.selectByVisibleText("France");
        leftTable.selectByVisibleText("Germany");
        leftTable.selectByVisibleText("Italy");
        leftTable.selectByVisibleText("Spain");
        button.click();
        System.out.println();
        System.out.println("Країни з першої таблиці:");
        for (WebElement element: new Select(driver.findElement(By.name("ToLB"))).getOptions()){
            System.out.print(element.getText() + " ");
        }
        System.out.println();
        System.out.println("Країни з другої таблиці:");
        for (WebElement element: new Select(driver.findElement(By.name("FromLB"))).getOptions()){
            System.out.print(element.getText() + " ");
        }
        driver.quit();

    }
}
