package stepdefinitions.api;

import DataModel.RateDataModel;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import webservices.RateCalServices;

import java.util.List;
import java.util.Map;

public class RateCalSteps {

    private RateCalServices rateCalServices;
    Response response;

    private RateDataModel rateDataModel;
    RateDataModel.RateDataModelBuilder rateDataModelBuilder = RateDataModel.builder();

    public RateCalSteps (RateCalServices _rateCalServices){
        this.rateCalServices = _rateCalServices;
    }
    @Given("that a user makes a Get request to get rate")
    public void thatAUserMakesAGetRequestToGetRate() {
       response = rateCalServices.getRate();
    }

    @And("i should get a {int} status code")
    public void iShouldGetAStatusCode(int statusCode) {
       // response.statusCode();
        Assert.assertEquals(statusCode, response.statusCode());
    }

    @Then("i should be able to get a correct rate")
    public void iShouldBeAbleToGetACorrectRate(List<Map<String, String>> rateData) {
        String expectedFromCurrency = rateData.getFirst().get("fromCurrency");
        String actualFromCurrency = response.jsonPath().get("fromCurrency");
        Assert.assertEquals(expectedFromCurrency,actualFromCurrency);
        //response.jsonPath().get("rate");
    }

    @Given("that a user make a Post request to set rate")
    public void thatAUserMakeAPostRequestToSetRate(List<Map<String, String>> rateData) {
        rateDataModel = rateDataModelBuilder
                .rate(Integer.parseInt(rateData.getFirst().get("rate")))
                .fromCurrency(rateData.getFirst().get("fromCurrency"))
                .toCurrency(rateData.getFirst().get("toCurrency")).build();
        response = rateCalServices.createNewRate(rateDataModel);
    }

    @Then("the response message should be {string}")
    public void theResponseMessageShouldBe(String successMsg) {
       // response.jsonPath().get("message");
        Assert.assertEquals(successMsg,  response.jsonPath().get("message"));

    }
}
