package lesson3.locators;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LocatorsPageFactoryClass {

    @FindBy(xpath = "//input[@placeholder='Search']")
    private static WebElement searchField;

    @FindBy(xpath = "//*[text()='Search']")
    private static WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(), 'LICATION PROC')]")
    private static WebElement applicationProcess;

    @FindBy(xpath = "//a[contains(@href, 's/showcase')]")
    private static List<WebElement> showcaseList;

    @FindBy(id = "ez-accept-all")
    private static WebElement acceptCookies;

    @FindBy(xpath = "(//div[@class='container'])[1]//*[@id='Username']")
    private static WebElement emailField;

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
        //LocatorsPageFactoryClass factoryClass = new LocatorsPageFactoryClass();
        PageFactory.initElements(driver, new LocatorsPageFactoryClass());
        driver.get(Urls.searchPage);
        Thread.sleep(2000);
        searchField.sendKeys(Data.searchValue);
        searchButton.click();

        Thread.sleep(4000);
        driver.get(Urls.appleRecordPage);
        applicationProcess.click();

        List<WebElement> webElementList = showcaseList;
        System.out.println(webElementList.size());
        webElementList.get(10).click();
        Thread.sleep(4000);

        driver.get(Urls.accountPage);
        Thread.sleep(2000);
        try {
            acceptCookies.click();
        } catch (NoSuchElementException e) {
            System.out.println("No cookies button");
        }
        emailField.sendKeys(Data.userName);
        driver.quit();
    }
}
