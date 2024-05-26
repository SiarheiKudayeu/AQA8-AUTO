package utils;

import driver_init.DriverInit2;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyAllureTestListeners implements ITestListener {
    @Attachment(value = "Page Screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot){
        return screenshot;
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " started!!!");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " passed!!!");

    }
    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(((TakesScreenshot) DriverInit2.startDriver()).getScreenshotAs(OutputType.BYTES));
    }
}
