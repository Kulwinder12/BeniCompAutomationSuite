package Benicomp.Locators;

import org.openqa.selenium.By;

public class ClientRepo {

    //Client Screen
    public static By btnAdduser = By.xpath("//button[@title='Add User']");
    public static By linkClient = By.cssSelector(".drop-right.dropdown-menu.dropdown-menu-auto.show > li:nth-of-type(2)");
    public static By txtClientName = By.xpath("//input[contains(@formcontrolname, 'ClientName')]");
    public static By txtGroupName = By.xpath("//input[contains(@formcontrolname, 'GroupNumber')]");
    public static By txtClientUrl = By.xpath("//input[contains(@formcontrolname, 'ClientUrl')]");
    public static By txtAddress1 = By.xpath("//input[contains(@formcontrolname, 'StreetAddress')]");
    public static By txtAddress2 = By.xpath("//input[contains(@formcontrolname, 'AddressLine2')]");
    public static By txtCity = By.xpath("//input[contains(@formcontrolname, 'City')]");
    public static By txtState = By.xpath("//input[contains(@formcontrolname, 'name')]");
    public static By txtZipCode = By.xpath("//input[contains(@formcontrolname, 'PostalCode')]");
    public static By selectCountry = By.xpath("//button[@class ='btn btn-dropdown form-control dropdown-toggle']");
    public static By txtFedredId = By.xpath("//input[contains(@formcontrolname, 'FederalId')]");
    public static By btnSave = By.xpath("//button[@type ='submit']");
    public static By btnCancel = By.xpath("//button[text()=' Cancel ']");
    public static By btnEdit = By.xpath("//button[@title='Edit']");
    public static By btnBack = By.xpath("//button[@title='Back']");
    public static By chkIncenticare = By.xpath("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'BeniCompAdvantage')]");
    public static By chkBenicompSelect = By.xpath("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'BeniCompSelect')]");
    public static By chkQSHERA = By.xpath("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'qsehraSelect')]");
    public static By linkProfile = By.xpath("//a[contains(@class,'nav-link')][contains(text(),'Profile')]");
    public static By linkContact = By.xpath("//a[contains(@class,'nav-link')][contains(text(),'Contacts')]");
    public static By linkDivison = By.xpath("//a[contains(@class,'nav-link')][contains(text(),'Divison')]");
    public static By linkNotes = By.xpath("//a[contains(@class,'nav-link')][contains(text(),'Notes')]");


    //Contact Screen

   // public static By btnAddcontact = By.xpath("//button[@title='Add Contact']");
   public static By btnAddcontact = By.xpath("//button[contains(text(),'Add Contact ')]");

    public static By txtFirstName = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::input[contains(@formcontrolname, 'FirstName')]");
    public static By txtLastName = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::input[contains(@formcontrolname, 'LastName')]");
    public static By txtcntctPosition = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::input[contains(@formcontrolname, 'Position')]");
    public static By txtCntctEmail = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::input[contains(@formcontrolname, 'Email')]");
    public static By drpdwndivison = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::form//label[.=' Division ']");
    public static By chkPrimaryContact = By.xpath("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'primaryContact')]");
    public static By chkAccountingContact = By.xpath("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'accountingContact')]");
    public static By chkMarketingContact = By.xpath("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'marketingContact')]");
    public static By chkAdministrator = By.xpath("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'IsAdministrator')]");
    public static By btnContactCancel = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::button[contains(text(),' Cancel ')]");
    public static By btnContactsave = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::button[contains(text(),'Save')]");

    //Divison Screen
    public static By btnADivision = By.xpath("//button[@title='Add Division']");
    public static By txtDivisonName = By.xpath("//input[contains(@formcontrolname, 'ClientName')]");
    public static By txtNumberofEmp = By.xpath("//input[contains(@formcontrolname, 'NoOfEmployee')]");
    public static By btnDivisionCancel = By.xpath("//h4[text()='Create Division']//ancestor::div[2]//child::button[text()=' Cancel ']");
    public static By btnDivisionSave = By.xpath("//h4[text()='Create Division']//ancestor::div[2]//child::button[text()=' Save ']");


    //IncentiCare Screen
    public static By txtPolicyIssueState = By.xpath("//label[text()='Policy Issue State ']//ancestor::div[1]//child::input[contains(@formcontrolname, 'name')]");
    public static By drpdownEffectiveDate = By.xpath("//input[contains(@formcontrolname, 'IncenticarebenefitYear')]");
    public static By radioselectEmp1 = By.xpath("//ul[@class='enrollment-level-options']//ancestor::div[2]//child::div[1]//child::input[1]");
    public static By radioselectEmp2 = By.xpath("//ul[@class='enrollment-level-options']//ancestor::div[2]//child::div[2]//child::input[1]");
    public static By radioselectEmp3 = By.xpath("//ul[@class='enrollment-level-options']//ancestor::div[2]//child::div[3]//child::input[1]");
    public static By radioselectEmp4 = By.xpath("//ul[@class='enrollment-level-options']//ancestor::div[2]//child::div[4]//child::input[1]");
    public static By btnAddBenifitYear = By.xpath("//div[@class='col-md-12 col-pmd-5']//button[@class='btn green-btn']");



}