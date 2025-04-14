
package pages;

import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.HomePage;
import uistore.ProductPage;
import uistore.ResultsPage;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class HeaderAction extends Base {
    WebDriverHelper helper = new WebDriverHelper();
    /**
     * Description:user specify the location and verify the pincode
     * @param delhi
     * @param pincode
     */
    public void specifyLocation(String delhi,String pincode) {
        try {
             helper.clickOnElement(HomePage.noThanks);
            LoggerHandler.infoMessage("Clikced on NoThanks");


            helper.clickOnElement(HomePage.location);
            helper.clickOnElement(HomePage.pinCode);
            helper.sendKeys(HomePage.pinCode, delhi);
            helper.waitForElementToBeVisible(ProductPage.delhi, 20);
            helper.clickOnElement(ProductPage.delhi);
            helper.hoverAndClick(HomePage.shopping);
            LoggerHandler.infoMessage("Entered Delhi in LocationBox");
            Hooks.test.log(Status.PASS, "Entered Delhi in LocationBox");


            helper.assertPageText(HomePage.locationnew,pincode);
            LoggerHandler.infoMessage("verify the pincode");
            Screenshot.capScreenshot("verify the pincode");
            Reporter.attachToReport("verify the pincode",Hooks.test,"verified screenshot");
            
            Hooks.test.log(Status.INFO,"verify the pincode");

        } catch (Exception e) {
            LoggerHandler.infoMessage(e.getMessage());
        }
    }
    /**
     *  Description:user search for pen in search bar
     * @param pen
     */
    public void searchPen(String pen) {

        try {
           
            helper.clickOnElement(HomePage.searchbar);
            helper.sendKeys(HomePage.searchbar, pen);
            helper.enterAction(HomePage.searchbar);
            helper.clickOnElement(ResultsPage.firstPen);
            LoggerHandler.infoMessage("Clikced on FirstProduct");
            Hooks.test.log(Status.PASS, "Clikced on FirstProduct");
            helper.switchToNewWindow();
            helper.hoverOverElement(HomePage.add);
            helper.clickOnElement(HomePage.add);
        } catch (Exception e) {
            LoggerHandler.infoMessage(e.getMessage());
        }
    }   
       /**
        *  Description:user click on add to cart
        */
        public void addtocart(){
            try{
            LoggerHandler.infoMessage("Clikced on AddToCart");
            Screenshot.capScreenshot("Add To Cart");
            Reporter.attachToReport("Add To Cart verification", Hooks.test,"verified screenshot");
        } catch (Exception e) {
            LoggerHandler.infoMessage(e.getMessage());
        }
    }
}
