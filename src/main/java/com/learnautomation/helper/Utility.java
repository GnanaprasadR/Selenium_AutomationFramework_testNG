package com.learnautomation.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utility {

    public static void selectFromDropDownUsingText(WebDriver driver, By locator, String valueToBeSelected)
    {
        Select sel=new Select(driver.findElement(locator));
        sel.selectByVisibleText(valueToBeSelected);
    }

    public static void selectFromDropDownUsingValue(WebDriver driver,By locator,String valueToBeSelected)
    {
        Select sel=new Select(driver.findElement(locator));
        sel.selectByValue(valueToBeSelected);
    }

    public static void selectFromDropDownUsingIndex(WebDriver driver,By locator,int indexToBeSelected)
    {
        Select sel=new Select(driver.findElement(locator));
        sel.selectByIndex(indexToBeSelected);
    }

    public static WebElement waitForWebElement(WebDriver driver,By locator)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return ele;
    }

    public static void clickElement(WebDriver driver,By locator)
    {
        try
        {
            waitForWebElement(driver, locator).click();
        }
        catch(Exception e)
        {
            System.out.println("LOG:INFO- WebElement click did not work Trying with JS Click");

            JavascriptExecutor js=(JavascriptExecutor)driver;

            js.executeScript("arguments[0].click()",waitForWebElement(driver, locator));

        }
    }

    public static void switchToParentFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static String captureAlertTextAndAccept(WebDriver driver) {
        Alert alt = driver.switchTo().alert();

        String alt_msg = alt.getText();

        alt.accept();

        return alt_msg;
    }

    public static String captureDateTime() {
        // SimpleDateFormat myformat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");

        return new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
    }

    // It wont take screenshot of Alerts
    public static String captureScreenShot(WebDriver driver) throws WebDriverException, IOException {
        String screenshotPath = System.getProperty("user.dir") + "/ScreenShots/Selenium" + captureDateTime() + ".png";

        FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(screenshotPath));

        return screenshotPath;
    }

    public static String captureFullPageScreenShot(WebDriver driver) throws WebDriverException, IOException {
        String screenshotPath = System.getProperty("user.dir") + "/ScreenShots/Selenium_" + captureDateTime() + ".png";

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        ImageIO.write(screenshot.getImage(), "png", new File(screenshotPath));

        return screenshotPath;
    }

    // it will capture ss of webelement
    public static String captureScreenShot(WebDriver driver, WebElement element) throws IOException {
        File src = element.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/ScreenShots/Selenium" + captureDateTime() + ".png";

        FileHandler.copy(src, new File(path));

        return path;
    }

}
