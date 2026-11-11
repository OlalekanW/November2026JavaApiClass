package pages;
import java.time.Duration;


import org.openqa.selenium.By;
import utilities.WebDriverHelpers;

public class RateCalculatorPage {

    private WebDriverHelpers webDriverHelpers;

    By currencyTextBox_GBP = By.xpath("//input[@class='from-currency p-1']");
    By getCurrencyTextBox_NGN = By.cssSelector("input.to-currency");
    By sendNowButton = By.xpath("//button[@class='send-now m-top-2']");
    By selectBankOption = By.xpath("//*[@class='select-bank p-1']");
    By accountNumberTextBox = By.xpath("//input[@class='account-number p-1 m-top-2']");
    By sendButton = By.xpath("//button[@class='send m-top-2']");
    By successText = By.xpath("//*[@class='success']");



    public RateCalculatorPage(WebDriverHelpers _webDriverHelpers){

        this.webDriverHelpers = _webDriverHelpers;

    }

    public void enterCurrencyValueGBPValue(String currencyValueGBP)throws InterruptedException{

        webDriverHelpers.driver.findElement(currencyTextBox_GBP).sendKeys(currencyValueGBP);
        webDriverHelpers.driver.findElement(currencyTextBox_GBP).clear();
        Thread.sleep(Duration.ofSeconds(5));
        webDriverHelpers.driver.findElement(currencyTextBox_GBP).sendKeys(currencyValueGBP);
    }

    public String enterCurrencyValueNGNValue(){
       return webDriverHelpers.driver.findElement(getCurrencyTextBox_NGN).getAttribute("value");

       //Option 2
       //String nairaConvertedvalue = webDriverHelpers.driver.findElement(getCurrencyTextBox_NGN).getText();
       //return nairaConvertedvalue;
    }
    public void clickOnSendNowButton(){
        webDriverHelpers.driver.findElement(sendNowButton).click();

    }

    public void selectBankFromdropDown(String bankName){
        webDriverHelpers.SelectItemFromDropDown(selectBankOption, bankName);
    }

    public void inputAccountNumber(String accountNumber){
        webDriverHelpers.driver.findElement(accountNumberTextBox).sendKeys(accountNumber);
    }
    public void clickOnSendButton(){
        webDriverHelpers.driver.findElement(sendButton).click();
    }
    public String viewSuccessMessage(){
        return webDriverHelpers.driver.findElement(successText).getText();
    }



}
