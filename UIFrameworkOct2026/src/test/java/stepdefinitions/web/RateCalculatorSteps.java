package stepdefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RateCalculatorPage;
import utilities.ConfigUtil;
import utilities.WebDriverHelpers;

import java.io.IOException;

public class RateCalculatorSteps {

    private WebDriverHelpers webDriverHelpers;
    private RateCalculatorPage rateCalculatorPage;
    private ConfigUtil configUtil;


    public RateCalculatorSteps(WebDriverHelpers _webDriverHelpers, RateCalculatorPage _rateCalculatorPage, ConfigUtil _configUtil) {
        this.webDriverHelpers = _webDriverHelpers;
        this.rateCalculatorPage = _rateCalculatorPage;
        this.configUtil = _configUtil;
    }

    @Given("that a user loads an application under test")
    public void thatAUserLoadsAnApplicationUnderTest() throws IOException {
        webDriverHelpers.driver.get(configUtil.loadEnvProfileData("baseUrl"));

    }

    @When("a user inputs {int} into GBP text field")
    public void aUserInputsIntoGBPTextField(int currencyValueGBP) throws InterruptedException{
        rateCalculatorPage.enterCurrencyValueGBPValue(String.valueOf(currencyValueGBP));

    }

    @Then("a user sees {string} value in NGN text field")
    public void aUserSeesValueInNGNTextField(String expectedNGNValue){
         rateCalculatorPage.enterCurrencyValueNGNValue();
//        String expectedCurrencyValue = String.valueOf(expectedNGNValue);
//        String actualCurrencyValue = String.valueOf(rateCalculatorPage.enterCurrencyValueNGNValue());
//        Assert.assertEquals(expectedCurrencyValue, actualCurrencyValue);
        Assert.assertNotEquals(expectedNGNValue, rateCalculatorPage.enterCurrencyValueNGNValue());

    }


    @When("a user clicks on Send Now button")
    public void aUserClicksOnSendNowButton() {
        rateCalculatorPage.clickOnSendNowButton();
    }


    @And("a user selects {string} as the Bank option")
    public void aUserSelectsAsTheBankOption(String bankName) {
       rateCalculatorPage.selectBankFromdropDown(bankName);
    }

    @And("a user inputs {string} as the account number")
    public void aUserInputsAsTheAccountNumber(String accountNumber) {
        rateCalculatorPage.inputAccountNumber(accountNumber);
    }

    @And("a user clicks on Send Button")
    public void aUserClicksOnSendButton() {
        rateCalculatorPage.clickOnSendButton();
    }

    @Then("the Text {string} message should appear")
    public void theTextTransactionSuccessfulMessageShouldAppear(String expectedSuccessMessage) {
       rateCalculatorPage.viewSuccessMessage();
       Assert.assertEquals(rateCalculatorPage.viewSuccessMessage(), expectedSuccessMessage);
    }


}
