package Benicomp.Tests.Home;

import Benicomp.Modules.Client;
import Benicomp.Modules.Home;
import Benicomp.Modules.LoginOut;
import Benicomp.Utils.WaitTool;
import Benicomp.Utils.TestBase;
import org.testng.annotations.Test;


public class BCP003_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool wt = new WaitTool();
    Home home = new Home();


    @Test(description = "To verify that User is able to Navigate all Left Panel Links", groups = {"Home"})
    public void BCP003() throws Exception {

        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        wt.implicitwait();


        home.navigateAllLeftMenuLinks();





    }
}