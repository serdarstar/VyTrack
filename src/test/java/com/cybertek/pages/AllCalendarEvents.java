package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AllCalendarEvents extends BasePage {

    @FindBy (xpath = "//table[@class='grid table-hover table table-bordered table-condensed']//td[.='Testers meeting']/../td[9]")
    public WebElement Dropdown;

    @FindBys({
            @FindBy (xpath = "//td[contains(text(),'Testers Meeting')]"),
            @FindBy(xpath = "(//a)[@class='dropdown-toggle']")
    })
    public WebElement testersMeeting;

    @FindBy (xpath = "(//div)[@class='loader-frame'][2]")
    public WebElement LoaderFrame;

    @FindBy(xpath = "//li[@class='launcher-item']")
    public WebElement launcher_item;

    @FindBy(xpath ="//i[@class='fa-cog hide-text']" )
    public WebElement GridSettings;

    @FindBy(xpath = "(//td)[@class='visibility-cell'][2]")
    public WebElement calendarCheckBox;

    @FindBy(xpath = "(//td)[@class='visibility-cell'][3]")
    public WebElement startCheckBox;

    @FindBy(xpath = "(//td)[@class='visibility-cell'][4]")
    public WebElement endCheckBox;

    @FindBy(xpath = "(//td)[@class='visibility-cell'][5]")
    public WebElement recurrentCheckBox;

    @FindBy(xpath = "(//td)[@class='visibility-cell'][6]")
    public WebElement recurrenceCheckBox;

    @FindBy(xpath = "(//td)[@class='visibility-cell'][7]")
    public WebElement invitationCheckBox;

    @FindBy (xpath = "(//td)[@class='title-cell'][1]")
    public WebElement titleColumn;

    @FindBy(xpath = "(//td)[@class='visibility-cell'][1]")
    public WebElement titleCheckBox;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy (linkText = "Selected")
    public WebElement selected;

    @FindBy (xpath = "//h1[contains(text(), 'Create Calendar event')]")
    public WebElement allCalendarEventsText;




    public List<String> SaveAndCloseMenu() {
        List<WebElement> SaveMenu = Driver.get().findElements(By.xpath("//ul[@class = 'nav nav-pills icons-holder launchers-list']//li/a"));
        List<String> saveItem = new ArrayList<>();
        for (WebElement each : SaveMenu) {
            saveItem.add(each.getAttribute("title"));
        }
        return saveItem;
    }

    public AllCalendarEvents(){
        PageFactory.initElements(Driver.get(),this);
    }

}
