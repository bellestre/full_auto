package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import pages.LoginPage;

import static org.testng.Assert.*;

public class LoginPageTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        loginPage = new LoginPage(page);
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    public void LoginSuccessful() {
        loginPage.showLoginPage();

        assertTrue(page.title().matches(".*OrangeHRM.*"));
        loginPage.doLogin("Admin", "admin123");
        assertEquals(page.url(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(page.locator(".oxd-topbar-header-breadcrumb-module").textContent().contains("Dashboard"));
    }

    @Test
    public void LoginFailed() {
        loginPage.showLoginPage();

        assertTrue(page.title().matches(".*OrangeHRM.*"));
        loginPage.doLogin("miUsuario", "usuario123");
        assertTrue(page.locator(".oxd-alert-content-text").textContent().contains("Invalid credentials"));
    }
}