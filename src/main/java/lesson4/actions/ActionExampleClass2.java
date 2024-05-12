package lesson4.actions;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Urls;

import java.time.Duration;

public class ActionExampleClass2 {

    private static class Locators {
        private static final By records = By.xpath("//a[@href='/records/']");
        private static final By applyAndSet = By.xpath("//a[@href='/records/apply-to-set-or-break-a-record/']");
        private static final By standardApplications = By.xpath("//a[@href='/records/the-application-process/standard-applications']");
        private static final By adjudicator = By.xpath("//a[@href='/records/the-application-process/invite-an-adjudicator']");
        private static final By consultancy = By.xpath("//a[@href='/records/the-application-process/consultancy']");
    }

    public enum Tabs {
        APPLICATIONS, ADJUDICATOR, CONSULTANCY
    }

    public static void openTabFromPageInNewTab(WebDriver driver, Tabs tab) {
        Actions actions = new Actions(driver);
        By locator = null;
        switch (tab) {
            case ADJUDICATOR -> locator = Locators.adjudicator;
            case APPLICATIONS -> locator = Locators.standardApplications;
            case CONSULTANCY -> locator = Locators.consultancy;
        }
        actions.moveToElement(driver.findElement(Locators.records))
                .moveToElement(driver.findElement(Locators.applyAndSet))
                .keyDown(Keys.CONTROL)
                .click(driver.findElement(locator))
                .keyUp(Keys.CONTROL)
                .build().perform();
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.searchPage);

        /*Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Locators.records))
                .pause(Duration.ofSeconds(1))
                        .moveToElement(driver.findElement(Locators.applyAndSet))
                                .build().perform();

        actions.keyDown(Keys.CONTROL)
                        .click(driver.findElement(Locators.adjudicator))
                                .keyUp(Keys.CONTROL)
                                        .build().perform();*/
        openTabFromPageInNewTab(driver, Tabs.APPLICATIONS);
        openTabFromPageInNewTab(driver, Tabs.ADJUDICATOR);
        openTabFromPageInNewTab(driver, Tabs.CONSULTANCY);

        Thread.sleep(2000);
        int i = 1;
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            System.out.println(i + ") " + driver.getTitle());
            i++;
        }

        driver.quit();


    }
}
