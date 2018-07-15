/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepdefs;

import Keyword.LoginPageActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 *
 * @author HIM
 */
public class Loginpage {

    WebDriver driver;
    LoginPageActions loginPageActions;
    List list = new ArrayList();

    public List getList() {
        return list;
    }
    
    public void launch_Browser() {
        driver = new ChromeDriver();
        System.out.println("Browser has been launched ");
    }

    @Given("^I opened the browser and navigate to webpage$")
    public void openBrowser() {
        launch_Browser();
        driver.get("https://hris.qainfotech.com/login.php");
        loginPageActions = new LoginPageActions(driver);
    }

    @When("^I enter correct username (.*) and correct password (.*)$")
    public void i_enter_username_tomsmith_and_password_SuperSecretPassword(String userName, String password)
            throws Throwable {

        loginPageActions.sending_Credentials(userName, password);
        loginPageActions.click_Login();
    }

    @Then("^I will be  successfully logged in$")
    public void i_am_able_to_login_using_correct_credentials() throws Throwable {
        Assert.assertEquals("https://hris.qainfotech.com:8086/time/timesheet", driver.getCurrentUrl());
        list.add("MOB-1"); 
        driver.close();

    }

    @When("^I enter incorrect username (.*) and incorrect password (.*)$")
    public void i_enter_incorrect_username_and_incorrect_password(String userName, String password) throws Throwable {

        loginPageActions.sending_Credentials(userName, password);
        loginPageActions.click_Login();
    }

    @Then("^I will see an error message$")
    public void i_am_able_to_see_error_msg() throws Throwable {

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]")).isDisplayed());
        list.add("MOB-2");
        driver.close();

    }

    
}
