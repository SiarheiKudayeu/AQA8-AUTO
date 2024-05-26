package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsStepDefinition {
    @Given("User is on ContactUs Page")
    public void user_is_on_contact_us_page() {
        System.out.println("user_is_on_contact_us_page");
    }
    @When("I select option from heading element")
    public void i_select_option_from_heading_element() {
        System.out.println("i_select_option_from_heading_element");
    }
    @When("I set valid mail")
    public void i_set_valid_mail() {
        System.out.println("i_set_valid_mail");
    }
    @When("I set order ID")
    public void i_set_order_id() {
        System.out.println("i_set_order_id");
    }
    @When("enter text on message field")
    public void enter_text_on_message_field() {
        System.out.println("enter_text_on_message_field");
    }
    @When("click send button")
    public void click_send_button() {
        System.out.println("click_send_button");
    }
    @Then("I see success message on screen")
    public void i_see_success_message_on_screen() {
        System.out.println("i_see_success_message_on_screen");
    }
}
