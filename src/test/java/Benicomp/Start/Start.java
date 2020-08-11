package Benicomp.Start;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import Benicomp.Urls.Urls;
import Benicomp.Utils.Log;
import Benicomp.Utils.SelenideLogEvents;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static com.codeborne.selenide.Selenide.open;


/**
 * @author smartData
 * <h1>Initialized Browser</h1>
 * <p>Purpose: This class is used to initialized browser </p>
 * It is used to handle all the functionalities related with AccountTests module
 **/
public class Start {
    public static String currentBrowser = "";
    public static Map<Long, String> browserWindows = new HashMap<>();

    public static WebDriver getDriverInstance() {
        return WebDriverRunner.getWebDriver();
    }
    public static String GetDefaultWindow() {
        return browserWindows.get(Thread.currentThread().getId());
    }

    //This method is used to Save Default browser Window
    public static void SaveDefaultWindow() {
        browserWindows.put(Thread.currentThread().getId(), WebDriverRunner.getWebDriver().getWindowHandle());
    }

    /**
     * <h1>Close all extra window of browser expect Default</h1>
     */
    public synchronized static void CloseExtraWindows() {
        Log.info("Close extra windows and switch back to default window");
        String defaultWindow = GetDefaultWindow();
        for (String win : WebDriverRunner.getWebDriver().getWindowHandles()) {
            if (!win.equals(defaultWindow)) {
                WebDriverRunner.getWebDriver().switchTo().window(win);
                WebDriverRunner.getWebDriver().close();
            }
        }//End for
        WebDriverRunner.getWebDriver().switchTo().window(defaultWindow);
        Log.pass("Switched back to default window");
    }


    /**
     * <h1>Initialize Browser <h1/>
     * <p>Purpose: This method is used to Initialize Browser</p>
     */

    protected static void InitilizeBrowser() throws Exception {
        //Selenide Configuration
        WebDriver driver;
        Configuration.fastSetValue = true;
        Configuration.screenshots = false;
        Configuration.startMaximized = true;
      //  Configuration.collectionsTimeout = 60000;
        Configuration.timeout = 15000;
    //    Configuration.setValueChangeEvent = true;

        if (currentBrowser.equalsIgnoreCase("ChromeHeadfull")) {
            Log.info("Starting Chrome browser");
            ChromeDriverManager.chromedriver().version("83").setup();
            Configuration.browser = WebDriverRunner.CHROME;
       //     ChromeDriverManager.getInstance().setup();
            ChromeOptions chromeOptions = new ChromeOptions();

            //Disable Notification in chrome
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            chromeOptions.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(chromeOptions);
            WebDriverRunner.setWebDriver(driver);

        } else if (currentBrowser.equalsIgnoreCase("ChromeHeadless")) {
            Log.info("Starting Headless Chrome browser");
         //   ChromeDriverManager.getInstance().setup();
            ChromeDriverManager.chromedriver().version("83").setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("window-size=1366,768");
            driver = new ChromeDriver(chromeOptions);
            WebDriverRunner.setWebDriver(driver);
        } else if (currentBrowser.equalsIgnoreCase("FirefoxHeadless")) {
            Log.info("Starting Headless Firefox browser");
       //     FirefoxDriverManager.getInstance().setup();
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("marionette", "true");
            FirefoxBinary fb = new FirefoxBinary();
            fb.addCommandLineOptions("--headless");
            Configuration.browser = WebDriverRunner.FIREFOX;
            driver = new FirefoxDriver(dc);
            WebDriverRunner.setWebDriver(driver);
        } else if (currentBrowser.equalsIgnoreCase("FirefoxHeadfull")) {
            Log.info("Starting Headfull Firefox browser");
        //    FirefoxDriverManager.getInstance().setup();
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("marionette", "true");
            Configuration.browser = WebDriverRunner.FIREFOX;
            driver = new FirefoxDriver(dc);
            WebDriverRunner.setWebDriver(driver);

        } else if (currentBrowser.equalsIgnoreCase("RunInGrid")) {
            Log.info("Starting Grid browser");
            //If we want to run
            Configuration.browser = WebDriverRunner.CHROME;
            Configuration.remote = "http://172.24.3.181:5555/wd/hub";
        } else {
            //Default browser
            Configuration.browser = WebDriverRunner.CHROME;
        }
        //Start.ReadCookiesFromFile("Requester");
        open(Urls.baseUrl);
        SaveDefaultWindow();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        com.codeborne.selenide.logevents.SelenideLogger.addListener("BrowserLogs", new SelenideLogEvents());
    }

    public static void WriteCookiesToFile(String filename) {
        File file;
        try {
            file = new File(filename + ".txt");
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            for (Cookie ck : WebDriverRunner.getWebDriver().manage().getCookies()) {
                Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();

            System.out.println("Write Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//End Write

    public static void ReadCookiesFromFile(String fileName) {
        try {
            File file = new File(fileName + ".txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while ((strline = Buffreader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(strline, ";");
                while (token.hasMoreTokens()) {
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;
                    String val;
                    if (!(val = token.nextToken()).equals("null")) {

                        expiry = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(val);
                        System.out.println("String Token Date:" + val);
                        System.out.println("Date:" + expiry);
                        //expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken());
                    Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                    System.out.println(ck);
                    WebDriverRunner.getWebDriver().manage().addCookie(ck); // This will add the stored cookie to your current session
                }//End while

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}//End class
