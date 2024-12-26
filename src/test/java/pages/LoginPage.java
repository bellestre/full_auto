package pages;

import com.microsoft.playwright.*;

public class LoginPage {
    private Page page;

    private Locator userNameInputField;
    private Locator passwordInputField;
    private Locator loginSubmitButton;

    public LoginPage(Page page) {
        this.page = page;

        this.userNameInputField = page.locator("[name='username']");
        this.passwordInputField = page.locator("[name='password']");
        this.loginSubmitButton = page.locator("[type='submit']");
    }

    public void showLoginPage() {
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void doLogin(String username, String password) {
        userNameInputField.fill(username);
        passwordInputField.fill(password);
        loginSubmitButton.click();
    }
}