package lesson8.mix_id;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Urls;
import waiters.CustomWaiters;

public class MixIDPage {

    private static final class Labels{
        private static final String doubleClickAlertMessage = "Double click!";
    }
    private WebDriver driver;
    private CustomWaiters waiters;

    public MixIDPage(WebDriver driver) {
        this.driver = driver;
        waiters = new CustomWaiters(driver);
        PageFactory.initElements(driver, this);
    }

    public enum ElementsForDragNDrop {
        STAR, ROCKET, PIZZA, BALOON, APPLE
    }

    public enum Options{
        ONE, TWO,THREE
    }


    @FindBy(id = "star")
    private static WebElement star;
    @FindBy(id = "apple")
    private static WebElement apple;
    @FindBy(id = "baloon")
    private static WebElement baloon;
    @FindBy(id = "pizza")
    private static WebElement pizza;
    @FindBy(id = "rocket")
    private static WebElement rocket;
    @FindBy(id = "dragArea2")
    private static WebElement dragArea2;
    @FindBy(id = "select")
    private static WebElement select;
    @FindBy(id = "doubleClickButton")
    private static WebElement doubleClickButton;
    @FindBy(id = "clickCounterButton")
    private static WebElement counterButton;
    @FindBy(id = "clickCounter")
    private static WebElement clickCounter;
    @FindBy(id="randomAnimal")
    private static WebElement animalResultElement;
    @FindBy(id="generateAnimalButton")
    private static WebElement generateAnimalButton;

    public MixIDPage dragElementToArea2(ElementsForDragNDrop element){
        Actions actions = new Actions(driver);
        WebElement source = null;
        switch (element){
            case STAR -> source = star;
            case APPLE -> source = apple;
            case BALOON -> source = baloon;
            case PIZZA -> source = pizza;
            case ROCKET -> source = rocket;
        }
        actions.dragAndDrop(source, dragArea2).perform();
        return this;
    }
    public MixIDPage selectOption(Options option){
        Select selectElement = new Select(select);
        String text = null;
        switch (option) {
            case ONE -> text = "Option 1";
            case TWO -> text = "Option 2";
            case THREE -> text = "Option 3";
        }
        selectElement.selectByVisibleText(text);
        return this;
    }

    public MixIDPage clickUntilAnimalWillBeFound(String animal){
        do {
            generateAnimalButton.click();
        }while (!animalResultElement.getText().contains(animal));
        return this;
    }
    public MixIDPage assertAnimalResultField(String animalName){
        Assert.assertEquals(animalResultElement.getText(), (animalName + ": " + "\uD83D\uDC3B"));
        return this;
    }

    public MixIDPage assertSelectedOption(Options option){
        Select selectElement = new Select(select);
        String text = null;
        switch (option) {
            case ONE -> text = "Option 1";
            case TWO -> text = "Option 2";
            case THREE -> text = "Option 3";
        }
        Assert.assertEquals(selectElement.getFirstSelectedOption().getText(), text);
        return this;
    }

    public MixIDPage openMainPage() {
        driver.get(Urls.mixIDage);
        waiters.waitForVisibility(star);
        return this;
    }
    public MixIDPage clickOnCounterButtonNTimes(int amount){
        for (int i = 0; i < amount; i++){
            counterButton.click();
        }
        return this;
    }

    public void assertValueAfterClickCounterButton(int amount){
        Assert.assertEquals(Integer.parseInt(clickCounter.getText()), amount);
    }

    public MixIDPage clickDoubleClickButton(){
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        return this;
    }

    public MixIDPage assertDoubleClickAlert(){
        Alert alert = waiters.switchToAlert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals(alertText, Labels.doubleClickAlertMessage);
        return this;
    }

    public MixIDPage assertDragNDropElements(){
        Assert.assertTrue(dragArea2.getText().contains("\uD83D\uDE80"));
        Assert.assertTrue(dragArea2.getText().contains("\uD83C\uDF88"));
        Assert.assertTrue(dragArea2.getText().contains("\uD83C\uDF1F"));
        return this;
    }
}
