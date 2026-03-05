package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("https://playwright.dev/");
    }

    public String getTitle() {
        return page.title();
    }
}
