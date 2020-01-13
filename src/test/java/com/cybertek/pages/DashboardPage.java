package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    //no ned to explicitly write constructors, because it will use its parents constructor.
    public DashboardPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a/span[contains(text(),'Activities')][1]")
    public WebElement Activities;

    @FindBy (xpath = "//span[text()='Calendar Events']")
    public  WebElement CalendarEvents;









}
