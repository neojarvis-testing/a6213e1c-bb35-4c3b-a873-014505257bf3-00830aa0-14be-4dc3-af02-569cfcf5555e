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

public class Flowers {
    WebDriverHelper helper = new WebDriverHelper();
    /**
     * Dscription: hovers over Anniversary in the NavBar and clicks on flowers
     * @return void
     */
    public void clickOnFlowers() {
        try {
            helper.clickOnElement(HomePage.noThanks);
            LoggerHandler.infoMessage("clicked on no thanks");
            Hooks.test.log(Status.INFO,"clicked on no thanks");

            helper.clickOnElement(HomePage.location);
            helper.clickOnElement(HomePage.pinCode);


            helper.sendKeys(HomePage.pinCode, ExcelReader.readCellValue("Sheet1", "2", "city"));
            LoggerHandler.infoMessage("Entered the location as Chennai");
            Hooks.test.log(Status.INFO,"Entered the location as Chennai");
            LoggerHandler.infoMessage("verify the pincode");

            helper.waitForElementToBeVisible(ProductPage.chn, 10);

            helper.enterAction(HomePage.pinCode);

            helper.hoverOverElement(HomePage.continueShoppping);
            helper.clickOnElement(HomePage.continueShoppping);

            LoggerHandler.infoMessage("Clicked on continue shopping");
            Hooks.test.log(Status.INFO,"Clicked on continue shopping");

            helper.hoverOverElement(HomePage.anniversary);
            LoggerHandler.infoMessage("hovered over anniversary");
            Hooks.test.log(Status.INFO,"hovered over anniversary");

            helper.clickOnElement(HomePage.flowers);
            LoggerHandler.infoMessage("clicked on flowers in the dropdown");
            Hooks.test.log(Status.INFO,"clicked on flowers in the dropdown");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Description: Enters the location as Chennai from feature file
     * @return void
     */
    public void locationChennai(String value) {
        try {
           

            helper.clickOnElement(HomePage.location);
            helper.clickOnElement(HomePage.pinCode);

            helper.sendKeys(HomePage.pinCode, value);
            helper.waitForElementToBeVisible(ProductPage.chn, 15);

            helper.enterAction(HomePage.pinCode);

            helper.clickOnElement(HomePage.continueShopppingBtn);
            Thread.sleep(2000);

        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }
    }
    /**
     * Description: filters the result by roses
     * @return void
     * 
     */
    public void clickOnRoses()
    {
        helper.clickOnElement(ResultsPage.roses);
        LoggerHandler.infoMessage("filtered the results by roses");
        Hooks.test.log(Status.INFO,"filtered the results by roses");
    }
    /**
     * Description: clicks on Buy now
     * @return void
     */
    public void clickOnBuyNow()
    {   
        try {

        helper.clickOnElement(ResultsPage.firstResult);
        LoggerHandler.infoMessage("clicked the first result");
        Hooks.test.log(Status.INFO,"clicked the first result");

        helper.switchToNewWindow();

        helper.clickOnElement(ProductPage.buyNow);
        LoggerHandler.infoMessage("clicked on buy now");
        Hooks.test.log(Status.INFO,"clicked on buy now");
        helper.clickOnElement(HomePage.cart);
        LoggerHandler.infoMessage("clicked on the cart");
        Hooks.test.log(Status.INFO,"clicked on the cart");
        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }
        
    }

}
