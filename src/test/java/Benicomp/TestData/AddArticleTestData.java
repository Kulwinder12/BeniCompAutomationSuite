package Benicomp.TestData;
import Benicomp.Utils.ExcelUtil;
import com.codoid.products.fillo.Recordset;


import java.util.Date;

public class AddArticleTestData {

    public String Title, Content;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "AddArticleTestData{" +
                "Title='" + Title + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }

    public void GetData(String testId) throws Exception {
        Recordset rs = ExcelUtil.GetTestData("AddArticle", testId);
        Date d = new Date(System.currentTimeMillis());
        long timeMilli = d.getTime();
        while (rs.next()) {
            //Title
            this.setTitle(rs.getField("Title") + ' ' + timeMilli);

            //Content
            this.setContent(rs.getField("Content") + ' ' + timeMilli);


        }
    }
}