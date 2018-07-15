/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author HIM
 */
public class LoginPageLocator {

//    WebDriver driver;

    @FindBy(id = "txtUserName")
    private WebElement username;

    @FindBy(id = "txtPassword")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement button;

    public LoginPageLocator(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getButton() {
        return button;
    }

}
