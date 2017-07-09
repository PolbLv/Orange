package com.orangehrm.test;


import com.orangehrm.app.DashboardPage;
import com.orangehrm.app.LoginPage;
import com.orangehrm.app.ViewSystemUsersPage;
import com.orangehrm.data.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginWithAdminAndCreateNewUserTest extends  AbstractTest{

    private LoginPage onLoginPage;
    private DashboardPage onDashboardPage;
    private ViewSystemUsersPage onViewSystemUserPage;


    @Test
    public void testAdminIsAbleToLoginAndCreateNewUser() {
        User admin = new User(UserRole.ADMIN);
        onDashboardPage = orangeHRMPage.openLoginPage().loginAS(admin);
        String actualURL = onDashboardPage.getCurrentUrl();

        Assert.assertEquals(actualURL, onDashboardPage.PAGEURL,"Incorrect URL \n expected: " + onDashboardPage.PAGEURL
        + "\n actual: " + actualURL);

        onViewSystemUserPage = onDashboardPage.goToUsersManagement();

        actualURL = onViewSystemUserPage.getCurrentUrl();

        Assert.assertEquals(actualURL, onViewSystemUserPage.PAGEURL,"Incorrect URL \n expected: " + onViewSystemUserPage.PAGEURL
                + "\n actual: " + actualURL);

        onViewSystemUserPage.clickAddButton();

        User newUser = new User(UserRole.ESS);

        onViewSystemUserPage.createNewUser(newUser);

        Assert.assertTrue(onViewSystemUserPage.checkNewUser(newUser.getUsername()), "User was not found in the list" );

        onLoginPage = onViewSystemUserPage.logOut();

        actualURL = onLoginPage.getCurrentUrl();

        Assert.assertEquals(actualURL, onLoginPage.PAGEURL,"Incorrect URL \n expected: " + onLoginPage.PAGEURL
                + "\n actual: " + actualURL);

        onDashboardPage = onLoginPage.loginAS(newUser);

        actualURL = onDashboardPage.getCurrentUrl();

        Assert.assertEquals(actualURL, onDashboardPage.PAGEURL,"Incorrect URL \n expected: " + onDashboardPage.PAGEURL
                + "\n actual: " + actualURL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        orangeHRMPage.close();
    }


}
