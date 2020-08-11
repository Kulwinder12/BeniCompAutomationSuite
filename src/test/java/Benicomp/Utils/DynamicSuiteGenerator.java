package Benicomp.Utils;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DynamicSuiteGenerator {
    public static void GenerateSuite() throws Exception {
        List<TestConfig> lstTestConfig = ExcelUtil.GetTestSuite();
        System.out.println("----Test Configuration object------");
        System.out.println("Total modules: " + lstTestConfig.size());
        XmlSuite suite = new XmlSuite();
        suite.setName("Benicomp Test Suite");
        List excludeGroup = new ArrayList<String>();
        excludeGroup.add("broken");

        //Add Tests into Suite
        for (TestConfig testConfig : lstTestConfig) {
            System.out.println("Test module details" + testConfig.toString());
            XmlTest test = new XmlTest(suite);
            test.setName(testConfig.getModuleName() + "-Tests");
            test.setPreserveOrder(true);
            test.setExcludedGroups(excludeGroup);
            //If Test is parallel
            if (testConfig.getParallel().equalsIgnoreCase("Yes")) {
                int threadCount =Integer.parseInt(testConfig.getParallelCount());
                if(threadCount>0){
                    test.setParallel(XmlSuite.ParallelMode.CLASSES);
                    test.setThreadCount(Integer.parseInt(testConfig.getParallelCount()));
                }

            }
            //Set XmlClasses
            test.setXmlClasses(FilterXmlClasse(testConfig.getModuleName(), testConfig.getTestsList()));
        }
        writeSuiteToFile(suite);
    }//End of function > GenerateSuite

    //Filter Xml Class based on Module and enabled test names
    private static List<XmlClass> FilterXmlClasse(String moduleName, List<String> tetsIds) {
        String packageName = "Benicomp.Tests.Benicomp";
        switch (moduleName) {
            case "Benicomp":
                packageName = packageName + "";
                break;

        }//End Switch

        //Create XmlClasses
        List<XmlClass> xmlClasses = new ArrayList<XmlClass>();
        for (String testName : tetsIds) {
            String strClass = packageName + "." + testName;
            XmlClass xmlClass = new XmlClass(strClass);
            //Add current xml class to list
            xmlClasses.add(xmlClass);
        }
        return xmlClasses;
    }

    //Write Xml Suite to File
    private static void writeSuiteToFile(XmlSuite suite) {
        String xmlpath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "suite-xml-files" + File.separator + "Benicomp Test Suite.xml";
        File f = new File(xmlpath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(f);
            fr.write(suite.toXml().toString());
        } catch (IOException e) { e.printStackTrace(); }
        finally {
            //close resources
            try {  fr.close(); }
            catch (IOException e) { e.printStackTrace();}
        }//End finally
    }//End> writeSuiteToFile
}//End Class
