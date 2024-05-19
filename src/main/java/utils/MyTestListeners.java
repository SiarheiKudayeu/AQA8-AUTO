package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListeners implements ITestListener {
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
        System.out.println("Test with name " + result.getMethod().getMethodName() + " failed!!!");

    }
}
