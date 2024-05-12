package lesson4.actions;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Urls;

public class ActionExampleClass1 {

    private static class Locators{
        private static final By records = By.xpath("//a[@href='/records/']");
        private static final By applyAndSet = By.xpath("//a[@href='/records/apply-to-set-or-break-a-record/']");
        private static final By standardApplications = By.xpath("//a[@href='/records/the-application-process/standard-applications']");
        private static final By adjudicator = By.xpath("//a[@href='/records/the-application-process/invite-an-adjudicator']");
        private static final By consultancy = By.xpath("//a[@href='/records/the-application-process/consultancy']");
    }
    public enum Tabs {
        APPLICATIONS, ADJUDICATOR, CONSULTANCY
    }

    public static void openTabFromPage(WebDriver driver, Tabs tab){
        Actions actions = new Actions(driver);
        By locator = null;
        switch (tab){
            case ADJUDICATOR -> locator = Locators.adjudicator;
            case APPLICATIONS -> locator = Locators.standardApplications;
            case CONSULTANCY -> locator = Locators.consultancy;
        }
        actions.moveToElement(driver.findElement(Locators.records))
                .moveToElement(driver.findElement(Locators.applyAndSet))
                .click(driver.findElement(locator))
                .build().perform();
    }

    public static void navigateBack(WebDriver driver){
        driver.navigate().back();
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.searchPage);
        //driver.findElement(Locators.standardApplications).click();

        /*Actions actions = new Actions(driver);
        WebElement moveTargetOne = driver.findElement(Locators.records);
        actions.moveToElement(moveTargetOne).perform();

        actions.moveToElement(driver.findElement(Locators.applyAndSet))
                .moveToElement(driver.findElement(Locators.standardApplications))
                .click()
                .build().perform();
        Thread.sleep(4000);*/

        openTabFromPage(driver, Tabs.APPLICATIONS);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        navigateBack(driver);

        openTabFromPage(driver, Tabs.ADJUDICATOR);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        navigateBack(driver);

        openTabFromPage(driver, Tabs.CONSULTANCY);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        navigateBack(driver);
        driver.quit();


    }
}
