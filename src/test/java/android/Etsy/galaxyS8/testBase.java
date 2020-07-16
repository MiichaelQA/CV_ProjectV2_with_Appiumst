package android.Etsy.galaxyS8;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import testrail.APIClient;
import testrail.APIException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class testBase {

    public AppiumDriver driver;

    public String emailForSignIn = "etsytestingforcvproject@gmail.com";
    public String passwordForSignIn = "1234567890";
    public DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

    public static String TestRailRunId    = "5" ;
    public static String TestRailUsername = "qaautomationcvproject@gmail.com";
    public static String TestRailPassword = "ue8h5hnORDN.wcGj9Rhh";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;
    public static APIClient client = new APIClient("https://qaautomationcvprojectgmail.testrail.io/");

    public void screenshot(String path_screenshot) throws IOException {
        File ScreenshotFailTest = driver.getScreenshotAs(OutputType.FILE);
        String ScreenShotFailTestDate = dateFormat.format(new Date());
        File targetScreenshot =new File(path_screenshot + ScreenShotFailTestDate+".jpg");
        FileUtils.copyFile(ScreenshotFailTest, targetScreenshot);
    }



    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception{

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android" );
        dc.setCapability("deviceName","GalaxyS8" );
        dc.setCapability("platformVersion","8.1");
        dc.setCapability("appPackage","com.etsy.android");
        dc.setCapability("appActivity","com.etsy.android.ui.homescreen.HomescreenMainActivity");
        dc.setCapability("automationName","Appium");
        dc.setCapability("app", "C:/Users/marac/IdeaProjects/TestMySuperTesmMaven/untitled/CV_Project_AndroidAutomationTest/apk/com.etsy.android_2020-06-29.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public static void AddResultForTestCaseInTestRail(String TestCaseId, int status)
            throws IOException, APIException {
        client.setUser(TestRailUsername);
        client.setPassword(TestRailPassword);

        Map data = new HashMap();
        data.put("status_id", status);
        data.put("comment", "This test worked fine!");
        JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" +TestRailRunId+ "/"+TestCaseId+"", data);
    }

}
