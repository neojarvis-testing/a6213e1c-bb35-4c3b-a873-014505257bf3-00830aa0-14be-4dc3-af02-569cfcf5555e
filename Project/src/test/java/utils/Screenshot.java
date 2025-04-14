package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


	
public class Screenshot extends Base{
	

	public static TakesScreenshot ts;
    public static void capScreenshot(String filename)
    {	
 ts=(TakesScreenshot) driver;;
 String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 String name = filename + timestamp + ".png";
        
       File file = ts.getScreenshotAs(OutputType.FILE);
       File target=new File(System.getProperty("user.dir")+"/screenshots/");

       if(!target.exists())
       {
        target.mkdirs();
       }
       try {
        FileHandler.copy(file,new File(target.toString()+"/"+name));
    } catch (IOException e) {
        LoggerHandler.errorMessage(e.getMessage());
    }
	}

	public static void takeScreenShotWithHighlight(By locator,String name ){
        try {
        WebElement Element=driver.findElement(locator);
        JavascriptExecutor js=(JavascriptExecutor) driver;
	   js.executeScript("arguments[0].style.border='3px solid red'", Element);

        Thread.sleep(2000);
        TakesScreenshot ts=(TakesScreenshot) driver;
        File fs=ts.getScreenshotAs(OutputType.FILE);
        File target=new File(System.getProperty("user.dir")+"/screenshots/");
        if(!target.exists()){
            target.mkdirs();
        }
        FileHandler.copy(fs, new File(target.toString()+"/"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }catch(InterruptedException e){
          e.printStackTrace();
        }
    }

}