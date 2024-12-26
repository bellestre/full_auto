package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class PimPage {
    private Page page;

    private Locator pimMenu;
    private Locator employeeSearchInput;
    private Locator employeeSearchButton;

    private Locator employeeAddButton;
    private Locator loginDetailsToggleButton;
    private Locator firstNameInputField;
    private Locator lastNameInputField;
    private Locator userNameInputField;
    private Locator passwordInputField;
    private Locator confirmPasswordInputField;
    private Locator saveButton;

    public PimPage(Page page) {
        this.page = page;

        this.pimMenu = page.locator(".oxd-main-menu-item");
        this.employeeSearchInput = page.getByPlaceholder("Type for hints...");
        this.employeeSearchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search "));

        this.employeeAddButton = page.locator(".oxd-button");
        this.loginDetailsToggleButton = page.locator(".oxd-switch-input");
        this.firstNameInputField = page.locator("[name='firstName']");
        this.lastNameInputField = page.locator("[name='lastName']");
        this.userNameInputField = page.locator(".oxd-input");
        this.passwordInputField = page.locator("[type='password']");
        this.confirmPasswordInputField = page.locator("[type='password']");
        this.saveButton = page.locator("[type='submit']");
    }

    public void createNewEmployee(String firstName, String lastName, String userName) {
        pimMenu.nth(1).click();
        employeeAddButton.nth(2).click();
        loginDetailsToggleButton.click();
        firstNameInputField.fill(firstName);
        lastNameInputField.fill(lastName);
        userNameInputField.nth(5).fill(userName);

        passwordInputField.first().fill("estrella123");
        confirmPasswordInputField.last().fill("estrella123");
        saveButton.first().click();
        page.waitForTimeout(8000);
    }

    public void verifyNewEmployee(String firstName, String lastName) {
        pimMenu.nth(1).click();
        employeeSearchInput.first().fill(firstName+" "+lastName);
        employeeSearchButton.click();
        page.mouse().wheel(0,500);
        page.waitForTimeout(4000);


    }
}