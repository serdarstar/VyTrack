package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEvent extends BasePage{

    @FindBy(css = "a.btn-success.btn.dropdown-toggle")
            //(xpath= "//span[@class='caret']") //a.btn-success.btn.dropdown-toggle
    public WebElement saveAndCloaseExpand;

    @FindBy(xpath = "//a[@title='Cancel']")
    public WebElement cancelButton;

    @FindBy (xpath = "(//input[@placeholder='time'])[1]")
    public WebElement timeStart;

    @FindBy (xpath = "(//input[@placeholder='time'])[2]")
    public WebElement timeEnd;

    @FindBy (xpath = "(//div/input[@type='checkbox'])[1]")
    public WebElement allDayEventCeheckBox;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[1]")
    public WebElement startDay;

    @FindBy (xpath = "(//input[@placeholder='Choose a date'])[2]")
    public WebElement endDay;

    @FindBy (xpath = "//ul[@class ='ui-timepicker-list']/li[(text()='9:00 PM')]")
    public WebElement hour930PM;

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public  WebElement repeatOptions;

    @FindBy (xpath = "(//div[@class='selector input-widget-select'])[1]")
    public WebElement repeatOptionsBox;

    @FindBy (css = "[id^='recurrence-repeats-view']")
    public WebElement repeatDropdownOptions;

    @FindBy (xpath = "//div[@class='controls recurrence-subview-control__items']//label[@class='fields-row']//input[1]")
    public WebElement repeatEveryRadioButton;

    @FindBy (xpath = "(//span[@class='recurrence-subview-control__text'])[2]")
    public WebElement neverRadioButton;

    @FindBy(xpath = "//span[contains(text(),'Daily every 1 day')]")
    public WebElement summaryMessage;

    @FindBy(xpath = "//span[contains(text(),'After')]")
    public WebElement afterRadioButton;

    @FindBy (xpath = "//input[@data-related-field='occurrences']")
    public WebElement afterInputBox;

    @FindBy(xpath = "//span[contains(text(),', end after 10 occurrences')]")
    public WebElement afterMessage;

    @FindBy (xpath = "//span[contains(text(),'Daily every 1 day')]")
    public WebElement dailyMessage;

    @FindBy (xpath = "(//input[@placeholder='Choose a date'])[3]")
    public WebElement chooseDateCheckBox;

    @FindBy (xpath = "//select[@class='ui-datepicker-year']")
    public WebElement datePickerYear;
    @FindBy (xpath = "//select[@class='ui-datepicker-month']")
    public WebElement datePickerMonth;

    @FindBy (xpath = "//a[contains(text(),'18')]")
    public WebElement nov18;

    @FindBy (xpath = "(//span[contains(text(),'By')])[5]")
    public WebElement byRadioButton;

    @FindBy (xpath = "//span[contains(text(),', end by Nov 18, 2021')]")
    public WebElement novemberDisplay;

    @FindBy (css = "[id^='recurrence-repeat-view']")
    public WebElement repeatDropdownBox;

    @FindBy (xpath = "//input[@value='monday']")
    public WebElement monday;

    @FindBy (xpath = "//input[@value='friday']")
    public WebElement friday;

    @FindBy (xpath = "//span[contains(text(),'Weekly every 1 week on Monday, Friday')]")
    public WebElement mondayFridayMessage;

    @FindBy(xpath = "(//li[contains(@class,'selected')])[2]")
    public WebElement getSelectedEndTime;

    @FindBy (xpath = "//span[@style='width: 292px; user-select: none;']")
    public WebElement defaultRepeat;

    @FindBy(xpath = "//span[contains(text(),'Weekly every 1 week on Monday, Friday')]")
    public WebElement summaryMessage2;

    public Select repeatOptionsList(){
        return new Select(repeatDropdownOptions);
    }




    public WebElement getHour(String str){
        String xpathHour="//ul[@class ='ui-timepicker-list']/li[(text()='"+str+"')]";
        WebElement hour=Driver.get().findElement(By.xpath(xpathHour));
        return hour;


    }
    public WebElement selectTime(String clock){

        String clockXpath = "//li[contains(text(),'" + clock + "')]";
        WebElement clockTime = Driver.get().findElement(By.xpath(clockXpath));

        return clockTime;
    }







    public CreateCalendarEvent(){
        PageFactory.initElements(Driver.get(),this);
    }
}
