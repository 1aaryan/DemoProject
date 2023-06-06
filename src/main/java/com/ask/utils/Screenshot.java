package com.ask.utils;

import com.ask.base.BasePage;
import com.ask.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot extends BaseTest{


    public void failed(){
        File srcFile= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("/Users/aaryanfueled/IdeaProjects/DemoProject/src/Screenshots/testfailure.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
