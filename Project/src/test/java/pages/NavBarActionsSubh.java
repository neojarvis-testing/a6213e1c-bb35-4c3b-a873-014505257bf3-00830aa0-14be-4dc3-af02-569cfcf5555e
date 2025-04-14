package pages;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

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
import utils.Base;

public class NavBarActionsSubh {
  WebDriverHelper helper = new WebDriverHelper();

  /**
   * Description:enter the delivery Location
   *
   * @param N/A
   */
  public void whereToDeliver() {
    try {
      helper.clickOnElement(HomePage.noThanks);
      helper.clickOnElement(HomePage.location);
      helper.clickOnElement(HomePage.pinCode);
      helper.sendKeys(HomePage.pinCode, ExcelReader.readCellValue("Sheet1", "2", "city"));
      helper.enterAction(HomePage.pinCode);
      helper.clickOnElement(ProductPage.chn);
      //Thread.sleep(3000);
      WebElement element = Base.driver.findElement(HomePage.pinCode);
      String str = element.getDomAttribute("value");
      System.out.println(str);
      Assert.assertTrue(str.contains(ExcelReader.readCellValue("Sheet1", "1", "pincode")));
      LoggerHandler.infoMessage("verify the pincode");

      helper.clickOnElement(HomePage.shopping);
      Hooks.test.log(Status.PASS, "Delivery Location Given");
      LoggerHandler.infoMessage("Delivery Location Given");

    } catch (Exception e) {
      LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
    }
  }

  /**
   * Description: search the cake
   * 
   * @param N/A
   */
  public void birthdayCakeSearch() {
    try {
      helper.hoverOverElement(HomePage.cakes);
      helper.clickOnElement(HomePage.birthdayCake);
      helper.hoverOverElement(ResultsPage.sameDayDelivery);
      helper.clickOnElement(ResultsPage.sameDayDelivery);
      Screenshot.capScreenshot("sameDayDelivery");
      Hooks.test.log(Status.PASS, "Screenshot taken for Same Day delivery filter");
      LoggerHandler.infoMessage("Screenshot taken for Same Day delivery filter");
      helper.clickOnElement(ResultsPage.firstCake);
      Hooks.test.log(Status.INFO, "click on the first product");
      LoggerHandler.infoMessage("click on the first cake");
      helper.switchToNewWindow();
      Hooks.test.log(Status.INFO, "Switched to new Window");

    } catch (Exception e) {
      LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
    }
  }

  /**
   * Description:buy the cake
   * 
   * @param test
   */
  public void buyTheCake() {
    try {
      helper.clickOnElement(ProductPage.addToCart);
      LoggerHandler.infoMessage("item added to cart");
      Screenshot.takeScreenShotWithHighlight(ProductPage.buyNow, "FNP");
      Reporter.attachToReport("FNP", Hooks.test, "Screenshot for Buy button");
      helper.clickOnElement(ProductPage.buyNow);

      Hooks.test.log(Status.PASS, "test case 04 passed");
      LoggerHandler.infoMessage("test case04 passed");

    } catch (Exception e) {
      LoggerHandler.infoMessage(e.getMessage());
      Hooks.test.log(Status.FAIL, "testCase 04 failed");
    }
  }

  /**
   * Description: method verifies the keyword
   * 
   * @param test
   */
  public void OffersVerification(String string) {
    try {
      String stringOffer = helper.getText(ResultsPage.offers);
      Assert.assertTrue(stringOffer.contains(string));

    } catch (AssertionError e) {
      LoggerHandler.errorMessage("Offers Keyword not verified");
    }

  }
}
