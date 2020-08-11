package Benicomp.TestData;

import Benicomp.Utils.ExcelUtil;
import com.codoid.products.fillo.Recordset;

import java.util.Date;

public class ContactTestData {

    private String First_name, Last_name,Contact_Position;

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getContact_Position() {
        return Contact_Position;
    }

    public void setContact_Position(String contact_Position) {
        Contact_Position = contact_Position;
    }

    @Override
    public String toString() {
        return "ContactTestData{" +
                "First_name='" + First_name + '\'' +
                ", Last_name='" + Last_name + '\'' +
                ", Contact_Position='" + Contact_Position + '\'' +
                '}';
    }

    public void GetData(String testId) throws Exception
    {
        Recordset rs = ExcelUtil.GetTestData("ContactData", testId);
        Date d = new Date(System.currentTimeMillis());
        while (rs.next()) {
            //First_Name
            this.setFirst_name(rs.getField("First_Name"));

            //Last_Name
            this.setLast_name(rs.getField("Last_name"));

            //Client_URL
            this.setContact_Position(rs.getField("Contact_Position"));

            //Address_Line_1



        }//End while
        rs.close();
    }
}
