package stepdefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.Base;
import utils.Reporter;

public class Hooks extends Base {
    public static ExtentReports reports;
    public static ExtentTest test;


    
    @BeforeAll
    public static void makeReport(){
    reports=Reporter.createReport("FNP_Report");
    }
    @Before
    public void getBrowser(Scenario sc){
      browserSetup();
        test=reports.createTest(sc.getName());
    }
    @After
    public void quitDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
    @AfterAll
    public static void flushingReport(){
        reports.flush();
    } 

}
