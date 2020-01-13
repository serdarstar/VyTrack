package com.cybertek.tests;

import com.cybertek.pages.*;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCases_4 extends TestBase {

    @Test
    public void Test1() throws InterruptedException {
        extentLogger=report.createTest("Test 1");
        extentLogger.info("Login");
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginPage.loginBtn.click();

//        Login olmanin degisik bir yolu
//        String username=ConfigurationReader.get("storemanager_username");
//        String password=ConfigurationReader.get("storemanager_password");
//        loginPage.login(username,password);
//        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
        extentLogger.info("Activities");
        DashboardPage dashboardPage=new DashboardPage();
        Thread.sleep(3000);
        dashboardPage.Activities.click();
        dashboardPage.CalendarEvents.click();

        AllCalendarEvents allCalendarEvents=new AllCalendarEvents();
        Thread.sleep(3000);
        extentLogger.info("Dropdown check");
        action.clickAndHold(allCalendarEvents.Dropdown).perform();

        Thread.sleep(2000);

        List<String> ExpectedMenu = new ArrayList<>();
        ExpectedMenu.add("View");
        ExpectedMenu.add("Edit");
        ExpectedMenu.add("Delete");


        BrowserUtils.waitFor(5);
        List<String> scMenu = allCalendarEvents.SaveAndCloseMenu();
        for(int i = 0; i<ExpectedMenu.size(); i++) {
            Assert.assertEquals(scMenu.get(i), ExpectedMenu.get(i), "Verify that actual matches expected");
        }

        Assert.assertTrue(allCalendarEvents.launcher_item.isDisplayed());


    }
    //PASS
    @Test
    public void Test2() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

        DashboardPage dashboardPage = new DashboardPage();
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.Activities));
        Thread.sleep(3000);
        dashboardPage.Activities.click();
        dashboardPage.CalendarEvents.click();

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();

        wait.until(ExpectedConditions.visibilityOf(allCalendarEvents.GridSettings));
        allCalendarEvents.GridSettings.click();
//        allCalendarEvents.selected.click();
//        allCalendarEvents.titleCheckBox.click();
        allCalendarEvents.calendarCheckBox.click();
        allCalendarEvents.endCheckBox.click();
        allCalendarEvents.invitationCheckBox.click();
        allCalendarEvents.recurrenceCheckBox.click();
        allCalendarEvents.recurrentCheckBox.click();
        allCalendarEvents.startCheckBox.click();
        Assert.assertTrue(allCalendarEvents.titleColumn.isDisplayed());


    }
    //PASS
    @Test
    public void Test3() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

        DashboardPage dashboardPage = new DashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.Activities));
        Thread.sleep(3000);
        dashboardPage.Activities.click();
        dashboardPage.CalendarEvents.click();
        Thread.sleep(3000);
        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        wait.until(ExpectedConditions.visibilityOf(allCalendarEvents.createCalendarEvent));
        allCalendarEvents.createCalendarEvent.click();

        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        wait.until(ExpectedConditions.visibilityOf(createCalendarEvent.saveAndCloaseExpand));
        Thread.sleep(5000);
        createCalendarEvent.saveAndCloaseExpand.click();

        List<WebElement> list=driver.findElements(By.xpath("//li/button"));

        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String> list2=new ArrayList<String>();
        list2.add("Save And Close");
        list2.add("Save And New");
        list2.add("Save");

        List<String> list3 = Arrays.asList("Save And Close","Save And New","Save");

        for (WebElement webElement : list) {
            Assert.assertTrue(webElement.isDisplayed());
            System.out.println(webElement.getText());
            list1.add(webElement.getText());

        }
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        Assert.assertTrue(list1.equals(list2));
        Assert.assertTrue(list1.equals(list3));


    }
    @Test
    public void Test4() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

        DashboardPage dashboardPage = new DashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.Activities));
        Thread.sleep(3000);
        dashboardPage.Activities.click();
        dashboardPage.CalendarEvents.click();

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        wait.until(ExpectedConditions.visibilityOf(allCalendarEvents.createCalendarEvent));
        Thread.sleep(5000);
        allCalendarEvents.createCalendarEvent.click();

        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        wait.until(ExpectedConditions.visibilityOf(createCalendarEvent.saveAndCloaseExpand));
        Thread.sleep(5000);
        createCalendarEvent.cancelButton.click();

        Thread.sleep(5000);
        Assert.assertTrue(allCalendarEvents.allCalendarEventsText.isDisplayed());

    }
    @Test
    public void Test5() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

        DashboardPage dashboardPage = new DashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.Activities));
        Thread.sleep(7000);
        dashboardPage.Activities.click();
        dashboardPage.CalendarEvents.click();

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        wait.until(ExpectedConditions.visibilityOf(allCalendarEvents.createCalendarEvent));
        Thread.sleep(3000);
        allCalendarEvents.createCalendarEvent.click();
        Thread.sleep(3000);

      //  WebElement time=driver.findElement(By.xpath("(//input[@placeholder='time'])[1]"));
        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        Thread.sleep(3000);

//        WebElement element=driver.findElement(By.xpath("//input[@id='time_selector_oro_calendar_event_form_start-uid-5e086ac3df58c']"));
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].click();",element);


//        WebElement dropDownListBox = driver.findElement(By.xpath("(//input[@placeholder='time'])[1]"));
//        ((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", dropDownListBox, "blablabla");

            createCalendarEvent.timeStart.click();
            action.click(createCalendarEvent.timeStart).perform();

//        BrowserUtils.getElementsText(By.xpath("//div[@class ='ui-timepicker-wrapper']//li"));


        List<WebElement> buttons = driver.findElements(By.xpath("//div[@class ='ui-timepicker-wrapper']//li"));
//
//
//        for (WebElement button : buttons) {
//            System.out.println(button.getText());
//        }

        ArrayList<String> hours=new ArrayList<>();

        for (int i = 0; i < buttons.size(); i++) {

            WebElement element1=buttons.get(i);
            String innerHTML=element1.getAttribute("innerHTML");

//            butun secenekleri yazdirmak icin
            System.out.println("innerHTML = " + innerHTML.substring(0,5));

//            AM PM kismini atmak icin
            hours.add(innerHTML.substring(0,5));

        }
        System.out.println("hours.get(3) = " + hours.get(3));
        System.out.println("hours.get(5) = " + hours.get(5));

        String str=hours.get(3);
        String[] array = str.split(":");
        String firstHour=array[0].concat(array[1]);
        System.out.println("firstHour = " + firstHour);

        String str2=hours.get(5);
        String[] array2 = str2.split(":");
        String secondHour=array2[0]+array2[1];
        System.out.println("secondHour = " + secondHour);

//        String firstHourRegularString="130";
//        String secondHourRegularString="230";
//        int a=Integer.parseInt(firstHourRegularString);
//        int b=Integer.parseInt(secondHourRegularString);
//        int c=b-a;
//        System.out.println("c = " + c);


        double firstHourInteger=Double.parseDouble(firstHour);
        double secondHourInteger=Double.parseDouble(secondHour);
        System.out.println(secondHourInteger-firstHourInteger);

        int firstHourInteger2=(int)firstHourInteger;
        int secondHourInteger2=(int)secondHourInteger;
        int result=secondHourInteger2-firstHourInteger2;
//
        Assert.assertTrue(result==100);





//        int a=Integer.parseInt(array[0]);
//        int b=Integer.parseInt(array[1]);
//        int c=a+b;
//        System.out.println("c = " + c);

//  Tablodaki saatleri secemiyorum

//        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
//        Thread.sleep(5000);
//        Select hours=new Select(time);
//        List<WebElement> options=hours.getOptions();
//        System.out.println("options = " + options);

    }

    @Test
    public void Test6() throws InterruptedException {
        extentLogger=report.createTest("Test 6");
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.Activities.click();
        dashboardPage.CalendarEvents.click();

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        allCalendarEvents.waitUntilLoaderScreenDisappear();
        allCalendarEvents.createCalendarEvent.click();

        extentLogger.info("Click 9:00 PM");
        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        createCalendarEvent.waitUntilLoaderScreenDisappear();
        createCalendarEvent.timeStart.click();
//        action.click(createCalendarEvent.timeStart).perform();
        createCalendarEvent.selectTime("9:00 PM").click();


        createCalendarEvent.timeEnd.click();
        String endTime= createCalendarEvent.getSelectedEndTime.getText();
        Assert.assertEquals(endTime, "10:00 PM");

//
//        List<WebElement> buttons = driver.findElements(By.xpath("//ul[@class ='ui-timepicker-list']/li"));
//
//        for (int i = 0; i < buttons.size(); i++) {
//
//            WebElement element1=buttons.get(i);
//            String innerHTML=element1.getAttribute("innerHTML");
//            System.out.println("innerHTML = " + innerHTML);
////            hours.add(innerHTML);
//
//            if(innerHTML.equals("9:00 PM")){
//                element1.click();
//
//            }
//        }

    }

    @Test
    public void Test7() throws InterruptedException {
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

        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        Thread.sleep(3000);
        createCalendarEvent.allDayEventCeheckBox.click();
        Thread.sleep(2000);
        Assert.assertFalse(createCalendarEvent.timeStart.isDisplayed());
        Assert.assertFalse(createCalendarEvent.timeEnd.isDisplayed());
        Assert.assertTrue(createCalendarEvent.startDay.isDisplayed());
        Assert.assertTrue(createCalendarEvent.endDay.isDisplayed());

    }
    @Test
    public void Test8() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

        DashboardPage dashboardPage = new DashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.Activities.click();
        dashboardPage.CalendarEvents.click();

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        allCalendarEvents.waitUntilLoaderScreenDisappear();
        allCalendarEvents.createCalendarEvent.click();

        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        createCalendarEvent.repeatOptions.click();
        String defaultRepeatOption= createCalendarEvent.defaultRepeat.getText();
        Assert.assertEquals(defaultRepeatOption,"Daily");

//        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
//        List<WebElement> actualOptions = createCalendarEvent.repeatOptionsList().getOptions();
//        List<String> actualList = BrowserUtils.getElementsText(actualOptions);
//        Assert.assertEquals(actualList,expectedList,"Compare dropdown values");

        Select repeatOptions=new Select(createCalendarEvent.repeatDropdownOptions);

        List<WebElement> options=repeatOptions.getOptions();
        ArrayList<String> options2=new ArrayList<>();
        for (WebElement s : options) {
            options2.add(s.getText());
        }
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        Assert.assertEquals(options2, expectedList);


    }


    @Test
    public void Test9() throws InterruptedException {
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
        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        Thread.sleep(3000);
        createCalendarEvent.repeatOptions.click();
        Assert.assertTrue(createCalendarEvent.repeatEveryRadioButton.isSelected());

//        Assert.assertTrue(createCalendarEvent.neverRadioButton.isSelected());
        Assert.assertTrue(createCalendarEvent.summaryMessage.isDisplayed());


    }
    @Test
    public void Test10() throws InterruptedException {
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
        createCalendarEvent.afterRadioButton.click();
        createCalendarEvent.afterInputBox.sendKeys("10");
        createCalendarEvent.dailyMessage.click();
        Assert.assertTrue(createCalendarEvent.afterMessage.isDisplayed());



    }
    @Test
    public void Test11() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

        DashboardPage dashboardPage = new DashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.Activities));
        Thread.sleep(2000);
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
        createCalendarEvent.byRadioButton.click();
        createCalendarEvent.chooseDateCheckBox.click();

        Select datePickerYear=new Select(createCalendarEvent.datePickerYear);
        List<WebElement> years=datePickerYear.getOptions();
        datePickerYear.selectByVisibleText("2021");

        Select datePickerMonth=new Select(createCalendarEvent.datePickerMonth);
        List<WebElement> months=datePickerMonth.getOptions();
        datePickerMonth.selectByVisibleText("Nov");
        createCalendarEvent.nov18.click();
        createCalendarEvent.dailyMessage.click();
        Assert.assertTrue(createCalendarEvent.novemberDisplay.isDisplayed());

    }
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
