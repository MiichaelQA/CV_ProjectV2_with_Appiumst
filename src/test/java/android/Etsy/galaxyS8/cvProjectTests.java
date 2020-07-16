package android.Etsy.galaxyS8;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testrail.APIException;

import java.io.IOException;

public class cvProjectTests extends testBase {

    bottomBarNavigation bottomBar;

    @BeforeMethod
    public void initTests(){
        bottomBar = PageFactory.initElements(driver,bottomBarNavigation.class);
    }

    @Test
    public void testFieldsAndClicks() throws IOException, APIException {
        bottomBar.bottomBarYou.click();
        bottomBar.waitUntilElementIsVisible(bottomBar.inviteToSignInButtom,40);
        bottomBar.inviteToSignInButtom.click();
        bottomBar.waitUntilElementIsClickable(bottomBar.userNameFieldSighIn,40);
        bottomBar.userNameFieldSighIn.sendKeys(emailForSignIn);
        bottomBar.passwordFieldSighIn.sendKeys(passwordForSignIn);
        bottomBar.sighInButton.click();
        bottomBar.waitUntilElementIsClickable(bottomBar.bottomBarYou,40);
        bottomBar.bottomBarYou.click();
        bottomBar.waitUntilElementIsClickable(bottomBar.buttomProfile,40);
        //RightNow this test will fail
        if(bottomBar.buttomProfile.getText().contains("Profileeee")){
            testBase.AddResultForTestCaseInTestRail("7", TEST_CASE_PASSED_STATUS);
            Assert.assertTrue(true);
        }else{
            testBase.AddResultForTestCaseInTestRail("7", TEST_CASE_FAILED_STATUS);
            screenshot("C:\\Users\\marac\\IdeaProjects\\TestMySuperTesmMaven\\untitled\\CV_Project_AndroidAutomationTest\\screens\\");
            Assert.fail();
        }
    }


}
