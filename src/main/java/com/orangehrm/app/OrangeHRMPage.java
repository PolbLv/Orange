package com.orangehrm.app;

import com.orangehrm.tools.App;
import com.orangehrm.tools.Browser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;


public class OrangeHRMPage implements App{

    private static final String BASE_URL = "http://opensource.demo.orangehrmlive.com/";
    private WebDriver driver;

    @Step("Open Home Page by URL: " + BASE_URL)
    public LoginPage openLoginPage(){
        driver = Browser.open();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        return new LoginPage(driver);
    }

    @Step("Close Browser")
    public void close(){
        if(driver !=null)
            driver.quit();
        driver = null;
    }

    @Override
    public byte[] takeScreenshot() {
        TakesScreenshot takesScreenshot = TakesScreenshot.class.cast(driver);
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }
}
