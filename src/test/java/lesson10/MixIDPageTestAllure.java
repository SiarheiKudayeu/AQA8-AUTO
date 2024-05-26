package lesson10;

import driver_init.DriverInit2;
import io.qameta.allure.*;
import lesson8.mix_id.MixIDPage;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyAllureTestListeners;

@Listeners({MyAllureTestListeners.class})
public class MixIDPageTestAllure {
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
    @Description("This is check how elements will be dragged to the target area...")
    @Feature("NORMAL Severity test")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://patrilcaster2.testrail.io/index.php?/cases/view/92&group_by=cases:section_id&group_order=asc&display_deleted_cases=0&group_id=24")
    public void dragToAreaTest() throws InterruptedException {
        mixIDPage
                .openMainPage()
                .dragElementToArea2(MixIDPage.ElementsForDragNDrop.STAR)
                .dragElementToArea2(MixIDPage.ElementsForDragNDrop.BALOON)
                .dragElementToArea2(MixIDPage.ElementsForDragNDrop.ROCKET)
                .assertDragNDropElements();
    }
    @Description("This is check how select is working...")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("BLOCKER Severity test")
    @TmsLink("https://patrilcaster2.testrail.io/index.php?/cases/view/93&group_by=cases:section_id&group_order=asc&display_deleted_cases=0&group_id=24")
    @Test
    public void selectTest(){
        mixIDPage
                .openMainPage()
                .selectOption(MixIDPage.Options.TWO)
                .assertSelectedOption(MixIDPage.Options.TWO);
    }
    @Test
    public void clickCounterButtonCheck(){
        int amountOfClicking = 22;
        mixIDPage
                .openMainPage()
                .clickOnCounterButtonNTimes(amountOfClicking)
                .assertValueAfterClickCounterButton(23);
    }

   /*

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
    }*/
}
