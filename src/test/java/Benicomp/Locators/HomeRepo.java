package Benicomp.Locators;

import org.openqa.selenium.By;

public class HomeRepo {


    //Left Menu
    public static By linkUserManager = By.xpath("//a[contains(@class,'nav-link dropdown-toggle active')][@title='User Manager']");
    public static By linkHealthData = By.xpath("//a[contains(@class,'nav-link dropdown-toggle')][@title='Health Data']");
    public static By linkManageHealthData = By.xpath("//a[@id ='ManageHealthData']");
    public static By linkmanageClaims=By.xpath("//a[@id ='ManageClaims']");
    public static By linkClaims= By.xpath("//a[contains(@class,'nav-link dropdown-toggle')][@title='Claims']");
    public static By linkImportantDocuments= By.xpath("//a[contains(@class,'nav-link dropdown-toggle')][@title='Important Documents']");
    public static By linkforms= By.xpath("//a[contains(@class,'nav-link dropdown-toggle')][@title='Forms']");
    public static By linkContactforms= By.xpath("//a[@id ='contactForm']");
    public static By linkAppealforms= By.xpath("//a[@id ='appealForm']");
    public static By linkChangeforms= By.xpath("//a[@id ='changeForm']");
    public static By linkSurveysforms= By.xpath("//a[@id ='surveyManager']");
    public static By linkaccounting= By.xpath("//a[contains(@class,'nav-link dropdown-toggle')][@title='Accounting']");
    public static By linkinvoiceManager= By.xpath("//a[@id ='invoiceManager']");
    public static By linkPayment= By.xpath("//a[@id ='check']");
    public static By linkSystemMainntaince= By.xpath("//a[contains(@class,'nav-link dropdown-toggle')][@title='System Maintenance']");
    public static By linkFaq= By.xpath("//a[@id ='faq']");
    public static By linkLoginLog= By.xpath("//a[@id ='loginlog']");
    public static By linkUploadManager= By.xpath("//a[contains(@class,'nav-link dropdown-toggle')][@title='Upload Manager']");
    public static By linkHelpCenter = By.xpath("//a[contains(@class,'nav-link dropdown-toggle')][@title='Help Center']");
    public static By linkKnowldgeBase= By.xpath("//a[@id ='KnowledgeBase']");
    public static By linkTickets= By.xpath("//a[@id ='tickets']");
    public static By getLinkFaq2= By.xpath("//a[@id ='faqs']");


    // Help Center
       // Add Articles
    public static By btnaddArticle = By.xpath("//button[@title='Create Article']");
    public static By txtTitle = By.xpath("//input[@formcontrolname='title']");
    public static By drpdownCategory = By.xpath("//button[@id='highlighttext1'][@type = 'button']");
    public static By selectHealthCoaching = By.xpath("//li[@class='dropdown-item '][2]");
    public static By txtArticle = By.xpath("//div[@class='ql-editor ql-blank']");
    public static By btnCreate = By.xpath("//button[contains(@class,'m-0 btn add-user')][contains(text(),'CREATE')]");
    public static By searchBox = By.xpath("//input[(@placeholder='Search for...')]");
    public static By btnEdit = By.xpath("//i[contains(@class,'fa fa-pencil')][@title='Edit']");
    public static By btnUpdate = By.xpath("//button[contains(@class,'m-0 btn add-user')][contains(text(),'UPDATE')]");
    public static By TxtArticle1 = By.xpath("//div[@class='ql-editor']");
    public static By btnDelete = By.xpath("//i[contains(@class,'icon-delete')][@title='Delete']");
    public static By dialogYes = By.xpath("//div[@role='dialog']//button[.='Yes']");
    public static By dialogNo = By.xpath("//div[@role='dialog']//button[.='No']");
    public static By filterCategory = By.xpath("//span[contains(@class,'filter-name')][contains(text(),' Category')]");
    public static By filterHealthCoaching = By.xpath("//span[contains(@class,'drop-name-text')][contains(text(),'Health Coaching')]");
    public static By filterAuthentication = By.xpath("//span[contains(@class,'filter-name')][contains(text(),'Athentication')]");




}
