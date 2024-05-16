package lesson6.data_picker;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Urls;

import java.time.LocalDate;

public class DataPickerClass {

    public static void choseTomorrowsDate(WebDriver driver) {
        driver.findElement(Locators.calendar).click();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        int dayOfTomorrow = tomorrow.getDayOfMonth();
        String month = String.valueOf(tomorrow.getMonth());
        String monthCase = "";
        String monthCase2 = "";
        monthCase = monthCase + month.charAt(0);
        for (int i = 0; i < month.length(); i++) {
            if (i == 0) {
                continue;
            }
            monthCase2 = monthCase2 + month.charAt(i);
        }
        monthCase = monthCase + monthCase2.toLowerCase();
        String xpath = "//div[contains(@aria-label, '" + monthCase + "')][text()='" + dayOfTomorrow + "']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void choseDateAndTime(WebDriver driver, int year, String month, int date, String time) throws InterruptedException {
        driver.findElement(Locators.calendarWithTime).click();
        driver.findElement(Locators.year).click();
        while (Integer.parseInt(driver.findElement(Locators.yearFirstButton).getText()) < year){
            driver.findElements(Locators.yearList).get(0).click();
        }
        while (Integer.parseInt(driver.findElement(Locators.yearLastButton).getText()) > year){
            driver.findElements(Locators.yearList).get(driver.findElements(Locators.yearList).size()-1).click();
        }
        driver.findElement(By.xpath("//div[@class='react-datepicker__year-option'][text()='"+year+"']")).click();
        driver.findElement(Locators.monthSelector).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__month-option'][text()='"+month+"']")).click();

        String xpath = "//div[contains(@aria-label, '" + month + "')][text()='" + date + "']";
        driver.findElement(By.xpath(xpath)).click();
        driver.findElement(By.xpath("//li[@class='react-datepicker__time-list-item '][text()='"+time+"']")).click();
    }

    private static class Locators {
        private static final By calendar = By.id("datePickerMonthYearInput");
        private static final By calendarWithTime = By.id("dateAndTimePickerInput");
        private static final By year = By.cssSelector(".react-datepicker__year-read-view--selected-year");
        private static final By yearList = By.xpath("//div[@class='react-datepicker__year-option']");
        private static final By yearUpButton = By.xpath("(//div[@class='react-datepicker__year-option'])[1]");
        private static final By yearDownButton = By.xpath("(//div[@class='react-datepicker__year-option'])[12]");
        private static final By yearFirstButton = By.xpath("(//div[@class='react-datepicker__year-option'])[2]");
        private static final By yearLastButton = By.xpath("(//div[@class='react-datepicker__year-option'])[11]");
        private static final By monthSelector = By.cssSelector(".react-datepicker__month-read-view--selected-month");


    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.dataPickerPage);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400)");
        choseDateAndTime(driver, 2016, "April", 25, "13:30");
        Thread.sleep(7000);
        choseDateAndTime(driver, 2035, "March", 10, "10:00");
        Thread.sleep(7000);
        driver.quit();
    }
}
