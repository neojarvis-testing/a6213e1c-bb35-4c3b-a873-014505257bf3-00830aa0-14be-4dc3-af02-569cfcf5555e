package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.HomePage;
import uistore.HomePage;
import uistore.ProductPage;
import uistore.ResultsPage;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class HomePageAction extends Base {

  WebDriverHelper helper = new WebDriverHelper();
  /**
   *  Description:user specify the location and click on plants
   * @param bangalore
   * @param pincode
   */

  public void specifyLocation(String bangalore, String pincode) {
    try {
      helper.clickOnElement(HomePage.noThanks);
      helper.clickOnElement(HomePage.location);
      helper.clickOnElement(HomePage.pinCode);
      helper.sendKeys(HomePage.pinCode, bangalore);
      helper.waitForElementToBeVisible(ProductPage.blr,20);
      helper.clickOnElement(ProductPage.blr);
      helper.hoverOverElement(HomePage.shopping);
      helper.clickOnElement(HomePage.shopping);
      LoggerHandler.infoMessage("Location Entered Successfully");
      helper.assertPageText(ProductPage.blr, pincode);
      Screenshot.capScreenshot("pincode verification");
      helper.clickOnElement(HomePage.plants);
      LoggerHandler.infoMessage("Clicked on Plants");
    } catch (Exception e) {
      LoggerHandler.infoMessage(e.getMessage());
    }
  }
    /**
   * Description:user specify the location 
   * @param bangalore
   */
  public void enterlocation(String bangalore)
  {
   
    helper.clickOnElement(HomePage.location);
    helper.clickOnElement(HomePage.pinCode);
    helper.sendKeys(HomePage.pinCode, bangalore);
    helper.waitForElementToBeVisible(ProductPage.blr,20);
    helper.clickOnElement(ProductPage.blr);
    helper.javascriptClick(HomePage.continueShopppingBtn);
  }

   /**
     * Description:user iterate through plants
     * @param plant1
     * @param plant2
     * @param plant3
     */
  public void searchplant(String plant1,String plant2,String plant3) {
    try {
     
      helper.jsScrollByPixel(500);
      List<WebElement> plants = Base.driver.findElements(By.xpath("//div[@class='single-item plant_types']//h2"));
      List<String> values =new ArrayList<>();
      values.add(plant1);
      values.add(plant2);
      values.add(plant3);

      for (int i = 0; i < plants.size(); i++) {
        By verify = By.xpath("//div/h2[text()='" + values.get(i) + "']");
        helper.clickOnElement(verify);
        Hooks.driver.navigate().back();
      }
    }catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
     
      }


  

    /**
     * Description:user click on cart and verify continue gifting
     * @param verification
     */
      public void cartverification(String verification){
      try{
      helper.clickOnElement(ResultsPage.cart);
      LoggerHandler.infoMessage("Clikced On Cart");
      helper.assertPageText(ResultsPage.continueGifting, verification);
      Reporter.attachToReport("continueGifting verification", Hooks.test, "verified screenshot");
      Screenshot.capScreenshot("FnpPlants");

    } catch (Exception e) {
      LoggerHandler.errorMessage(e.getMessage());
      Hooks.test.log(Status.FAIL,e.getMessage());
    }

  }
}
