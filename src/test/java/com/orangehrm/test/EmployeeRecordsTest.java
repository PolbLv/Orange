package com.orangehrm.test;

import com.orangehrm.app.DashboardPage;
import com.orangehrm.app.ViewAttendanceRecordPage;
import com.orangehrm.data.User;
import com.orangehrm.data.UserRole;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

/**
 * Created by Serhiy on 7/9/17.
 */
public class EmployeeRecordsTest extends AbstractTest {


    private DashboardPage onDashboardPage;
    private ViewAttendanceRecordPage onViewAttendanceRecordPage;


    @Test
    public void testEmployeeRecords() {
        User admin = new User(UserRole.ADMIN);
        User employee = new User(UserRole.ESS);
        onDashboardPage = orangeHRMPage.openLoginPage().loginAS(admin);
        String actualURL = onDashboardPage.getCurrentUrl();

        Assert.assertEquals(actualURL, onDashboardPage.PAGEURL, "Incorrect URL \n expected: " + onDashboardPage.PAGEURL
                + "\n actual: " + actualURL);

        onViewAttendanceRecordPage = onDashboardPage.goToEmployeesRecords();
        actualURL = onViewAttendanceRecordPage.getCurrentUrl();
        Assert.assertEquals(actualURL, onViewAttendanceRecordPage.PAGEURL, "Incorrect URL \n expected: " + onViewAttendanceRecordPage.PAGEURL
                + "\n actual: " + actualURL);
        onViewAttendanceRecordPage.selectName(employee.getEmployeeName());
        onViewAttendanceRecordPage.selectDate(LocalDate.now().minusYears(1).toString());
        onViewAttendanceRecordPage.clickViewBtn();
        /*
        Also requires using javascript. I continue improving my js experience :)
        5. Verify that there are no attendance records in the table.
        6. Add a new attendance record (provide all the information: date, time, timezone, and note)
        7. Verify that the just created attendance record is present in the table*/
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        orangeHRMPage.close();
    }
}
