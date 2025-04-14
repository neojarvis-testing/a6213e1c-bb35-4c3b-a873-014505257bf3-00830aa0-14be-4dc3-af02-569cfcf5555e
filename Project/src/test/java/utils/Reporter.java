package utils;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
 
 
 
public class Reporter {
 
    private static File file;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentReports reports;
 
 
    public static ExtentReports createReport(String reportName)
    {
        String dirpath = System.getProperty("user.dir") + "/reports";
        file = new File(dirpath);
 
        if(!file.exists())
        {
            file.mkdir();
        }
 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata"); // IST timezone
        dateFormat.setTimeZone(istTimeZone);
        String timestamp = dateFormat.format(new Date());
 
        String reportPath = System.getProperty("user.dir") + "/reports/" + reportName + "_" + timestamp + ".html";
        File reportfile = new File(reportPath);
 
        sparkReporter = new ExtentSparkReporter(reportfile);
 
        reports = new ExtentReports();
 
        reports.attachReporter(sparkReporter);
 
        return reports;
    }
 
    public static String captureScreenShot(String filename) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String name = filename + timestamp + ".png";
 
        String destPath =  "./"+name;
 
        if(Base.driver == null)
            System.out.println("driver is null");
 
        TakesScreenshot ts = (TakesScreenshot) Base.driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
 
        File screenshotsDir = new File(System.getProperty("user.dir") + "/reports");
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }
 
        File target = new File(screenshotsDir, name);
        try {
            Files.copy(file, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destPath;
    }
 
    public static void attachToReport(String filename, ExtentTest test, String description) {
        try {
            test.log(Status.INFO, description, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(filename)).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
}