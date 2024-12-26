import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class Test1 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
           // Browser browser = playwright.chromium().launch();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(10));
            Page page = browser.newPage();
            page.navigate("http://www.google.com");
            System.out.println(page.title());

            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }
}
