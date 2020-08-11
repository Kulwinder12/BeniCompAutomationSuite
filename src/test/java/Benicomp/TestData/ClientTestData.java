package Benicomp.TestData;
import Benicomp.Utils.ExcelUtil;
import com.codoid.products.fillo.Recordset;


import java.util.Date;

public class ClientTestData {

    private String Client_Name, Group_Number, Client_URL, Address_Line_1, Address_Line_2 , City , State ,Number_Of_Employees ,ZIP_Postal_Code ,Federal_ID ,Contact_FirstName ,Contact_LastName ,Contact_Email,Division_Name ,Policy_Issue_State ,Effective_Date_of_Insurance;

    public String getClient_Name() {
        return Client_Name;
    }

    public void setClient_Name(String client_Name) {
        Client_Name = client_Name;
    }

    public String getGroup_Number() {
        return Group_Number;
    }

    public void setGroup_Number(String group_Number) {
        Group_Number = group_Number;
    }

    public String getClient_URL() {
        return Client_URL;
    }

    public void setClient_URL(String client_URL) {
        Client_URL = client_URL;
    }

    public String getAddress_Line_1() {
        return Address_Line_1;
    }

    public void setAddress_Line_1(String address_Line_1) {
        Address_Line_1 = address_Line_1;
    }

    public String getAddress_Line_2() {
        return Address_Line_2;
    }

    public void setAddress_Line_2(String address_Line_2) {
        Address_Line_2 = address_Line_2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getNumber_Of_Employees() {
        return Number_Of_Employees;
    }

    public void setNumber_Of_Employees(String number_Of_Employees) {
        Number_Of_Employees = number_Of_Employees;
    }

    public String getZIP_Postal_Code() {
        return ZIP_Postal_Code;
    }

    public void setZIP_Postal_Code(String ZIP_Postal_Code) {
        this.ZIP_Postal_Code = ZIP_Postal_Code;
    }

    public String getFederal_ID() {
        return Federal_ID;
    }

    public void setFederal_ID(String federal_ID) {
        Federal_ID = federal_ID;
    }

    public String getContact_FirstName() {
        return Contact_FirstName;
    }

    public void setContact_FirstName(String contact_FirstName) {
        Contact_FirstName = contact_FirstName;
    }

    public String getContact_LastName() {
        return Contact_LastName;
    }

    public void setContact_LastName(String contact_LastName) {
        this.Contact_LastName = contact_LastName;
    }

    public String getContact_Email() {
        return Contact_Email;
    }

    public void setContact_Email(String contact_Email) {
        Contact_Email = contact_Email;
    }

    public String getDivision_Name() {
        return Division_Name;
    }

    public void setDivision_Name(String division_Name) {
        Division_Name = division_Name;
    }

    public String getPolicy_Issue_State() {
        return Policy_Issue_State;
    }

    public void setPolicy_Issue_State(String policy_Issue_State) {
        Policy_Issue_State = policy_Issue_State;
    }

    public String getEffective_Date_of_Insurance() {
        return Effective_Date_of_Insurance;
    }

    public void setEffective_Date_of_Insurance(String effective_Date_of_Insurance) {
        Effective_Date_of_Insurance = effective_Date_of_Insurance;
    }

    @Override
    public String toString() {
        return "ClientTestData{" +
                "Client_Name='" + Client_Name + '\'' +
                ", Group_Number='" + Group_Number + '\'' +
                ", Client_URL='" + Client_URL + '\'' +
                ", Address_Line_1='" + Address_Line_1 + '\'' +
                ", Address_Line_2='" + Address_Line_2 + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Number_Of_Employees='" + Number_Of_Employees + '\'' +
                ", ZIP_Postal_Code='" + ZIP_Postal_Code + '\'' +
                ", Federal_ID='" + Federal_ID + '\'' +
                ", Contact_FirstName='" + Contact_FirstName + '\'' +
                ", Contact_LastName='" + Contact_LastName + '\'' +
                ", Contact_Email='" + Contact_Email + '\'' +
                ", Division_Name='" + Division_Name + '\'' +
                ", Policy_Issue_State='" + Policy_Issue_State + '\'' +
                ", Effective_Date_of_Insurance='" + Effective_Date_of_Insurance + '\'' +
                '}';
    }

    public void GetData(String testId) throws Exception
    {
        Recordset rs = ExcelUtil.GetTestData("ClientData", testId);
        Date d = new Date(System.currentTimeMillis());
        long timeMilli = d.getTime();
        while (rs.next()) {
            //Client_Name
            this.setClient_Name(rs.getField("Client_Name") + ' ' + timeMilli);

            //Group_Number
            this.setGroup_Number(rs.getField("Group_Number")+ ' ' + timeMilli);

            //Client_URL
            this.setClient_URL(rs.getField("Client_URL"));

            //Address_Line_1
            this.setAddress_Line_1(rs.getField("Address_Line_1"));

            // Address_Line_2
            this.setAddress_Line_2(rs.getField("Address_Line_2"));

            //City
            this.setCity(rs.getField("City"));

            //City
            this.setState(rs.getField("State"));

            //ZIP_Postal_Code
            this.setZIP_Postal_Code(rs.getField("ZIP_Postal_Code"));

            //Federal_ID
            this.setFederal_ID(rs.getField("Federal_ID"));

            //Contact_FirstName
            this.setContact_FirstName(rs.getField("Contact_FirstName"));

            // Contact_LastName
            this.setContact_LastName(rs.getField("Contact_LastName"));

            //Contact_Email
            this.setContact_Email(rs.getField("Contact_Email"));

            //Division_Name
            this.setDivision_Name(rs.getField("Division_Name"));

            //"Number_Of_Employees
            this.setNumber_Of_Employees(rs.getField("Number_Of_Employees"));

            //Policy_Issue_State
            this.setPolicy_Issue_State(rs.getField("Policy_Issue_State"));



        }//End while
        rs.close();
    }






}

