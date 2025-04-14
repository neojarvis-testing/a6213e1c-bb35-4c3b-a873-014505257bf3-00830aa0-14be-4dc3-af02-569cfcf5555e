package pages;

import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.HomePage;
import uistore.ProductPage;
import uistore.ResultsPage;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class HealthyHampers {

     WebDriverHelper helper = new WebDriverHelper();
    /**
     * Description: Hovers over Combos in the Bav Nar and clicks on HealthyHampers
     * @return void
     */
      public void healthyHamper()
    {   
        try
        {
        helper.clickOnElement(HomePage.noThanks);
        helper.clickOnElement(HomePage.location);
        helper.clickOnElement(HomePage.pinCode);

        helper.sendKeys(HomePage.pinCode, ExcelReader.readCellValue("Sheet1", "1", "city"));
        helper.waitForElementToBeVisible(ProductPage.blr, 10);

        helper.enterAction(HomePage.pinCode);
      
        helper.clickOnElement(HomePage.continueShoppping);
        Thread.sleep(2000);
        helper.hoverOverElement(HomePage.combos);
        LoggerHandler.infoMessage("hovered over combos");
        Hooks.test.log(Status.INFO,"hovered over combos");
        helper.clickOnElement(HomePage.hamper);
        LoggerHandler.infoMessage("clicked on healthy hampers");
        Hooks.test.log(Status.INFO,"clicked on healthy hampers");
        }
        catch(Exception e)
        {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }
    }
    /**
     * Description: enters the location as Bangalore
     * @return void
     */
    public void locationBlr(String value)
    {   
        try
        {
        
        helper.clickOnElement(HomePage.location);
        helper.clickOnElement(HomePage.pinCode);
        helper.sendKeys(HomePage.pinCode, value);

        helper.waitForElementToBeVisible(ProductPage.blr, 10);

        helper.enterAction(HomePage.pinCode);

        helper.clickOnElement(HomePage.continueShopppingBtn);
        Thread.sleep(2000);
        }
        catch(Exception e)
        {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }
    }
    /**
     * Description: filters the result as Availability true
     * @return void
     */
    public void availabilityTrue()
    {
        try {
        helper.clickOnElement(ResultsPage.availability);
        LoggerHandler.infoMessage("clicked on availability");
        Hooks.test.log(Status.INFO,"clicked on availability");
        helper.clickOnElement(ResultsPage.filterTrue);
        LoggerHandler.infoMessage("filter the results by availability true");
        Hooks.test.log(Status.INFO,"filter the results by availability true");
        helper.clickOnElement(ResultsPage.firstResult);
        
        helper.switchToNewWindow();
       
        helper.clickOnElement(ProductPage.addToCart);
        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }
    }
    
}
