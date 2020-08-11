package Benicomp.Modules;

import Benicomp.Locators.HomeRepo;
import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.Common;
import Benicomp.Utils.Log;
import Benicomp.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static Benicomp.Utils.Common.*;
import static Benicomp.Utils.Common.assertText;
import static Benicomp.Utils.TestBase.logTestStepPass;
import static Benicomp.Utils.TestBase.logTestStepPassOrFail;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class Home {

    public void navigateAllLeftMenuLinks() throws Exception {

        ClickElement(HomeRepo.linkUserManager, "Click User Manager");
        WaitTool.waitForPageLoadToComplete();



        WebElement elm = $$x("//h1[contains(@class,'page-heading')]").filter(visible).last();

        String tvalue1=  elm.getText();
        assertText(tvalue1, "User Manager");
        logTestStepPass("User can see User Manager page ");

        ClickElement(HomeRepo.linkHealthData, "Click Heath Data");

        ClickElement(HomeRepo.linkManageHealthData, "Click Manage Health");
        String tvalue2=  elm.getText();
        assertText(tvalue2, "Health Data");
        logTestStepPass("User can see Health page ");

        ClickElement(HomeRepo.linkmanageClaims, "Click Manage Claim");
        String tvalue3=  elm.getText();
        assertText(tvalue3, "Claims");
        logTestStepPass("User can see Claims page ");

        ClickElement(HomeRepo.linkClaims, "Click Claims");
        WaitTool.waitForPageLoadToComplete();
        String tvalue5 = elm.getText();
        assertText(tvalue5, "Claims Manager");
        logTestStepPass("User can see Claims Manager page ");


        ClickElement(HomeRepo.linkImportantDocuments, "Click Important Documents");
        String tvalue6 = elm.getText();
        assertText(tvalue6, "Important Documents");
        logTestStepPass("User can see Important Documents page ");

        ClickElement(HomeRepo.linkforms, "Click Forms");
        WaitTool.waitForPageLoadToComplete();


        ClickElement(HomeRepo.linkContactforms, "Click Contact Forms");
        String tvalue8 = elm.getText();
        assertText(tvalue8, "Contact Form Manager");
        logTestStepPass("User can see Contact Form Manager page ");

        ClickElement(HomeRepo.linkAppealforms, "Click Appeal Forms");
        String tvalue9 = elm.getText();
        assertText(tvalue9, " Appeal Form Manager");
        logTestStepPass("User can see Appeal Form Manager Page ");

        ClickElement(HomeRepo.linkChangeforms, "Click Change Forms");
        String tvalue10 = elm.getText();
        assertText(tvalue10, "Change Form");
        logTestStepPass("User can see Change Form Page");

        ClickElement(HomeRepo.linkSurveysforms, "Click Survey Forms");
        String tvalue11 = elm.getText();
        assertText(tvalue11, "Surveys");
        logTestStepPass("User can see Surveys Page");

        ClickElement(HomeRepo.linkaccounting, "Click Accounting");
        WaitTool.waitForPageLoadToComplete();


        ClickElement(HomeRepo.linkinvoiceManager, "Click Invoice Manager");
        String tvalue13 = elm.getText();
        assertText(tvalue13, "Invoice Manager");
        logTestStepPass("User can see Invoice Manager Page");

        ClickElement(HomeRepo.linkPayment, "Click Payment");
        String tvalue14 = elm.getText();
        assertText(tvalue14, "Manager");
        logTestStepPass("User can see Payment Manager Page");

        ClickElement(HomeRepo.linkSystemMainntaince, "System Maintenance");
        WaitTool.waitForPageLoadToComplete();


     /*  ClickElement(HomeRepo.linkFaq, "Click FAQ");
       String tvalue16=elm.getText();
       assertText(tvalue16,"User Manager");*/

        ClickElement(HomeRepo.linkLoginLog, "Click Login Log");
        String tvalue17 = elm.getText();
        assertText(tvalue17, " Login Manager");
        logTestStepPass("User can see Login Manager Page");


        ClickElement(HomeRepo.linkUploadManager, "Click Upload Manager");
        String tvalue18 = elm.getText();
        assertText(tvalue18, "Upload Manager");
        logTestStepPass("User can see Upload Manager Page");

        ClickElement(HomeRepo.linkHelpCenter, "Click HelpCenter");
         WaitTool.waitForPageLoadToComplete();

        ClickElement(HomeRepo.linkKnowldgeBase, "Click Knowledge Base");
        String tvalue20 = elm.getText();
        assertText(tvalue20, "Knowledge Base");
        logTestStepPass("User can see Knowledge Base Page");

        ClickElement(HomeRepo.linkTickets, "Click Ticket");
        String tvalue21 = elm.getText();
        assertText(tvalue21, "Tickets");
        logTestStepPass("User can see Tickets Page");

        ClickElement(HomeRepo.getLinkFaq2, "Click FAQ");
        String tvalue22 = elm.getText();
        assertText(tvalue22, "Frequently Asked Questions");
        logTestStepPass("User can see Frequently Asked Questions Page");


    }

    public void addArticle() throws Exception {

        ClickElement(HomeRepo.linkHelpCenter, "Click Help Center");
        WaitTool.waitForPageLoadToComplete();

        ClickElement(HomeRepo.linkKnowldgeBase, "Click Knowledge Base");
        WaitTool.waitForPageLoadToComplete();

        ClickElement(HomeRepo.btnaddArticle, "Click Add Article Button");
        WaitTool.waitForPageLoadToComplete();

        ClearAndSendKeys(HomeRepo.txtTitle, GlobalTestData.Article_TestData.getTitle(), " Add Title");
        ClickElement(HomeRepo.drpdownCategory, "Click Category");
        ClickElement(HomeRepo.selectHealthCoaching, "Select health Coaching");

        ClearAndSendKeys(HomeRepo.txtArticle, GlobalTestData.Article_TestData.getContent(), "Add Content");
        scrollandClick(HomeRepo.btnCreate);

        Common.saveArtileTitle(GlobalTestData.Article_TestData.getTitle());

    }

    public static List<String> getAllArticles() {
        List<String> articles = new ArrayList<>();
        SelenideElement table = $("div.table");
        for (SelenideElement row : table.$$("tbody tr")) {
            articles.add(row.$("td", 1).text());
        }

        return articles;
    }

    public static Boolean getAddedData(SelenideElement ele, String recordName) {
        List<String> listData = ele.$$("tr:nth-child(1)>td").texts();
        boolean result = false;
        for (String strDocName : listData) {
            if (strDocName.equalsIgnoreCase(recordName)) {
                result = true;
                break;
            } else continue;
        }
        return result;
    }

    public void searchAddedRecord(String recordname) throws InterruptedException {

        WebElement txtSrc = $(HomeRepo.searchBox).waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
        txtSrc.click();
        Log.info("Search Box Clicked");
        txtSrc.sendKeys(recordname);
        Log.info("Search With Record Name");
        sleep(500);
        txtSrc.sendKeys(Keys.ENTER);
        sleep(500);


    }


    public void editArticle() throws Exception {


        ClickElement(HomeRepo.btnEdit ,"Click Edit Button ");
        WaitTool.waitForPageLoadToComplete();


        ClearAndSendKeys(HomeRepo.txtTitle, GlobalTestData.Article_TestData.getTitle(), " Add Title");
        ClickElement(HomeRepo.drpdownCategory, "Click Category");
        ClickElement(HomeRepo.selectHealthCoaching, "Select health Coaching");

        ClearAndSendKeys(HomeRepo.TxtArticle1, GlobalTestData.Article_TestData.getContent(), "Add Content");
        scrollandClick(HomeRepo.btnUpdate);

        Common.saveArtileTitle(GlobalTestData.Article_TestData.getTitle());

    }
    public void deleteArticle() throws Exception {


        ClickElement(HomeRepo.btnDelete ,"Click Edit Button ");
       ClickElement(HomeRepo.dialogYes , "Click on Yes Button");

        Thread.sleep(5000);
        Common.RefreshPage();

      String AtricleToDelete =  Common.getArticle();
        List<String> list = new ArrayList<>();
        for (SelenideElement elm : $$("tr:nth-child(1)>td").filter(visible)) {
            list.add(elm.text());
            System.out.println(list);


        }
        logTestStepPassOrFail(!list.contains(AtricleToDelete), "Verify Article " + AtricleToDelete + "deleted");

    }
    public void validationsCheckonAddArticles() throws Exception {

        // To check that Category is mandatory field
        ClickElement(HomeRepo.linkHelpCenter, "Click Help Center");
        WaitTool.waitForPageLoadToComplete();

        ClickElement(HomeRepo.linkKnowldgeBase, "Click Knowledge Base");
        WaitTool.waitForPageLoadToComplete();

        ClickElement(HomeRepo.btnaddArticle, "Click Add Article Button");
        WaitTool.waitForPageLoadToComplete();
        ClearAndSendKeys(HomeRepo.txtTitle, GlobalTestData.Article_TestData.getTitle(), " Add Title");
        ClearAndSendKeys(HomeRepo.txtArticle, GlobalTestData.Article_TestData.getContent(), "Add Content");
        moveToElement(HomeRepo.btnCreate);

       SelenideElement btn= $x("//button[contains(@class,'m-0 btn add-user')][contains(text(),'CREATE')]");
       //boolean createButton = btn.isEnabled();
        boolean createButton = isClickable(HomeRepo.btnCreate);
       Assert.assertEquals(createButton,false, "Create Button is enabled");
       logTestStepPass("Create Button is disbaled when Categoty is not selected");
       sleep(1000);


       // To check that Title Field is Mandatory
        moveToElement(HomeRepo.txtTitle);
        doubleClick(HomeRepo.txtTitle);

       $x("//input[@formcontrolname='title']").sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE));
      // $x("//input[@formcontrolname='title']").sendKeys(Keys.BACK_SPACE); // To clear Title Field


        ClickElement(HomeRepo.drpdownCategory, "Click Category");
        ClickElement(HomeRepo.selectHealthCoaching, "Select health Coaching");
        moveToElement(HomeRepo.btnCreate);
        boolean createButton2 = isClickable(HomeRepo.btnCreate);
        Assert.assertEquals(createButton2,false, "Create Button is enabled");
        logTestStepPass("Create Button is disbaled when Title is not selected");

        // To Check that Article text is mandatory.

        ClearAndSendKeys(HomeRepo.txtTitle, GlobalTestData.Article_TestData.getTitle(), " Add Title");
        $x("//div[@class='ql-editor']").sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE));
       // $x("//div[@class='ql-editor']").sendKeys(Keys.DELETE);
      //  Clearfield(HomeRepo.TxtArticle1 , "Clear Article Filed");
        moveToElement(HomeRepo.btnCreate);
        boolean createButton1 = isClickable(HomeRepo.btnCreate);
        Assert.assertEquals(createButton1,false, "Create Button is enabled");
        logTestStepPass("Create Button is disbaled when Article Text is not selected");

    }

    public static void verifyFiltersonAtricle(){




    }

    }

