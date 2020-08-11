package Benicomp.Modules;

import Benicomp.Locators.ClientRepo;
import Benicomp.Locators.HomeRepo;
import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.WaitTool;

import static Benicomp.Utils.Common.*;

public class Client {

   public void addUser() throws Exception {


       ClickElement(HomeRepo.linkUserManager , "Click User Manager");
       ClickElement(ClientRepo.btnAdduser, "Button Add User");
       ClickElement(ClientRepo.linkClient ,"Client Link");
       WaitTool.waitForPageLoadToComplete();
       ClearAndSendKeys(ClientRepo.txtClientName ,GlobalTestData.Client_Users.getClient_Name(),"Adding Client Name");
       ClearAndSendKeys(ClientRepo.txtGroupName ,GlobalTestData.Client_Users.getGroup_Number(),"Adding Group Number");
       ClearAndSendKeys(ClientRepo.txtClientUrl ,GlobalTestData.Client_Users.getClient_URL(),"Adding Client URL");
       ClearAndSendKeys(ClientRepo.txtAddress1 ,GlobalTestData.Client_Users.getAddress_Line_1(),"Adding Address");
       ClearAndSendKeys(ClientRepo.txtCity ,GlobalTestData.Client_Users.getCity(),"Adding City");
       ClearAndSendKeys(ClientRepo.txtState ,GlobalTestData.Client_Users.getState(),"Adding State");
       ClearAndSendKeys(ClientRepo.txtZipCode ,GlobalTestData.Client_Users.getZIP_Postal_Code(),"Adding Zip Code");
       ClearAndSendKeys(ClientRepo.txtFedredId ,GlobalTestData.Client_Users.getFederal_ID(),"Adding Fedral Id");
       ClickElement(ClientRepo.btnSave,"Save button Click");

       // Add Contact Details

       scrollTo(ClientRepo.linkContact);
       ClickElement(ClientRepo.linkContact,"Contact Link");
       ClickElement(ClientRepo.btnAddcontact,"Add Contact Button Clicked");
       ClearAndSendKeys(ClientRepo.txtFirstName ,GlobalTestData.Contact_Users.getFirst_name(),"Adding First Name");
       ClearAndSendKeys(ClientRepo.txtLastName ,GlobalTestData.Contact_Users.getLast_name(),"Adding Last Name");
       ClearAndSendKeys(ClientRepo.txtcntctPosition ,GlobalTestData.Contact_Users.getContact_Position(),"Adding Contact Position");
       ClickElement(ClientRepo.chkPrimaryContact ,"Primary Contact");
       ClickElement(ClientRepo.btnContactsave ,"Save Contact");

       //Add Division Details

       scrollTo(ClientRepo.linkDivison);

   }


    public static void verifyQSERAwithOtherProducts() throws Exception {

        ClickElement(HomeRepo.linkUserManager , "Click User Manager");
        ClickElement(ClientRepo.btnAdduser, "Button Add User");
        ClickElement(ClientRepo.linkClient ,"Client Link");
        WaitTool.waitForPageLoadToComplete();
        ClearAndSendKeys(ClientRepo.txtClientName ,GlobalTestData.Client_Users.getClient_Name(),"Adding Client Name");
        ClearAndSendKeys(ClientRepo.txtGroupName ,GlobalTestData.Client_Users.getGroup_Number(),"Adding Group Number");
        WaitTool.waitForPageLoadToComplete();







    }
}
