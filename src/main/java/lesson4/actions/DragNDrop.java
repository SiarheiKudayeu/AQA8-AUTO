package lesson4.actions;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Urls;

public class DragNDrop {

    private static class Locators {
        private static final By mainMenu = By.xpath("//i[@id='menu-btn']");
        private static final By ouverture = By.cssSelector(".icon-ouverture");
        private static final By projets = By.cssSelector(".icon-projets");
        private static final By courrier = By.cssSelector(".icon-courrier");
        private static final By apropos = By.cssSelector(".icon-apropos");
    }

    public static void dragNDrop(By source, By target, WebDriver driver){
        new Actions(driver).dragAndDrop(driver.findElement(source),
                driver.findElement(target)).perform();
    }

    public static void openRound(WebDriver driver, Rounds rounds) throws InterruptedException {
        driver.get(Urls.dragNDropOne);
        Thread.sleep(4000);
        driver.findElement(Locators.mainMenu).click();
        Thread.sleep(2000);
        By source = null;
        By target = Locators.mainMenu;
        switch (rounds){
            case APROPOS -> source = Locators.apropos;
            case PROJETS -> source = Locators.projets;
            case COURRIER -> source = Locators.courrier;
            case OUVERTURE -> source = Locators.ouverture;
        }
        dragNDrop(source, target, driver);
    }

    public enum Rounds{
        OUVERTURE, PROJETS, COURRIER, APROPOS
    }

    public static void main(String[] args) throws InterruptedException {
        By mainMenu = By.xpath("//i[@id='menu-btn']");
        By ouverture = By.cssSelector(".icon-ouverture");
        By projets = By.cssSelector(".icon-projets");
        By courrier =  By.cssSelector(".icon-courrier");
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.dragNDropOne);
        Thread.sleep(4000);
        driver.findElement(mainMenu).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(ouverture))
                .moveToElement(driver.findElement(mainMenu))
                .release().build().perform();
        Thread.sleep(5000);

        driver.get(Urls.dragNDropOne);
        Thread.sleep(4000);
        driver.findElement(mainMenu).click();
        Thread.sleep(2000);
        actions.dragAndDrop(driver.findElement(projets), driver.findElement(mainMenu)).perform();
        Thread.sleep(5000);

        driver.get(Urls.dragNDropOne);
        Thread.sleep(4000);
        driver.findElement(mainMenu).click();
        Thread.sleep(2000);
        dragNDrop(courrier, mainMenu, driver);
        Thread.sleep(5000);

        openRound(driver, Rounds.APROPOS);
        Thread.sleep(5000);
        driver.quit();
    }
}
