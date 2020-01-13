package com.cybertek.tests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest_DataProvider extends TestBase {
    @DataProvider
    public Object[][] testData(){
        ExcelUtil data=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");
        String[][] dataArray=data.getDataArrayWithoutFirstRow();
        return dataArray;
    }
    @Test(dataProvider = "testData")
    public void Logintest(String user_name, String pass_word, String firt_name, String last_name){
        extentLogger=report.createTest("Login Test with DDF and Data Provider");
        LoginPage loginPage=new LoginPage();
        loginPage.login(user_name, pass_word);
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        String actualname=dashboardPage.getUserName();
        String expectednname=firt_name+" "+last_name;
        Assert.assertEquals(actualname, expectednname, "Compares fullname");



    }
}
