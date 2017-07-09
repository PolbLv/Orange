package com.orangehrm.app;

import com.orangehrm.tools.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;


public class DashboardPage extends Page {

    public static String PAGEURL= "http://opensource.demo.orangehrmlive.com/index.php/dashboard";

   @FindBy(id = "welcome")
   private WebElement welcome;

   @FindBy(id = "menu_admin_viewAdminModule")
   private WebElement adminLnk;

   @FindBy(id = "menu_admin_UserManagement")
   private WebElement userManagementLnk;

   @FindBy(id = "menu_admin_viewSystemUsers")
   private WebElement usersLnk;


    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement timeLnk;

    @FindBy(id = "menu_attendance_Attendance")
    private WebElement attendanceLnk;

    @FindBy(id = "menu_attendance_viewAttendanceRecord")
    private WebElement employeeRecordsLnk;

    public DashboardPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("dashboard"));
    }
    @Step("Read Greetings message")
    @Attachment("Message")
    public String getGreetingsMessage(){
        return welcome.getText();
    }

    @Step("Click Users in Admin Module")
    public ViewSystemUsersPage goToUsersManagement(){
        selectOptionUsingHover(adminLnk, userManagementLnk, usersLnk);
        return new ViewSystemUsersPage(driver);
    }

    @Step("Click Users in Time Module")
    public ViewAttendanceRecordPage goToEmployeesRecords(){
        selectOptionUsingHover(timeLnk, attendanceLnk, employeeRecordsLnk);
        return new ViewAttendanceRecordPage(driver);
    }
}

