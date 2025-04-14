package uistore;

import org.openqa.selenium.By;

public class ProductPage {
        public static By addToCart=By.cssSelector("button[title='Add To Cart']");
    public static By buyNow = By.cssSelector("button[title='Buy Now']");


    public static By blr = By.xpath("//span[contains(text(),'Bangalore, Karnataka, India')]");

    public static By delhi = By.xpath("//span[contains(text(),'Delhi, India')]");
    public static By kolkata = By.xpath("//span[contains(text(),'Kolkata, West Bengal, India')]");

    public static By chn = By.xpath("//span[contains(text(),'Chennai, Tamil Nadu, India')]");
    public static By offer = By.xpath("//p[contains(text(),'Offer')]");
}
