import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            // Browser browser = playwright.chromium().launch();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            System.out.println(page.title());

            Locator textUsername = page.getByPlaceholder("Username");
            textUsername.fill("Admin");

            Locator textPassword = page.getByPlaceholder("Password");
            textPassword.fill("admin123");

            Locator buttonLogin = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Login "));
            buttonLogin.click();

            Thread.sleep(2000);

            Locator buttonPIM = page.locator("//div[1]/aside/nav/div[2]/ul/li[2]/a");
            buttonPIM.click();

            Locator buttonAddEmployee = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add "));
            buttonAddEmployee.click();

            Locator textFirstName = page.getByPlaceholder("First Name");
            textFirstName.fill("Agapito");

            Locator textMiddleName = page.getByPlaceholder("Middle Name");
            textMiddleName.fill("Mozoline");

            Locator textLastName = page.getByPlaceholder("Last Name");
            textLastName.fill("Cachahualpa");

            Locator interruptor = page.locator(".oxd-switch-input");
            interruptor.click();

            Thread.sleep(1000);

            Locator checkStatus = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Disabled"));
            checkStatus.click();

            Locator textMyUser = page.locator(".oxd-input");
            textMyUser.fill("AgapitoCachahualpa");

            Locator textMyPassword = page.locator("//div[3]/div/div[1]/div/div[2]");
            textMyPassword.fill("estrella2024");

            Locator textConfirmPassword = page.locator("//div[4]/div/div[2]/div/div[2]/input");
            textConfirmPassword.fill("estrella2024");



            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencia.png")));
        }
    }
}