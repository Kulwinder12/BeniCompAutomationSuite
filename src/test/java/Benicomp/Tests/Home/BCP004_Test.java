package Benicomp.Tests.Home;

import Benicomp.Modules.Home;
import Benicomp.Modules.LoginOut;
import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.Log;
import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BCP004_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool wt = new WaitTool();
    Home home = new Home();


    @Test(description = "To verify that User is able to add an Article", groups = {"Home"})
    public void BCP004() throws Exception {

        GlobalTestData.Article_TestData.GetData(getClass().getSimpleName());
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        wt.implicitwait();
        home.addArticle();
        Thread.sleep(5000);

        SelenideElement table = $$("div.table>table>tbody").filter(Condition.visible).first();
        String recordName = GlobalTestData.Article_TestData.getTitle();
        logTestStep("Search the Added Article");
        home.searchAddedRecord(recordName);
        logTestStep("Record Found");
        boolean resultPresent = Home.getAddedData(table, recordName);

        Assert.assertEquals(resultPresent,true, "added new record");
        logTestStepPass("Article Added and Verified");
    }
}