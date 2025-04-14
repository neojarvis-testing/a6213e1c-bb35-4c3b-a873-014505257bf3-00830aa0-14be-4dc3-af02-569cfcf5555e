package utils;
 
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 
import java.time.Duration;
import java.util.List;
import java.util.Set;
 
public class WebDriverHelper extends Base {
 
    public void hoverAndClick(By locator) {
        try {
            WebElement Element = Base.driver.findElement(locator);
            Actions actions = new Actions(Base.driver);
            actions.moveToElement(Element).build().perform();
            if(Element.isDisplayed()){
                Element.click();
            }  
        } catch (Exception e) {
            LoggerHandler.errorMessage("hoverAndClick"+e.getMessage());
        }
 
    }
 
    public void waitForElementToBeVisible(By locator,int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            LoggerHandler.errorMessage("Explicitwait "+e.getMessage());
        }
 
    }
    public void assertPageTitle(WebDriver driver, String expectedTitle) {
        try {
 
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);
        } catch (AssertionError e) {
            LoggerHandler.errorMessage("Assert page Title"+e.getMessage());
        }
    }
 
    public static void assertPageText(WebDriver driver, By locator, String expectedText) {
        try {
            String actualText = driver.findElement(locator).getText();
            Assert.assertEquals(expectedText, actualText);
        } catch (AssertionError e) {
            LoggerHandler.errorMessage("Assert Page Text"+e.getMessage());
        }
    }

    public void switchToNewWindow() {
        try {
            String parentWindow = driver.getWindowHandle();
            Set<String> child = driver.getWindowHandles();
            for (String window : child) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                }
            }
        } catch (Exception e) {
            LoggerHandler.errorMessage("Window Not Switched"+e.getMessage());
        }
    }
 
    public void javascriptScroll(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            LoggerHandler.errorMessage("JavaScript scroll"+e.getMessage());
        }
    }
 
    public void javascriptClick(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            LoggerHandler.errorMessage("JavaScript click"+e.getMessage());
        }
    }
 
    public void clickOnElement(By locator) {
        try {
            WebElement webElement = Base.driver.findElement(locator);
            webElement.click();
        } catch (Exception e) {
            LoggerHandler.errorMessage("Element Not Clicked"+e.getMessage());
 
        }
 
    }
 
    public void sendKeys(By locator, String data) {
        try {
            WebElement webElement = Base.driver.findElement(locator);
            webElement.sendKeys(data);
        } catch (Exception e) {
            LoggerHandler.errorMessage("sendKeys"+e.getMessage());
 
        }
 
    }
 
    public String getText(By locator) {
        try {
            WebElement webElement = Base.driver.findElement(locator);
            return webElement.getText();
        } catch (Exception e) {
            LoggerHandler.errorMessage("GetText"+e.getMessage());
            return null;
        }
    }
 
    public void enterAction(By locator) {
        try {
            WebElement webElement = Base.driver.findElement(locator);
            webElement.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            LoggerHandler.errorMessage("enterAction"+e.getMessage());
 
        }
 
    }
 
    public List<WebElement> getElementsByXPath(String XPath) {
        List<WebElement> list1 = Base.driver.findElements(By.xpath(XPath));
        return list1;
    }
 
    public void hoverOverElement(By locator) {
        try {
            WebElement webElement = Base.driver.findElement(locator);
            Actions actions = new Actions(Base.driver);
            actions.moveToElement(webElement).pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            LoggerHandler.errorMessage("hoverOverElement"+e.getMessage());
        }
 
    }
 
 
 
    public void jsScrollByPixel(int pixel) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,"+pixel+")", "");
        } catch (Exception e) {
            LoggerHandler.infoMessage(e.getMessage());
        }
    }

    public static void assertPageText( By locator, String expectedText) {
        try {
            String actualText = driver.findElement(locator).getText();
            if(actualText.contains(expectedText)){
                Assert.assertTrue(true);
            }
            else{
                Assert.assertTrue(false);
            }
        } catch (AssertionError e) {
            LoggerHandler.infoMessage(e.getMessage());
        }
    }
 
 
}