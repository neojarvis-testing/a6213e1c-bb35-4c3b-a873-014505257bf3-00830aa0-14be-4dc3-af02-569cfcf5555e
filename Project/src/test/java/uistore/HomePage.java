package uistore;

import org.openqa.selenium.By;

public class HomePage {

        public static By noThanks = By.cssSelector("button[id='wzrk-cancel']");

    public static By whereToDeliver = By.xpath("//span[contains(text(),'Where to deliver?')]");
    public static By location = By.cssSelector(
            "span[class='block max-w-[153px] overflow-hidden text-ellipsis whitespace-nowrap text-16 font-600 text-fnp-500 md:text-16 xxl:text-18']");

    public static By pinCode = By.cssSelector("input[id='pincode-location-input']");

    public static By shopping = By.xpath("//div[contains(text(),'Continue Shopping')]");
    public static By continueShoppping = By
            .xpath("(//div[@class='text-center not-italic leading-6 text-14 font-600'])[3]");
    public static By continueShopppingBtn = By.cssSelector(
            "button[class=' flex w-full h-auto px-10 py-12 items-center gap-2.5 bg-fnp-300 text-white-900 justify-center  rounded-lg  ']");

    public static By searchbar = By.cssSelector("input[id='search_bar']");

    public static By hoverlifestyle = By.xpath("//span[contains(text(),'Lifestyle')]");
    public static By jewellery = By.cssSelector("a[href='/jewellery-lp?promo=othergiftsmenu_dt_hm']");

    public static By personalized = By.xpath("//span[contains(text(),'Personalised')]");
    public static By Mugs = By.cssSelector("a[href='/personalised-mugs-lp?promo=personalizedmenu_dt_hm']");

    public static By anniversary = By.xpath("//span[contains(text(),'Anniversary')]");
    public static By flowers = By.cssSelector("a[href='/flowers/anniversary-lp?promo=anniversarymenu_dt_hm']");

    public static By combos = By.cssSelector("a[aria-label='Combos']");
    public static By hamper = By.cssSelector("a[href='/healthy-gift-hampers-lp?promo=combosmenu_dt_hm']");

    public static By plants = By.xpath("//span[contains(text(),'Plants')]");

    public static By cakes = By.xpath("//span[contains(text(),'Cakes')]");
    public static By birthdayCake = By.id("Birthday Cakes");

    public static By cart = By.cssSelector("button[aria-label='Cart']");
    public static By dec = By.xpath("//a[@href='/decoration-services']");

    public static By add=By.xpath("//button[@title='Add To Cart']/div[contains(text(),'Add To Cart')]");

    public static By locationnew = By.xpath("//span[contains(text(),'Bangalore, Karnataka, India, 560001')]");
    
    
}
