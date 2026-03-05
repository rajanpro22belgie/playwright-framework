package listeners;

import org.junit.jupiter.api.extension.*;
import com.aventstack.extentreports.*;
import reporting.ReportManager;
import utils.ScreenshotUtil;
import base.BaseTest;

public class TestListener implements TestWatcher, BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        String testName = context.getDisplayName();
        ExtentTest extentTest = ReportManager.getReporter().createTest(testName);
        test.set(extentTest);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        test.get().pass("Test Passed");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        BaseTest instance = (BaseTest) context.getRequiredTestInstance();
        String screenshotPath = ScreenshotUtil.capture(instance.page, context.getDisplayName());
        test.get().fail(cause).addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        ReportManager.getReporter().flush();
    }
}
