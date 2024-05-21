package utils;

import driver_init.DriverInit2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyTestListeners2 implements ITestListener {

    public static void makeScreenShot(String name){
        File screenshotFile = ((TakesScreenshot) DriverInit2.startDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("./target/screenshots/" + name + ".png"));
        }catch (IOException e){}
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
        makeScreenShot(result.getMethod().getMethodName());
    }
}
