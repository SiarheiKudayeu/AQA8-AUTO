package lesson8.mix_id;

import driver_init.DriverInit2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners2;

@Listeners({MyTestListeners2.class})
public class MixIDPageTest {
    private WebDriver driver;
    private MixIDPage mixIDPage;
    @BeforeClass
    public void setUp(){
        driver = DriverInit2.startDriver();
        mixIDPage = new MixIDPage(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    public void dragToAreaTest() throws InterruptedException {
        mixIDPage
                .openMainPage()
                .dragElementToArea2(MixIDPage.ElementsForDragNDrop.STAR)
                .dragElementToArea2(MixIDPage.ElementsForDragNDrop.BALOON)
                .dragElementToArea2(MixIDPage.ElementsForDragNDrop.ROCKET)
                .assertDragNDropElements();
    }

    @Test
    public void selectTest(){
        mixIDPage
                .openMainPage()
                .selectOption(MixIDPage.Options.TWO)
                .assertSelectedOption(MixIDPage.Options.TWO);
    }

    @Test
    public void doubleClickButtonTest(){
        mixIDPage
                .openMainPage()
                .clickDoubleClickButton()
                .assertDoubleClickAlert();
    }
    @Test
    public void clickCounterButtonCheck(){
        int amountOfClicking = 22;
        mixIDPage
                .openMainPage()
                .clickOnCounterButtonNTimes(amountOfClicking)
                .assertValueAfterClickCounterButton(amountOfClicking);
    }
    @Test
    public void checkAnimalGeneration() throws InterruptedException {
        String animal = "Медведь";
        mixIDPage.openMainPage()
                .clickUntilAnimalWillBeFound(animal)
                .assertAnimalResultField(animal);
    }
}
