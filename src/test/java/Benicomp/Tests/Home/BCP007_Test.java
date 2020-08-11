package Benicomp.Tests.Home;


import Benicomp.Modules.Home;
import Benicomp.Modules.LoginOut;
import Benicomp.TestData.GlobalTestData;

import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;

import org.testng.annotations.Test;

public class BCP007_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool waitTool = new WaitTool();
    Home home = new Home();


    @Test(description = "To verify the validations on Add Article Page", groups = {"Home"})
    public void BCP007() throws Exception {

        GlobalTestData.Article_TestData.GetData(getClass().getSimpleName());
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        waitTool.implicitwait();

        home.validationsCheckonAddArticles();
        logTestStepPass("All the Validations are Verified");

    }
}