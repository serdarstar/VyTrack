package com.cybertek.tests;

import com.cybertek.pages.AllCalendarEvents;
import com.cybertek.pages.CreateCalendarEvent;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class multiple extends TestBase {
    @Test
    public void Test12() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

        DashboardPage dashboardPage = new DashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.Activities));
        Thread.sleep(4000);
        dashboardPage.Activities.click();
        dashboardPage.CalendarEvents.click();

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        wait.until(ExpectedConditions.visibilityOf(allCalendarEvents.createCalendarEvent));
        Thread.sleep(3000);
        allCalendarEvents.createCalendarEvent.click();
        Thread.sleep(3000);
        CreateCalendarEvent createCalendarEvent = new CreateCalendarEvent();
        Thread.sleep(3000);
        createCalendarEvent.repeatOptions.click();
        Thread.sleep(3000);


        Select options=new Select(createCalendarEvent.repeatDropdownOptions);
        List<WebElement> days=options.getOptions();
        options.selectByVisibleText("Weekly");
        createCalendarEvent.monday.click();
        createCalendarEvent.friday.click();
        Assert.assertTrue(createCalendarEvent.monday.isSelected());
        Assert.assertTrue(createCalendarEvent.friday.isSelected());
        createCalendarEvent.summaryMessage2.click();
        Assert.assertTrue(createCalendarEvent.mondayFridayMessage.isDisplayed());



    }
}
