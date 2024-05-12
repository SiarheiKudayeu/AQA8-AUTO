package lesson4.select;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Urls;

import java.util.List;

public class SelectClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.ktoKuda);
        Thread.sleep(2000);
        WebElement elementCountries = driver.findElement(By.id("itt_country"));
        Select countries = new Select(elementCountries);

        //select
        countries.selectByVisibleText("Испания");
        Thread.sleep(1000);
        countries.selectByValue("16");
        Thread.sleep(1000);
        countries.selectByIndex(3);
        Thread.sleep(1000);

/*        Select select2 = new Select(driver.findElement(By.cssSelector(".title_parent_child")));
        select2.selectByIndex(3);*/

        //isMultiple
        System.out.println("==================//isMultiple");
        System.out.println(countries.isMultiple());
        Select cities = new Select(driver.findElement(By.id("region_list")));
        System.out.println(cities.isMultiple());

        //getAllOptions
        System.out.println("==================//getAllOptions");
        List<WebElement> allOptions = cities.getOptions();
        for(WebElement element: allOptions){
            System.out.println(element.getText() + " " + element.getAttribute("value"));
        }
        //getAllSelectedOptions();
        System.out.println("==================//getAllSelectedOptions");
        cities.selectByVisibleText("Борш");
        cities.selectByValue("42584");
        cities.selectByVisibleText("Дибра");
        cities.selectByVisibleText("Берат");
        List<WebElement> selectedOptions = cities.getAllSelectedOptions();
        for(WebElement element: selectedOptions) {
            System.out.println(element.getText());
        }

        //deselect
        Thread.sleep(3000);
        cities.deselectByVisibleText("Все регионы");
        Thread.sleep(3000);
        cities.deselectByValue("42584");
        Thread.sleep(3000);
        cities.deselectAll();
        Thread.sleep(3000);
        System.out.println("==================//deselectAll {");
        for(WebElement element: cities.getAllSelectedOptions()) {
            System.out.println(element.getText());
        }
        System.out.println("} ==================//deselectAll");

        countries.selectByValue("16");
        Thread.sleep(3000);

        driver.quit();

    }
}
