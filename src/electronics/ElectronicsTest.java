package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
//1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
//2.3 Verify the text “Cell phones”
        String expectedText1 = "Cell phones";
        String actualText1 = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText1, actualText1);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(4000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));
        //2.6 Verify the text “Nokia Lumia 1020
        String expectedText2 = "Nokia Lumia 1020";
        String actualText2 = getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));
        Assert.assertEquals(expectedText2, actualText2);
        //2.7 Verify the price “$349.00”
        String expectedText3 = "$349.00";
        String actualText3 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expectedText3, actualText3);
        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button.
        String expectedText4 = "The product has been added to your shopping cart";
        String actualText4 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedText4, actualText4);
        Thread.sleep(3000);
        clickOnElement(By.xpath("//span[@title='Close']"));
//2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Thread.sleep(5000);
        //2.12 Verify the message "Shopping cart"
        String expectedText5 = "Shopping cart";
        String actualText5 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedText5, actualText5);
        //2.13 Verify the quantity is 2
        WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String expectedText6 = "2";
        String actualText6 = text.getAttribute("value");
        Assert.assertEquals(expectedText6,actualText6);
        //2.14 Verify the Total $698.00
        String expectedText7 = "$698.00";
        String actualText7 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        Assert.assertEquals(expectedText7, actualText7);
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
//2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedText8 = "Welcome, Please Sign In!";
        String actualText8 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedText8, actualText8);
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        //2.19 Verify the text “Register”
        String expectedText9 = "Register";
        String actualText9 = getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        Assert.assertEquals(expectedText9, actualText9);
//2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "abc");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "ch");
        sendTextToElement(By.xpath("//input[@id='Email']"), "a2bc@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "abc123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "abc123");
        Thread.sleep(3000);
        //2.21 Click on “REGISTER”Button
        clickOnElement(By.id("register-button"));
        //2.22 Verify the message “Your registration completed”
        String expectedText10 = "Your registration completed";
        String actualText10 = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expectedText10, actualText10);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        //2.24 Verify the text “Shopping card”
        String expectedText11 = "Shopping cart";
        String actualText11 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedText11, actualText11);
        ////2.25 click on checkbox “I agree with the terms of service”
        // clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.26 Click on “CHECKOUT”
        //clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields

    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}
