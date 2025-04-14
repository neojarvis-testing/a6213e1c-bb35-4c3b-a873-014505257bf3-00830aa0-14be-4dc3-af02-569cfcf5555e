package pages;

import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.HomePage;
import uistore.ProductPage;
import uistore.ResultsPage;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;

public class CakeFnpActions {
    WebDriverHelper helper = new WebDriverHelper();
    
   /**
    * clicks on no thanks ans clicks on search bar
    * @return void
    */

    public void SearchBar(String string) {

        try {
            helper.clickOnElement(HomePage.noThanks);
            helper.waitForElementToBeVisible(HomePage.searchbar, 10);
            helper.clickOnElement(HomePage.searchbar);
            helper.sendKeys(HomePage.searchbar, string);
            helper.waitForElementToBeVisible(HomePage.searchbar, 10);
            helper.enterAction(HomePage.searchbar);
            LoggerHandler.infoMessage("Enter cake in the search bar");
            Hooks.test.log(Status.INFO, "Enter cake in the search bar");
        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }

    }

    /*Providing the location as Delhi 
     * @return void
    */
    public void deliverToDelhi() {
        try {

            helper.clickOnElement(HomePage.location);
            helper.clickOnElement(HomePage.pinCode);

            helper.sendKeys(HomePage.pinCode, ExcelReader.readCellValue("Sheet1", "3", "city"));

            helper.waitForElementToBeVisible(ProductPage.delhi, 10);
            helper.enterAction(HomePage.pinCode);
            helper.waitForElementToBeVisible(HomePage.continueShopppingBtn, 10);
            helper.hoverOverElement(HomePage.continueShopppingBtn);
            helper.clickOnElement(HomePage.continueShopppingBtn);
            LoggerHandler.infoMessage("Enter the Location as Delhi");
            Hooks.test.log(Status.INFO, "Enter the Location as Delhi");
        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }

    }

    /* In Filter Section
     * Click on Flavour
     * Then click on Chocolate
     * @return void
    */
    public void ClickonFilter() {

        try {
            helper.clickOnElement(ResultsPage.clickonflavour);
            helper.clickOnElement(ResultsPage.clickonchocolate);
            LoggerHandler.infoMessage("Click on Flavour");
            LoggerHandler.infoMessage("Click on Chocolate");
            Hooks.test.log(Status.INFO, "Click on Flavour and click on Chocolate");
        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }

    }

    /* Click on the First Product 
    And Click on Buy Now 
    Then Capture the screenshot*/
    public void FirstProduct(){
        try {
            helper.waitForElementToBeVisible(ResultsPage.firstResult, 10);
            helper.clickOnElement(ResultsPage.firstResult);
            LoggerHandler.infoMessage("Click on First Product");
            Hooks.test.log(Status.INFO, "Click on First Product");
            helper.switchToNewWindow();
            helper.clickOnElement(ProductPage.buyNow);
            LoggerHandler.infoMessage("Click on Buy Now");
            Hooks.test.log(Status.INFO, "Click on Buy Now");
            helper.assertPageText(ProductPage.addToCart, "Add To Cart");
            Screenshot.capScreenshot("Birthday Cake");
            LoggerHandler.infoMessage("Test Case 02 Passed");
            Hooks.test.log(Status.INFO, "Test Case 02 Passed");
        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }
    }


}
