package Benicomp.Utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import Benicomp.Start.Start;

import java.util.HashMap;
import java.util.Map;

public class ReportUtil {

    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public static synchronized ExtentTest startTest(String testName, String desc, String[] category) {
        ExtentTest test = extent.startTest(testName, desc);
        for (String c : category) {
            test.assignCategory(c);
        }
        test.assignCategory(Start.currentBrowser);

        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }


}
