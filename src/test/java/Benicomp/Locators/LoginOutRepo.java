package Benicomp.Locators;

import org.openqa.selenium.By;

public class LoginOutRepo {

    public static By txtUsername = By.xpath("//div[@id='pulse-auth']/pages-login/div[@class='landing_page']//form/div[3]/div/input");
    public static By txtPassword = By.xpath("//input[contains(@type,'password')]");
    public static By buttonSignin = By.xpath("//button[@title='Sign In']");
    public static By linkAdmin=By.xpath("By.cssSelector(\"img[alt='Profile Picture']\"");
    public static By logout= By.cssSelector(".dropdown-item.logout-btn");

}