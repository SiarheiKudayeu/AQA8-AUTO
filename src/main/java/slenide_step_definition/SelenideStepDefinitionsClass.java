package slenide_step_definition;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Urls;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideStepDefinitionsClass {

    private static class SelenideElements {
        private static final SelenideElement select = $(By.id("id_contact"));
        private static final SelenideElement email = $(By.id("email"));
        private static final SelenideElement message = $(By.id("message"));
        private static final SelenideElement id_order = $(By.id("id_order"));
        private static final SelenideElement submitMessage = $(By.id("submitMessage"));
        private static final SelenideElement alertSuccess = $(By.cssSelector(".alert.alert-success"));
    }

    private static class Strings {
        private static final String selectOptionValue = "Customer service";
        private static final String validMail = "mail@mail.mail";
        private static final String orderId = "123456743";
        private static final String message = "My message for contact Us page";
        private static final String successMessageText = "Your message has been successfully sent to our team.";
    }

    @Given("set up driver Selenide")
    public void set_up_driver_selenide() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
    }

    @Given("User is on ContactUs Page Selenide")
    public void user_is_on_contact_us_page_selenide() {
        open(Urls.automationPracticeContactUsPage);
    }

    @When("I select option from heading element Selenide")
    public void i_select_option_from_heading_element_selenide() {
        SelenideElements.email.shouldBe(Condition.visible);
        SelenideElements.select.selectOptionContainingText(Strings.selectOptionValue);
    }

    @When("I set valid mail Selenide")
    public void i_set_valid_mail_selenide() {
        SelenideElements.email.setValue(Strings.validMail);
    }

    @When("I set order ID Selenide")
    public void i_set_order_id_selenide() {
        SelenideElements.id_order.setValue(Strings.orderId);
    }

    @When("enter text on message field Selenide {string}")
    public void enter_text_on_message_field_selenide(String string) {
        SelenideElements.message.setValue(string);
    }

    @When("click send button Selenide")
    public void click_send_button_selenide() {
        SelenideElements.submitMessage.click();
    }

    @Then("I see success message on screen Selenide")
    public void i_see_success_message_on_screen_selenide() {
        SelenideElements.alertSuccess.shouldBe(Condition.text(Strings.successMessageText));
    }
}
