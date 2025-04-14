package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import stepdefinition.Hooks;
import uistore.HomePage;
import uistore.ProductPage;
import uistore.ResultsPage;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class LifeStyleFnpActions {

     WebDriverHelper helper = new WebDriverHelper();

     /* Click on No Thanks 
       And hover over LifeStyle
       And Click on Jewellery */
     public void NavBar(){

       try {
        helper.clickOnElement(HomePage.noThanks);
            
        helper.hoverOverElement(HomePage.hoverlifestyle);
        LoggerHandler.infoMessage("Hover over LifeStyle");
        Hooks.test.log(Status.INFO, "Hover over LifeStyle");
        helper.clickOnElement(HomePage.jewellery);
        LoggerHandler.infoMessage("Click on Jewellery");
        Hooks.test.log(Status.INFO, "Click on Jewellery");
       } catch (Exception e) {
        LoggerHandler.errorMessage(e.getMessage());
       }
     }
     /* Providing the Location as Kolkata 
      And Click on Rings */
     public void delivertoKolkata(){
        
       try {
        helper.clickOnElement(HomePage.location);
        helper.clickOnElement(HomePage.pinCode);
        
        helper.sendKeys(HomePage.pinCode, ExcelReader.readCellValue("Sheet1","4","city"));
        
        helper.waitForElementToBeVisible(ProductPage.kolkata, 10);
        helper.enterAction(HomePage.pinCode);
        helper.waitForElementToBeVisible(HomePage.continueShopppingBtn, 10);
        helper.hoverOverElement(HomePage.continueShopppingBtn);
        helper.clickOnElement(HomePage.continueShopppingBtn);
        

        helper.clickOnElement(ResultsPage.rings);
        helper.clickOnElement(HomePage.location);
        helper.clickOnElement(HomePage.pinCode);
        
        helper.sendKeys(HomePage.pinCode, ExcelReader.readCellValue("Sheet1","4","city"));
        
        helper.waitForElementToBeVisible(ProductPage.kolkata, 10);
        helper.enterAction(HomePage.pinCode);
        helper.waitForElementToBeVisible(HomePage.continueShopppingBtn, 10);
        helper.hoverOverElement(HomePage.continueShopppingBtn);
        helper.clickOnElement(HomePage.continueShopppingBtn);
        LoggerHandler.infoMessage("Enter the Location as Kolkata");
        Hooks.test.log(Status.INFO, "Enter the Location as Kolkata");
       } catch (Exception e) {
        LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
       }

       
    }

    /* Click on First Product and click on Add to Cart 
     * Then capture the screenshot and attach to the report 
    */
    public void FirstProduct(ExtentTest test){
       try {
        helper.clickOnElement(ResultsPage.firstResult);
        LoggerHandler.infoMessage("Click on First Product");
        Hooks.test.log(Status.INFO, "Click on First Product");
        helper.switchToNewWindow();
        helper.clickOnElement(ProductPage.addToCart);
        LoggerHandler.infoMessage("Click on Add to Cart");
        Hooks.test.log(Status.INFO, "Click on Add to Cart");
        Screenshot.takeScreenShotWithHighlight(ProductPage.addToCart,"FNP");
        Reporter.attachToReport("FNP",test,"Rings");
        LoggerHandler.infoMessage("Test Case 10 Passed");
        Hooks.test.log(Status.INFO, "Test Case 10 Passed");
       } catch (Exception e) {
        LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
       }
    }
}
