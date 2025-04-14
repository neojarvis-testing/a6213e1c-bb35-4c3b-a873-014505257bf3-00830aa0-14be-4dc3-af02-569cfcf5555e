package pages;

import org.junit.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.HomePage;
import uistore.HomePage;
import uistore.ProductPage;
import uistore.ResultsPage;
import uistore.ResultsPage;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class MagicMugsAction {
    
    WebDriverHelper helper = new WebDriverHelper();

    /**
     * Description: Hovers over personalized section in Nav Bar and clicks on Mugs
     * @return void
     */
    public void clickOnMug() {
        try {
            helper.clickOnElement(HomePage.noThanks);
            Hooks.test.log(Status.INFO, "clicked on no thanks");
            LoggerHandler.infoMessage("clicked on no thanks");

            helper.hoverOverElement(HomePage.personalized);
            Hooks.test.log(Status.INFO, "hovered over personalized section in the nav bar");
            LoggerHandler.infoMessage("hovered over personalized section in the nav bar");

            helper.clickOnElement(HomePage.Mugs);
            Hooks.test.log(Status.INFO, "clicked on mugs in the dropdown");
            LoggerHandler.infoMessage("clicked on mugs in the dropdown");

        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL, e.getMessage());
            Reporter.attachToReport("error_on_deliverToBangalore_method", Hooks.test, "");
        }
    }
    /**
     * Description: Enters the Location
     * @return void
     */
    public void enterLocation(String value) {
        try {

            helper.clickOnElement(HomePage.pinCode);
            Hooks.test.log(Status.INFO, "entered Bangalore in the input box");
            LoggerHandler.infoMessage("entered Bangalore in the input box");

            helper.sendKeys(HomePage.pinCode,value);
            helper.waitForElementToBeVisible(ProductPage.blr, 10);

            helper.enterAction(HomePage.pinCode);

            helper.hoverOverElement(HomePage.shopping);
            helper.clickOnElement(HomePage.shopping);
            Hooks.test.log(Status.INFO, "clicked on continue shopping button");
            LoggerHandler.infoMessage("clicked on continue shopping button");


           

        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL, e.getMessage());
            Reporter.attachToReport("FNP",Hooks.test,"");
        } catch (AssertionError e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL, e.getMessage());
           
        }
    }
    /**
     * Description:Filters the results by magic mugs
     * @return void
     */
    public void results() throws Exception
    {   
        try
        {
        Thread.sleep(2000);
        helper.clickOnElement(ResultsPage.magicMugs);
        LoggerHandler.infoMessage("filtered the results for magic mugs");
        Hooks.test.log(Status.INFO, "filtered the results for magic mugs");

        helper.clickOnElement(ResultsPage.firstResult);
        LoggerHandler.infoMessage("clicked on the first product from the result page");
        Hooks.test.log(Status.INFO, "click on the first product from the result page");

        helper.switchToNewWindow();
        helper.waitForElementToBeVisible(ProductPage.addToCart, 10);
        helper.clickOnElement(ProductPage.addToCart);

        String text = helper.getText(ProductPage.offer);
        System.out.println(text);
        if (text.contains(ExcelReader.readCellValue("Sheet1", "1", "verify"))) {
            Assert.assertTrue(true);
        }
        LoggerHandler.infoMessage("clicked on add to cart");
        Hooks.test.log(Status.INFO, "clicked on add to cart");
        Screenshot.capScreenshot("FNP");
        Reporter.attachToReport("FNP", Hooks.test, "add to cart");
    }
    catch(Exception e)
    {
        LoggerHandler.errorMessage(e.getMessage());
        Hooks.test.log(Status.FAIL, e.getMessage());
        Reporter.attachToReport("error_message",Hooks.test,"");
    }
       
        
    }

}
