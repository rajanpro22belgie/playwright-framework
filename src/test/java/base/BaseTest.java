package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.extension.ExtendWith;
import listeners.TestListener;


@ExtendWith(TestListener.class)
public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    public Page page;

    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setSlowMo(100)
        );
        page = browser.newPage();
    }

    public void teardown() {
        browser.close();
        playwright.close();
    }
}
