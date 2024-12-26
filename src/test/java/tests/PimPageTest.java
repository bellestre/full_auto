package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.PimPage;
import utils.Utils;

import java.nio.file.Paths;

import static org.testng.Assert.*;

public class PimPageTest{

    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private PimPage pimPage;
    private Utils utils;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        loginPage = new LoginPage(page);
        pimPage = new PimPage(page);
        utils = new Utils();
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    public void createNewEmployee() {
        loginPage.showLoginPage();
        assertTrue(page.title().matches(".*OrangeHRM.*"));
        loginPage.doLogin("Admin", "admin123");
        assertEquals(page.url(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(page.locator(".oxd-topbar-header-breadcrumb-module").textContent().contains("Dashboard"));

        Utils.User myUser = utils.generateUser();
        System.out.println(myUser);

        pimPage.createNewEmployee(myUser.firstName, myUser.lastName, myUser.userName);
        assertTrue(page.locator(".orangehrm-main-title").nth(0).textContent().contains("Personal Details"));
        page.waitForLoadState(LoadState.LOAD);

        pimPage.verifyNewEmployee(myUser.firstName, myUser.lastName);
        page.waitForLoadState(LoadState.LOAD);
        assertTrue(true);

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencia.png")));
    }
}
