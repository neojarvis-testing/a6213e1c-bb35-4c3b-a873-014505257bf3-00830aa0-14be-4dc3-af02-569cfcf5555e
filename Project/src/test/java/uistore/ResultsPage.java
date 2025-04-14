package uistore;

import org.openqa.selenium.By;

public class ResultsPage {
    public static By magicMugs= By.linkText("Magic Mugs");
    public static By roses = By.cssSelector("a[href='/roses/anniversary-lp?promo=plplink_flws_anni_desk']");
    public static By rings = By.cssSelector("a[href='/rings-lp?promo=plplink_jewellery_desk']");
    public static By sameDayDelivery = By.linkText("Same Day Delivery");

    public static By luckybamboo=By.xpath("//h2[contains(text(),'Lucky Bamboo')]"); 
    public static By jadeplant=By.xpath("//h2[contains(text(),'Jade Plants')]"); 
    public static By moneyplant=By.xpath("//h2[contains(text(),'Money Plants')]"); 
    public static By  cart = By.cssSelector("button[aria-label='Cart']"); 
   
   public static By availability = By.xpath("//span[contains(text(),'Availability')]");
   public static By filterTrue = By.xpath("//span[contains(text(),'true')]");


   public static By firstCake = By.xpath("//div[@class='w-[calc(32.8%-8px)]']");
   public static By firstResult=By.xpath("//div[@class='mb-10 truncate text-12 font-500 leading-0 text-fnp-500 md:text-14']");
   public static By firstPen=By.cssSelector("div[class='w-[calc(24.5%-8px)]']"); 

   public static By clickonflavour = By.xpath("(//span[@class='text-14 font-500 font-500'])[2]");
   
   public static By clickonchocolate = By.id("checkbox-Flavour_0");
   public static By  continueGifting = By.cssSelector("//div[contains(text(),'Continue Gifting')]");

   public static By offers=By.xpath("//p[text()='Offers Available']");
    public static By homePageLogo=By.cssSelector("img[src='/icons/fnp-gift.svg']");
    public static By policyVerify=By.xpath("//h6[text()='Policy Info']");
}
