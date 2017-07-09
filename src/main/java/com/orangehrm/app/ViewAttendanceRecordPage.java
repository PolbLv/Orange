package com.orangehrm.app;


import com.orangehrm.tools.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;



public class ViewAttendanceRecordPage extends Page {

    public static String PAGEURL= "http://opensource.demo.orangehrmlive.com/index.php/attendance/viewAttendanceRecord";


    //@FindBy(css = "#ui-datepicker-div>table a")
    //private List<WebElement> daysOfMonthList;
    private By daysOfMonthList = By.cssSelector("#ui-datepicker-div>table a");

    //@FindBy(className = "ui-datepicker-month")
    //private WebElement monthDd;  
    private By monthDd = By.className("ui-datepicker-month");

    //@FindBy(className = "ui-datepicker-year")
    //private WebElement yearDd;
    private By yearDd = By.className("ui-datepicker-year");


    public ViewAttendanceRecordPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("viewAttendanceRecord"));
    }
    @Step("Select user name")
    public void selectName(String name){
        executeJS("document.getElementById('attendance_employeeName_empName').value = '" + name + "';");
    }
    @Step("Type Date" )
    public void selectDate(String date){
        executeJS("document.getElementById('attendance_date').value = '" + date + "';");
   }
    @Step("Click button view")
   public void clickViewBtn(){
       executeJS("document.getElementById('btView').click();");
   }

}

