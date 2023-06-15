package Utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Config implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult Result) {
        saveScreenshotPNG();
        saveTextLog(Result.getMethod().getConstructorOrMethod().getName() + "Screenshot Saved.");
    }

}