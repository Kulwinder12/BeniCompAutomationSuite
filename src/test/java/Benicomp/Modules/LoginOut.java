package Benicomp.Modules;

import Benicomp.Locators.LoginOutRepo;
import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.Common;
import com.codeborne.selenide.WebDriverRunner;
import Benicomp.Utils.Log;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Benicomp.Utils.Common.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * @author smartData
 * <h1>Login and Logout </h1>
 * <p>Purpose: This class is used for ProcessForm_SafetyDataSheet and logout form applications</p>
 * It is used to handle ProcessForm_SafetyDataSheet and logout form applications
 **/
public class LoginOut {
    /**
     * <h1>Login to Application<h1/>
     * <p>Purpose: This method is used to login to application  </p>
     *
     * @param actor
     * @throws Exception
     */

    public void loginAs(Actor actor) throws Exception {
        switch (actor) {
            case USERNAME_USERS:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.UserName_Users.getUserURL());
                LoginUser(GlobalTestData.UserName_Users.getUserId(), GlobalTestData.UserName_Users.getPassword());
               // Log.info("User logged in successfully.");
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                break;



            default:
                Assert.assertTrue(false, "Not a valid user type.");
        }
    }

    /**
     * <h1>Logout from Application<h1/>
     * <p>Purpose: This method is used to logout from</p>
     *
     * @throws Exception
     */
   public void logout() throws Exception {

        Log.info("Logging out the user");
        sleep(2000);
        /*$(LoginOutRepo.uatAdmin).click();
        sleep(1000);
        $(LoginOutRepo.logout).click();
        Log.info("Logout successful");*/
        moveToElement(By.cssSelector("img[alt='Profile Picture']"));
       $(LoginOutRepo.logout).click();

    }


    /**
     * <h1>Change URL<h1/>
     * <p>Purpose: This method is used to change url</p>
     *
     * @throws Exception
     */
    public void changeUrl() {
        url();
    }

    public static enum Actor {USERNAME_USERS}
}
