package lesson5.data_picker;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Urls;

import java.time.LocalDate;
import java.util.Date;

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

    private static class Locators {
        private static final By calendar = By.id("datePickerMonthYearInput");

    }

    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.dataPickerPage);
        choseTomorrowsDate(driver);
    }
}
