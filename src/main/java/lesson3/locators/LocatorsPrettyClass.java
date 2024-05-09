package lesson3.locators;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsPrettyClass {

    private static class Locators {
        private static final By searchField = By.xpath("//input[@placeholder='Search']");
        private static final By searchButton = By.xpath("//*[text()='Search']");
        private static final By applicationProcess = By.xpath("//a[contains(text(), 'LICATION PROC')]");
        private static final By showcaseList = By.xpath("//a[contains(@href, 's/showcase')]");
        private static final By acceptCookies = By.id("ez-accept-all");
        private static final By emailField = By.xpath("(//div[@class='container'])[1]//*[@id='Username']");
    }

    private static class Urls {
        private static final String searchPage = "https://www.guinnessworldrecords.com/search?term=%2A#";
        private static final String appleRecordPage = "https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/";
        private static final String accountPage = "https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount";
    }

    private static class Data {
        private static final String searchValue = "Tallest man";
        private static final String userName = "AQA8";
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.searchPage);
        Thread.sleep(2000);
        driver.findElement(Locators.searchField).sendKeys(Data.searchValue);
        driver.findElement(Locators.searchButton).click();


        Thread.sleep(4000);
        driver.get(Urls.appleRecordPage);

        driver.findElement(Locators.applicationProcess).click();

        List<WebElement> webElementList = driver.findElements(Locators.showcaseList);
        System.out.println(webElementList.size());
        webElementList.get(10).click();
        Thread.sleep(4000);

        driver.get(Urls.accountPage);
        Thread.sleep(2000);
        try {
            driver.findElement(Locators.acceptCookies).click();
        } catch (NoSuchElementException e) {
            System.out.println("No cookies button");
        }
        driver.findElement(Locators.emailField).sendKeys(Data.userName);
        driver.quit();
    }
}
