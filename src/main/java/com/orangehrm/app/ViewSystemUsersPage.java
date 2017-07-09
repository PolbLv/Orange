package com.orangehrm.app;


import com.orangehrm.data.User;
import com.orangehrm.tools.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class ViewSystemUsersPage extends Page {
    public static String PAGEURL = "http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers";

    @FindBy(id = "btnAdd")
    private WebElement addBtn;

    @FindBy(id = "systemUser_userType")
    private WebElement chooseOption;

    @FindBy(id = "systemUser_employeeName_empName")
    private WebElement employeeNameInput;

    @FindBy(id = "systemUser_userName")
    private WebElement userNameInput;

    @FindBy(id = "systemUser_status")
    private WebElement chooseStatus;

    @FindBy(id = "systemUser_password")
    private WebElement passwordInput;

    @FindBy(id = "systemUser_confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "btnSave")
    private WebElement SaveBtn;

    @FindBy(css = "tbody a")
    private List<WebElement> usersList;

    @FindBy(css = ".message.success.fadable")
    private WebElement statusMessage;

    @FindBy(id="welcome")
    private WebElement userWelcomeMenu;

    public ViewSystemUsersPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("viewSystemUsers"));
    }

    private String getEmployeeName(){
        return employeeNameInput.getAttribute("value");
    }


    @Step("Click Add User Button")
    public void clickAddButton() {
        addBtn.click();
    }

    @Step("Choose User Role option Admin")
    public void chooseUserRole(String role) {
       selectOptionByText(chooseOption, role);
    }

    @Step("Fill Employee Name with value <{0}>")
    public void fillEmployeeNameFieldRandom() {
        employeeNameInput.sendKeys(" ");
        List<WebElement> employees = driver.findElements(By.cssSelector(".ac_results li"));
        int randomIndex = new Random().nextInt(employees.size()-1);
        employees.get(randomIndex).click();
    }

    @Step("Fill New User Name with value <{0}>")
    public void fillUserNameField(String userName) {
        fillInput(userNameInput, userName);
    }

    @Step("Choose Status")
    public void chooseNewUserStatus(String status) {
        Select select = new Select(chooseStatus);
        select.selectByVisibleText(status);
    }


    @Step("Fill New User Password with value <{0}>")
    public void fillPasswordFileld(String password) {
        fillInput(passwordInput, password);
    }

    @Step("Fill Confirm New User Password Field with value <{0}>")
    public void fillConfirmPasswordField(String password) {
        fillInput(confirmPasswordInput, password);
    }

    @Step("Click Save Button")
    public void clickSaveButton() {
        SaveBtn.click();
        waitForElementToBeVisible(statusMessage);
    }

    @Step("Check if New User Created")
    public boolean checkNewUser(String username) {
        boolean isUserInList = false;
        for (WebElement item : usersList) {
            if (item.getText().equals(username)) {
                isUserInList = true;
                break;
            }
        }
        return isUserInList;
    }

    @Step("Create New User as <{0}>")
    public void createNewUser(User user) {
        chooseUserRole(user.getUserRole());
        fillEmployeeNameFieldRandom();
        user.setEmployeeName(getEmployeeName());
        fillUserNameField(user.getUsername());
        chooseNewUserStatus(user.getStatus());
        fillPasswordFileld(user.getPassword());
        fillConfirmPasswordField(user.getPassword());
        clickSaveButton();
    }
    @Step("User LogOut")
    public LoginPage logOut(){
        userWelcomeMenu.click();
        WebElement logoutLink = userWelcomeMenu.findElement(By.xpath("./following-sibling::*//*[contains(@href, 'logout')]"));
        waitForElementToBeClickable(logoutLink);
        logoutLink.click();
        return new LoginPage(driver);
    }
}
