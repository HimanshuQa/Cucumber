package Keyword;

import Locators.LoginPageLocator;
import org.openqa.selenium.WebDriver;

public class LoginPageActions {

    LoginPageLocator loginPageLocator;

    public LoginPageActions(WebDriver driver) {
        loginPageLocator = new LoginPageLocator(driver);

    }

    public void sending_Credentials(String uname, String pwd) {

        loginPageLocator.getUsername().sendKeys(uname);
        loginPageLocator.getPassword().sendKeys(pwd);

    }

    public void click_Login() {
        loginPageLocator.getButton().click();

    }

}
