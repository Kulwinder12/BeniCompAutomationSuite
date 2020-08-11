package Benicomp.Tests.Home;


import Benicomp.Locators.LoginOutRepo;
import Benicomp.Modules.LoginOut;
import Benicomp.Utils.Log;
import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static Benicomp.Utils.Common.DEFAULT_WAIT;
import static Benicomp.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class BCP001_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool wt = new WaitTool();


    @Test(description = "To verify that User is able to Login and Logout", groups = {"Home"})
    public void BCP001() throws Exception {

        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);

        wt.implicitwait();

        String svalue=$x("//img[@title='Benicomp']").waitUntil(Condition.visible,DEFAULT_WAIT).getAttribute("title");
        assertText(svalue,"Benicomp");
        logTestStep("Home page loaded successfully");
        objLoginOut.logout();
        logTestStep("Click log out");
        String value= $x("//p[.='Sign in to manage your account']").getText();
        assertText(value,"Sign in to manage your account");
        logTestStepPass("User logout successfully");
    }
}
