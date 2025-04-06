package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement usernameNew;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='txtPassword']") WebElement passwordNew;
    By username=By.xpath("//input[@name='username']");
    By password=By.xpath("//input[@name='password']");
    By loginButton=By.xpath("//button[@type='submit']");
    By socialMediaLinks=By.xpath("//div[@id='social-icons']//img");

    public DashboardPage loginToApplication(String uname,String pass)
    {
        driver.findElement(username).sendKeys(uname);
        //usernameNew.sendKeys(uname);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        DashboardPage dash=new DashboardPage(driver);
        return dash;
    }

    public int countSocialLinks()
    {
        return driver.findElements(socialMediaLinks).size();
    }

    public String getCurrentURL()
    {
        return driver.getCurrentUrl();
    }
}
