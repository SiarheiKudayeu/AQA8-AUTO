package step_definitions;

import driver_init.DriverInit2;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Urls;
import waiters.CustomWaiters;

public class SeleniumStepDefinitionClass {
    private WebDriver driver;
    private CustomWaiters waiters;

    @FindBy(id = "id_contact")
    private static WebElement select;
    @FindBy(id = "email")
    private static WebElement email;
    @FindBy(id = "id_order")
    private static WebElement id_order;
    @FindBy(id = "message")
    private static WebElement message;
    @FindBy(id = "submitMessage")
    private static WebElement submitMessage;
    @FindBy(css = ".alert.alert-success")
    private static WebElement alertSuccess;

    private static class Strings {
        private static final String selectOptionValue = "Customer service";
        private static final String validMail = "mail@mail.mail";
        private static final String orderId = "123456743";
        private static final String message = "My message for contact Us page";
        private static final String successMessageText = "Your message has been successfully sent to our team.";
    }

    @Before
    public void precondition() {
        System.out.println("precondition");
    }

    @After
    public void closeSeleniumDriver() {
        driver.quit();
    }

    @Given("User is on ContactUs Page Selenium")
    public void user_is_on_contact_us_page_selenium() {
        driver.get(Urls.automationPracticeContactUsPage);
    }

    @Given("set up driver Selenium")
    public void set_up_driver_Selenium() {
        driver = DriverInit2.startDriver();
        waiters = new CustomWaiters(driver);
        PageFactory.initElements(driver, this);
    }

    @When("I select option from heading element Selenium")
    public void i_select_option_from_heading_element_selenium() {
        waiters.waitForVisibility(email);
        Select select1 = new Select(select);
        select1.selectByVisibleText(Strings.selectOptionValue);
    }

    @When("I set valid mail Selenium")
    public void i_set_valid_mail_selenium() {
        email.sendKeys(Strings.validMail);
    }

    @When("I set order ID Selenium")
    public void i_set_order_id_selenium() {
        id_order.sendKeys(Strings.orderId);
    }

    @When("enter text on message field Selenium {string}")
    public void enter_text_on_message_field_selenium(String text) {
        message.sendKeys(text);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

    }

    @When("click send button Selenium")
    public void click_send_button_selenium() {
        submitMessage.click();
    }

    @Then("I see success message on screen Selenium")
    public void i_see_success_message_on_screen_selenium() {
        waiters.waitForVisibility(alertSuccess);
        Assert.assertEquals(alertSuccess.getText(), Strings.successMessageText,
                "Sending message failed!!!");
    }
}
