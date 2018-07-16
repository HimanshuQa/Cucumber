/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepdefs;

import Keyword.LoginPageActions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
	String pypath = "/home/himanshuchaudhary/anaconda3/bin/python";
	String pass = "pass";
	String fail = "fail";
	
	
	public void launch_Browser() {
		System.setProperty("webdriver.chrome.driver", "/home/himanshuchaudhary/Downloads/chromedriver");

		driver = new ChromeDriver();
		System.out.println("Browser has been launched ");
	}	
	
	@After
	public void after(Scenario scenario){
		
		String id = scenario.getSourceTagNames().toArray()[0].toString().substring(1);
		String status = scenario.getStatus();
		if(status.equals("failed"))
			uploadstatus(id, status,"invalid");
		else
			uploadstatus(id, status,"valid");

	
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

		driver.close();

	}

	@When("^I enter incorrect username (.*) and incorrect password (.*)$")
	public void i_enter_incorrect_username_and_incorrect_password(String userName, String password) throws Throwable {

		loginPageActions.sending_Credentials(userName, password);
		loginPageActions.click_Login();
	}

	@Then("^I will see an error message$")
	public void i_am_able_to_see_error_msg() throws Throwable {

		Assert.assertTrue(!driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]")).isDisplayed());

		driver.close();

	}
	
	public String uploadstatus(String id , String status, String title){
		String s = null;
		Process p;
		try {
			p = Runtime.getRuntime().exec(""+pypath+" upload.py "+ id + " " +status+ " "+title);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			// read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}

}
