package com.ask.utils;

import com.ask.base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    public void onTestStart(ITestResult result){

    }

    public void onTestSuccess(ITestResult result){

    }

    public void onTestFailure(ITestResult result){
        System.out.println("Failed test");
        new Screenshot().failed();
    }

    public void onTestSkipped(ITestResult result){

    }

}
