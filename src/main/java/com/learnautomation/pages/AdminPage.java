package com.learnautomation.pages;

import com.learnautomation.helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    WebDriver driver;

    public AdminPage(WebDriver driver)
    {
        this.driver=driver;
    }

    By addUser=By.xpath("//button[text()=' Add ']");
    By userRole=By.xpath("//div[text()='-- Select --']");
    By empName=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    By username=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    By pass=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    By confirmPass=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    By meter=By.xpath("//span[contains(@id,'strength_meter')]");
    By saveButton=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    By successMsg=By.xpath("//*[contains(text(),'Successfully Saved') and @class]");


    public boolean createUser(String uRole,String employeeName,String uName,String status,String password) {
        boolean userStatus=false;
        driver.findElement(addUser).click();
        //Utility.selectFromDropDownUsingText(driver, userRole, uRole);
        Utility.selectCustomDropdownOption(driver, userRole, uRole);
        driver.findElement(empName).sendKeys(employeeName);
        driver.findElement(username).sendKeys(uName);
        driver.findElement(pass).sendKeys(password);
        driver.findElement(confirmPass).sendKeys(password);
        if(Utility.waitForWebElement(driver, meter).isDisplayed())
        {
            driver.findElement(saveButton).click();
        }

        if(Utility.waitForWebElement(driver, successMsg).isDisplayed())
        {
            userStatus=true;
        }
        return userStatus;
    }
}
