package lesson9;

import driver_init.DriverInit2;
import lesson8.mix_id.MixIDPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners2;
import utils.MyTestRailListener;

@Listeners({MyTestRailListener.class})
public class MixIDPageTestTestNGIntegration {
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
    public void dragToAreaTest_C92() throws InterruptedException {
        mixIDPage
                .openMainPage()
                .dragElementToArea2(MixIDPage.ElementsForDragNDrop.STAR)
                .dragElementToArea2(MixIDPage.ElementsForDragNDrop.BALOON)
                .dragElementToArea2(MixIDPage.ElementsForDragNDrop.ROCKET)
                .assertDragNDropElements();
    }

    @Test
    public void selectTest_C93(){
        mixIDPage
                .openMainPage()
                .selectOption(MixIDPage.Options.TWO)
                .assertSelectedOption(MixIDPage.Options.TWO);
    }

    @Test
    public void doubleClickButtonTest_C94(){
        mixIDPage
                .openMainPage()
                .clickDoubleClickButton()
                .assertDoubleClickAlert();
    }
    @Test
    public void clickCounterButtonCheck_C95(){
        int amountOfClicking = 22;
        mixIDPage
                .openMainPage()
                .clickOnCounterButtonNTimes(amountOfClicking)
                .assertValueAfterClickCounterButton(amountOfClicking);
    }
    @Test
    public void checkAnimalGeneration_C96() throws InterruptedException {
        String animal = "Медведь";
        mixIDPage.openMainPage()
                .clickUntilAnimalWillBeFound(animal)
                .assertAnimalResultField(animal);
    }

    @Test
    public void clickCounterButtonCheckNegative_C102(){
        int amountOfClicking = 22;
        mixIDPage
                .openMainPage()
                .clickOnCounterButtonNTimes(amountOfClicking)
                .assertValueAfterClickCounterButton(23);
    }
}
