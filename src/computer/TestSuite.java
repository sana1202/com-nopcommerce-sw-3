package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBeticalOrder() {
        //1.1 click on Computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        //1.3 Select sort By position 'Name: Z TO A'
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z TO A");
        //1.4 verify the Product will arrange in Descending order
        String expectedText = "Name: Z to A";
        String actualText = getTextFromElement(By.xpath("//select[@id='products-orderby']"));
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        //2.3 Select Sort By position 'Name: A TO Z'
        selectByValueFromDropDown(By.xpath("//select[@id='products-orderby']"),"5");
        //2.4 click on 'Add to Cart'
        // clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        //2.5 Verify the Text "Build your own computer"
        //String expectedText = "Build your own computer";
        //String actualText = getTextFromElement(By.xpath("//div[@class='product-name']/h1"));
        //Assert.assertEquals(expectedText,actualText);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("label[for='product_attribute_3_7']"));
        //2.9  Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
//2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //2.11 Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[text()='$1,475.00']"));
        Thread.sleep(5000);
        Assert.assertEquals(expectedPrice,actualPrice);
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button.
        String expectedText1 = "The product has been added to your shopping cart";
        String actualText1 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedText1,actualText1);
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        //2.15 Verify the message "Shopping cart"
        String expectedText2 = "Shopping cart";
        String actualText2 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedText2,actualText2);
//2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@id='itemquantity11239']")).clear();
        sendTextToElement(By.xpath("//input[@id='itemquantity11239']"),"2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        Thread.sleep(5000);
        //2.17 Verify the Total"$2,950.00"
        String expectedText3 = "$2,950.00";
        String actualText3 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.19 Click on “CHECKOUT"
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedText4 = "Welcome, Please Sign In!";
        String actualText4 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedText4,actualText4);
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Abc");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"ch");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"abc@gmail.com");
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"Unites States");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"NewYork");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"20 Cooper Square");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"NY 10003");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"16467890");
//2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//label[normalize-space()='Next Day Air ($0.00)']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//label[normalize-space()='Credit Card']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"xyz");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5585478547852145");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"10");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "2026");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"456");
//2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedText5 = "Payment Method: Credit Card";
        String actualText5 = getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
        Assert.assertEquals(expectedText5,actualText5);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedText6 = "Shipping Method: Next Day Air";
        String actualText6 = getTextFromElement(By.xpath("//span[normalize-space()='Shipping Method:']"));
        Assert.assertEquals(expectedText6,actualText6);
        //2.33 Verify Total is “$2,950.00”
        String expectedText7 = "$2,950.00";
        String actualText7 = getTextFromElement(By.xpath("//tr[@class='order-total']//span[@class='value-summary']"));
        Assert.assertEquals(expectedText7,actualText7);
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //2.35 Verify the Text “Thank You”
        String expectedText8 = "Thank you";
        String actualText8 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedText8,actualText8);
        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedText9 = "Your order has been successfully processed!";
        String actualText9 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedText9,actualText9);
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        //2.37 Verify the text “Welcome to our store”
        String expectedText10 = "Welcome to our store";
        String actualText10 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expectedText10,actualText10);

    }
    public void tearDown(){
        closeBrowser();
    }

}
