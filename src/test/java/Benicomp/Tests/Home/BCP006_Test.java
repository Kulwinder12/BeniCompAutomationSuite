package Benicomp.Tests.Home;

import Benicomp.Locators.HomeRepo;
import Benicomp.Modules.Home;
import Benicomp.Modules.LoginOut;
import Benicomp.Utils.Common;
import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Benicomp.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$$;

public class BCP006_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool waitTool = new WaitTool();
    Home home = new Home();


    @Test(description = "To verify that User is able to Delete an Article", groups = {"Home"})
    public void BCP006() throws Exception {


        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        waitTool.implicitwait();

        ClickElement(HomeRepo.linkHelpCenter, "Click Help Center");
        WaitTool.waitForPageLoadToComplete();

        ClickElement(HomeRepo.linkKnowldgeBase, "Click Knowledge Base");
        WaitTool.waitForPageLoadToComplete();

        Thread.sleep(5000);

        SelenideElement table = $$("div.table>table>tbody").filter(Condition.visible).first();
        String recordName = Common.getArticle();
        logTestStep("Search the Added Article");
        home.searchAddedRecord(recordName);
        logTestStep("Record Found");
        home.deleteArticle();

    }
}