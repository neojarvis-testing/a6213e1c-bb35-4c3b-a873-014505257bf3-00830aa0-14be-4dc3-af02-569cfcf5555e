package utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class Base {

    public static WebDriver driver;
    public static FileInputStream file;
    public static Properties prop;

    public void loadProp() {
        String propertiesPath = System.getProperty("user.dir") + "/config/config.properties";
        try {
            file = new FileInputStream(propertiesPath);
            prop = new Properties();
            prop.load(file);

        } catch (Exception e) {
            LoggerHandler.errorMessage(e.getMessage());

        }
    }
    public void browserSetup() {

        loadProp();
        try {
            driver = new RemoteWebDriver( new URL(prop.getProperty("local")), new ChromeOptions());
        } catch (MalformedURLException e) {
            
            LoggerHandler.errorMessage(e.getMessage());
        }

        if (driver != null)

        {   
            driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("iwait"))));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pwait"))));


        }


        WebDriverListener listener = new EventHandler();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

    }

}
