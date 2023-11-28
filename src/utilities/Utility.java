package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void getTextFromAlert() {
        driver.switchTo().alert().getText();
    }

    public void sendTextFromAlert() {
        driver.switchTo().alert().sendKeys("Text");
    }

    //*****************************Select Class Methods*****************************************************
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //Create the object of select class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }
    public void selectByVisibleTextFromDropDown(By by, String name){
        WebElement dropDown = driver.findElement(By.xpath("//option[@value='0']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Z TO A");

    }


    //****************************Action method*****************************************************
    public void mouseHoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    //****************************
    public void sortByPositionName(){
        List<WebElement> originalList = driver.findElements(By.xpath("//select[@id='products-orderby']"));
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList){
            originalProductNameList.add(product.getText());
        }

        Collections.sort(originalProductNameList, Collections.reverseOrder());
        System.out.println(originalProductNameList);
        //Sort by position Name:  "Z TO A"
        selectByVisibleTextFromDropDown(By.xpath("//option[normalize-space()='Name: Z to A']"),"Name: Z to A");


    }
}
