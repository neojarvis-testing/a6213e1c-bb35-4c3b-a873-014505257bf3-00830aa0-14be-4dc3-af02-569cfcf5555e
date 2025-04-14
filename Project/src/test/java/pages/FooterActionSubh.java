package pages;
 
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.HomePage;
import uistore.ResultsPage;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.WebDriverHelper;
 
public class FooterActionSubh {
  WebDriverHelper helper = new WebDriverHelper();
 
  /**
   * Description:click on the link under PolicyInfo and navigate back
   *
   * @param test
   */
  public void linkVerificationPolicyInfo() {
    try {
      helper.javascriptScroll(ResultsPage.policyVerify);
 
      List<String> linkLists = ExcelReader.readExcelData("Sheet1", "linkTextPolicy");
 
      for (int i = 0; i < linkLists.size(); i++) {
        String linkText = linkLists.get(i);
        By footerLink = By.xpath("//a[text()='" + linkText + "']");
 
        helper.clickOnElement(footerLink);
        helper.waitForElementToBeVisible(ResultsPage.homePageLogo, 10);
        LoggerHandler.infoMessage("Redirected page Open " + linkText);
 
        Base.driver.navigate().back();
      }
      Hooks.test.log(Status.PASS, "Policy info verification");
    } catch (Exception e) {
      LoggerHandler.infoMessage(e.getMessage());
      Reporter.attachToReport("Polivy info", Hooks.test, "testcase failed");
    }
  }
 
  /**
   * Description:click on the link under PolicyInfo and navigate back
   *
   * @param test
   */
  public void linkVerificationAboutCompany() {
    try {
      List<String> linkLists = ExcelReader.readExcelData("Sheet1", "linkAboutCompany");
      for (int i = 0; i < linkLists.size(); i++) {
 
        String linkText = linkLists.get(i);
        By footerLink = By.xpath("//a[text()='" + linkText + "']");
 
        helper.clickOnElement(footerLink);
        List<String> titleList = ExcelReader.readExcelData("Sheet1", "title");
        helper.assertPageTitle(Base.driver, titleList.get(i));
        LoggerHandler.infoMessage("Redirected page title verified " + linkText);
        Base.driver.navigate().back();
      }
 
    } catch (Exception e) {
      LoggerHandler.infoMessage(e.getMessage());
      
    }
  }
    /**
   * Description: Policy Info Keyword verifies
   *
   * @param test
   */
  public void PolicyVerification(String string){
    try {
      
      String policy = helper.getText(ResultsPage.policyVerify);
      Reporter.attachToReport("policy info", Hooks.test, "Policy Info keyword Verification");
      Assert.assertEquals(policy, string);
  
      LoggerHandler.infoMessage("test case 08 passed");
    } catch (Exception e) {
      Reporter.attachToReport("About company", Hooks.test, "testcase failed");
    }
  }
    /**
   * Description: Scroll to the keyword PolicyInfo
   *
   * @param test
   */
    public void scrollToFooter() {
      helper.clickOnElement(HomePage.noThanks);
      helper.javascriptScroll(ResultsPage.policyVerify);
    }
}
