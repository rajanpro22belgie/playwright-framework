package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.extension.ExtendWith;
import listeners.TestListener;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(TestListener.class)
public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    public Page page;

    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(100)
        );
        page = browser.newPage();
    }

    public void teardown() {
        browser.close();
        playwright.close();
    }
}
