package pages;

import java.util.List;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.HomePage;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.WebDriverHelper;

public class FnpBusinessAction {
     WebDriverHelper helper = new WebDriverHelper();
    /**
     * Description:scroll down to footer
     * @return void
     */
    public void scrollToFooter()
    {   try
        {
            helper.clickOnElement(HomePage.noThanks);
            helper.javascriptScroll(HomePage.dec);
            helper.jsScrollByPixel(100);
        }
        catch(Exception e)
        {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
        }
       
    }
    /**
     * Description: iterates over FNP Business in the footer
     * @return void
     */
    public void iterateFnpBusiness() {
        try {

             List<String> values  = ExcelReader.readExcelData("Sheet1", "linktext");
                  
           
            for (int i = 0; i < values.size(); i++) {
                
                By footerLink = By.xpath("//a[text()='" + values.get(i) + "']");

                helper.clickOnElement(footerLink);
                String pageTitle = Hooks.driver.getTitle();
                // List<String> titleList = ExcelReader.readExcelData("Sheet1", "titleAv");
                // helper.assertPageTitle(Hooks.driver,titleList.get(i));
   
                //test.log(Status.INFO,pageTitle+"has been verified");
                LoggerHandler.infoMessage(pageTitle+"has been verified");
                
                System.out.println(pageTitle);

                Hooks.driver.navigate().back();
            }
            

        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
            Reporter.attachToReport("error_on_footer_business_method",Hooks.test,"exception");
        } catch(AssertionError e)
        {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
            Reporter.attachToReport("Assertion_error",Hooks.test,"");
        }

    }

    /**
     * Description: Iterate over FNP UsefulLinks
     * @return void
     */
    public void iterateUsefulLinks()
    {

        try {
            List<String> links  = ExcelReader.readExcelData("Sheet1", "business");

            for (int i = 0; i < links.size(); i++)
            {
                By footerLink = By.xpath("//a[text()='" + links.get(i) + "']");
                helper.clickOnElement(footerLink);
                String pageTitle = Hooks.driver.getTitle();
                System.out.println(pageTitle);
                Hooks.driver.navigate().back();
            }
        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());
            Hooks.test.log(Status.FAIL,e.getMessage());
            Reporter.attachToReport("error_on_footer_usrfuLinks_method",Hooks.test,"exception");
        }
    }



}
