package com.orangehrm.app;

import com.orangehrm.data.User;
import com.orangehrm.tools.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class LoginPage extends Page {

    public static String PAGEURL= "http://opensource.demo.orangehrmlive.com/index.php/auth/login";

    @FindBy(id = "txtUsername")
    private WebElement userNameInput;

    @FindBy(id = "txtPassword")
    private WebElement passwordInput;

    @FindBy(id = "btnLogin")
    private WebElement loginBtn;


    public LoginPage(WebDriver driver){
        super(driver);
    }
    @Step("Fill Username field with value <{0}>")
    public void fillUsernameField(String username) {
        fillInput(userNameInput, username);
    }
    @Step("Fill Password field with value <{0}>")
    public void fillPasswordField(String password){
        fillInput(passwordInput, password);
    }

    @Step("Click Login Button")
    public void clickLoginButton(){
        loginBtn.click();
    }

    @Step ("Login as <{0}>")
    public DashboardPage loginAS(User user){
        fillUsernameField(user.getUsername());
        fillPasswordField(user.getPassword());
        clickLoginButton();
        return new DashboardPage(driver);
    }
}