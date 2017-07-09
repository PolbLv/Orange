package com.orangehrm.tools;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;


public class Page {

    protected WebDriver driver;

    protected Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Read current URL")
    @Attachment("URL")
    public String getCurrentUrl() {
        return  driver.getCurrentUrl();
    }

    protected void fillInput(WebElement input, String text){
        input.sendKeys(text);
    }

    protected void selectOptionUsingHover(WebElement elementToHover, WebElement menuElement, WebElement elementToClick) {
        Actions builder = new Actions(driver);
        builder.moveToElement(elementToHover).perform();
        waitForElementToBeClickable(menuElement);
        builder.moveToElement(menuElement).click().perform();
        waitForElementToBeClickable(elementToClick);
        builder.moveToElement(elementToClick).click().perform();
    }

    protected void selectOptionByText(WebElement dropDown, String text){
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    protected void selectOptionByIndex(WebElement dropDown, int index){
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitForElementToBeVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void executeJS(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript("document.getElementById('attendance_date').click();");
        jse.executeScript(script);
    }
}

