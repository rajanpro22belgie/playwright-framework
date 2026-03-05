package tests;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @BeforeEach
    public void start() {
        setup();
    }

    @AfterEach
    public void end() {
        teardown();
    }

    @Test
    public void verifyHomePageTitle() {
        LoginPage home = new LoginPage(page);
        home.navigate();
        Assertions.assertTrue(home.getTitle().contains("Playwright"));
    }
}
